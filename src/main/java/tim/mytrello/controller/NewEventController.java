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

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
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

    @GetMapping({"event/new"})
    public String openLogin() {
        return "event_new";
    }

    @PostMapping("event/new")
    public String addNewEvent(EventNewForm eventNewForm, Authentication authentication) throws IOException {
        CustomUserDetails customUser = (CustomUserDetails) authentication.getPrincipal();
        Integer userId = customUser.getId();

        Optional<Users> ownerOpt = userRepository.findById(userId);
        if (ownerOpt.isPresent()) {
            Users owner = ownerOpt.get();

            String dateString = eventNewForm.getDate();
            Date date = null;
            SimpleDateFormat dateFromString = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
            dateFromString.setLenient(false);
            try {
                date = dateFromString.parse(dateString);
                System.out.println(date);
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            assert date != null;
            long dateTimeStamp = date.getTime();

            eventNewForm.setDate(Long.toString(dateTimeStamp));
            eventService.addEvent(eventNewForm, owner);
        } else throw new IllegalArgumentException("User not found");

        return "event_new";
    }
}
