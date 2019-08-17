package tim.mytrello.restClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import tim.mytrello.Dto.EventDto;
import tim.mytrello.Dto.UserDto;
import tim.mytrello.entity.Event;
import tim.mytrello.entity.Users;
import tim.mytrello.form.EventNewForm;
import tim.mytrello.repository.EventRepository;
import tim.mytrello.repository.UserRepository;
import tim.mytrello.security.CustomUserDetails;
import tim.mytrello.service.EventService;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * Created by timurbadretdinov on May, 2019
 **/
@RestController
public class RestEventController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    EventRepository eventRepository;

    @Autowired
    EventService eventService;

    @GetMapping(value = "/rest/event", params = "user_id")
    public List<EventDto> getUserEvents(@RequestParam(name = "user_id") int id) {
        Optional<Users> userById = userRepository.findUserById(id);
        if (userById.isPresent()) {
            Users user = userById.get();
            List<Event> ownEvents = user.getOwnEvents();
            List<Event> events = user.getEvents();
            ownEvents.addAll(events);
            List<EventDto> eventDtos = new LinkedList<>();

            for (Event event : ownEvents) {
                eventDtos.add(EventDto.from(event));
            }
            return eventDtos;
        } else throw new IllegalArgumentException("User not found");
    }

    @GetMapping(value = "/rest/event", params = "isFuture")
    public List<EventDto> getAllEvents(@RequestParam(name = "isFuture") boolean isFuture) {

        List<Event> events = eventRepository.findAll();
        List<EventDto> eventDtos = new LinkedList<>();

        for (Event event : events) {
            eventDtos.add(EventDto.from(event));
        }
        return eventDtos;
    }

    @PostMapping(value = "/rest/event_register", params = {"event_id", "user_id"})
    public ResponseEntity<Object> eventSubscribe(@RequestParam(name = "event_id") Long event_id, @RequestParam(name = "user_id") Integer user_id) {

        //достаем эвент
        Event event = eventService.getEventById(event_id);

        //добавляем эвенту юзера
        eventService.addParticipant(event, user_id);

        return ResponseEntity.ok(EventDto.from(event));
    }

    @PostMapping(value = "/rest/event_unsubscribe", params = {"event_id", "user_id"})
    public ResponseEntity<Object> eventUnsubscribe(@RequestParam(name = "event_id") Long event_id, @RequestParam(name = "user_id") Integer user_id) {

        //достаем эвент
        Event event = eventService.getEventById(event_id);

        //добавляем эвенту юзера
        eventService.deleteOneParticipant(event, user_id);

        return ResponseEntity.ok(EventDto.from(event));
    }

    @PostMapping(value = "/rest/event", params = "user_id")
    public ResponseEntity<Object> addEvent(@RequestBody EventNewForm event, @RequestParam(name = "user_id") Integer user_id) throws IOException {
        Optional<Users> userById = userRepository.findUserById(user_id);
        if (userById.isPresent()) {
            Users user = userById.get();
            Event eventSaved = eventService.addEvent(event, user);

            return ResponseEntity.ok(EventDto.from(eventSaved));
        } else throw new IllegalArgumentException("User not found");
    }

    @PostMapping(value = "/rest/event_delete", params = "event_id")
    public ResponseEntity<Object> deleteEvent(@RequestParam(name = "event_id") Integer event_id) throws IOException {
        eventService.deleteEvent(event_id.longValue());
        return ResponseEntity.ok(true);
    }
}
