package tim.mytrello.restClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tim.mytrello.Dto.EventDto;
import tim.mytrello.Dto.UserDto;
import tim.mytrello.entity.Event;
import tim.mytrello.entity.Users;
import tim.mytrello.repository.EventRepository;
import tim.mytrello.repository.UserRepository;

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

    @GetMapping(value = "/rest/event", params = "user_id")
    public List<EventDto> getUserEvents(@RequestParam(name = "user_id") int id) {
        Optional<Users> userById = userRepository.findUserById(id);
        if (userById.isPresent()) {
            Users user = userById.get();
            List<Event> events = user.getEvents();
            List<EventDto> eventDtos = new LinkedList<>();

            for (Event event : events) {
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
}
