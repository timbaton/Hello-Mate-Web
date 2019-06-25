package tim.mytrello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import tim.mytrello.form.EventNewForm;
import tim.mytrello.security.CustomUserDetails;
import tim.mytrello.service.EventService;
import tim.mytrello.service.FileStorageService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by timurbadretdinov on Jun, 2019
 **/
@Controller
public class NewEventController {

    @Autowired
    private EventService eventService;

    @GetMapping({"/event_new"})
    public String openLogin() {
        return "event_new";
    }

    @PostMapping("/event_new")
    public String uploadMultipleFiles(EventNewForm eventNewForm, Authentication authentication) {
        CustomUserDetails customUser = (CustomUserDetails)authentication.getPrincipal();
        long userId = customUser.getId();

        eventService.addEvent(eventNewForm, userId);
        return "event_new";
    }
}
