package tim.mytrello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import tim.mytrello.entity.Event;
import tim.mytrello.service.EventService;

import java.util.List;

/**
 * Created by timurbadretdinov on Jun, 2019
 **/
@Controller
public class ExitController {

    @Autowired
    EventService eventService;


    @GetMapping(value = "/exit")
    public String openMain(ModelMap model) {
        List<Event> events = eventService.getAllEvents();
        model.addAttribute("events", events);
        return "main";
    }
}
