package tim.mytrello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import tim.mytrello.entity.Event;
import tim.mytrello.security.CustomUserDetails;
import tim.mytrello.service.EventService;

import java.util.List;

/**
 * Created by timurbadretdinov on Jun, 2019
 **/
@Controller
public class MainScreenController {

    @Autowired
    EventService eventService;


    @GetMapping(value = "/main")
    public String openMain(ModelMap model, Authentication authentication) {
        int userId = ((CustomUserDetails) authentication.getPrincipal()).getId();
        List<Event> events = eventService.getAllEvents();

        if (!events.isEmpty()) {
            model.addAttribute("events", events);
            model.addAttribute("user_id", userId);
            model.addAttribute("firstEvent", events.get(0));
            return "main";
        } else return "redirect:/event/new";
    }
}
