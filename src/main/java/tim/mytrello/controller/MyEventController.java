package tim.mytrello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import tim.mytrello.entity.Event;
import tim.mytrello.entity.Users;
import tim.mytrello.form.EventNewForm;
import tim.mytrello.repository.UserRepository;
import tim.mytrello.security.CustomUserDetails;
import tim.mytrello.service.EventService;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * Created by timurbadretdinov on Jun, 2019
 **/
@Controller
public class MyEventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private UserRepository userRepository;


    @GetMapping(value = "/my")
    public String openMyEvents(ModelMap model, Authentication authentication) {
        int userId = ((CustomUserDetails) authentication.getPrincipal()).getId();
        Optional<Users> usersOptional = userRepository.findById(userId);
        List<Event> events = new LinkedList<>();
        if (usersOptional.isPresent()) {
            Users user = usersOptional.get();
            events = user.getEvents();
        }

        model.addAttribute("events", events);
        model.addAttribute("firstEvent", events.get(0));
        model.addAttribute("hasRegistered", true);
        return "main";
    }
}
