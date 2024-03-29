package tim.mytrello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import tim.mytrello.entity.Event;
import tim.mytrello.entity.Users;
import tim.mytrello.repository.UserRepository;
import tim.mytrello.security.CustomUserDetails;
import tim.mytrello.service.UserService;

import java.util.List;
import java.util.Optional;

/**
 * Created by timurbadretdinov on Jun, 2019
 **/
@Controller
public class ProfileController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/profile")
    public String openProfile(ModelMap model, Authentication authentication) {
        int userId = ((CustomUserDetails) authentication.getPrincipal()).getId();
        Optional<Users> usersOptional = userRepository.findById(userId);
        List<Event> eventsRegistered;

        if (usersOptional.isPresent()) {
            Users user = usersOptional.get();
            eventsRegistered = user.getEvents();

            model.addAttribute("events", eventsRegistered);
            model.addAttribute("user", user);
            return "profile";
        } else {
            return "redirect:/login";
        }
    }
}
