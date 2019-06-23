package tim.mytrello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tim.mytrello.entity.Event;
import tim.mytrello.service.EventService;
import tim.mytrello.service.FileStorageService;

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
}
