package tim.mytrello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tim.mytrello.entity.Event;
import tim.mytrello.security.CustomUserDetails;
import tim.mytrello.service.EventService;
import tim.mytrello.service.FileStorageService;
import tim.mytrello.service.UserService;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by timurbadretdinov on Jun, 2019
 **/
@RestController
public class AjaxController {

    @Autowired
    EventService eventService;

    @Autowired
    UserService userService;

    @Autowired
    private FileStorageService fileStorageService;

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

    @PostMapping(value = "/ajax/event_register/{event_id}")
    public ResponseEntity<Object> openMain(@PathVariable(name = "event_id") Long event_id, Authentication authentication) {

        CustomUserDetails customUser = (CustomUserDetails) authentication.getPrincipal();
        Integer userId = customUser.getId();

        Event event = eventService.getEventById(event_id);
        userService.addEvent(userId, event);

        return ResponseEntity.ok(event);
    }
}
