package tim.mytrello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tim.mytrello.entity.Event;
import tim.mytrello.service.EventService;

import java.util.List;

/**
 * Created by timurbadretdinov on Jun, 2019
 **/
@RestController
public class AjaxController {

    @Autowired
    EventService eventService;

    @GetMapping(value = "/ajax/post/{id}")
    public Event getEvent(@PathVariable(name = "id") Long eventId) {
        Event event = eventService.getEventById(eventId);
        return event;
    }

    @GetMapping(value = "/ajax/post")
    public ResponseEntity<Object> getEvents() {
        List<Event> events = eventService.getAllEvents();
        return ResponseEntity.ok(events);
    }
}
