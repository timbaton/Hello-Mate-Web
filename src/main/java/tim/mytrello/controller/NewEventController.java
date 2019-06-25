package tim.mytrello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import tim.mytrello.entity.Users;
import tim.mytrello.form.EventNewForm;
import tim.mytrello.repository.UserRepository;
import tim.mytrello.security.CustomUserDetails;
import tim.mytrello.service.EventService;
import tim.mytrello.service.FileStorageService;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by timurbadretdinov on Jun, 2019
 **/
@Controller
public class NewEventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping({"/event_new"})

    public String openLogin() {
        return "event_new";
    }

    @PostMapping("/event_new")
    public String uploadMultipleFiles(EventNewForm eventNewForm, Authentication authentication) throws ParseException {
        CustomUserDetails customUser = (CustomUserDetails) authentication.getPrincipal();
        Integer userId = customUser.getId();

        Optional<Users> ownerOpt = userRepository.findById(userId);
        if (ownerOpt.isPresent()) {
            Users owner = ownerOpt.get();
            eventService.addEvent(eventNewForm, owner);
        } else throw new IllegalArgumentException("User not found");

        return "main";
    }
}
