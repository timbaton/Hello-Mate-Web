package tim.mytrello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tim.mytrello.Dto.EventDto;
import tim.mytrello.entity.Event;
import tim.mytrello.entity.Users;
import tim.mytrello.security.CustomUserDetails;
import tim.mytrello.service.EventService;
import tim.mytrello.service.FileStorageService;
import tim.mytrello.service.UserService;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Arrays;
import java.util.HashMap;
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
    public ResponseEntity<Object> getEvent(@PathVariable(name = "id") Long eventId, Authentication authentication) {
        Event event = eventService.getEventById(eventId);
        int userId = ((CustomUserDetails) authentication.getPrincipal()).getId();

        boolean isRegistered = false;
        List<Users> participants = event.getParticipants();

        for (Users user : participants) {
            if (user.getId() == userId) {
                //если пользователь зареган - отмечаем это, чтобы удалить кнопку регистрации
                isRegistered = true;
            }
        }

        HashMap response = new HashMap();
        response.put("event", EventDto.from(event));
        response.put("userId", userId);
        response.put("isRegistered", isRegistered);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/ajax/post")
    public ResponseEntity<Object> getEvents(Authentication authentication) {
        int userId = ((CustomUserDetails) authentication.getPrincipal()).getId();
        List<Event> events = eventService.getAllEvents();

        HashMap response = new HashMap();
        response.put("events", events);
        response.put("userId", userId);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/ajax/event_register/{event_id}")
    public ResponseEntity<Object> registerOnEvent(@PathVariable(name = "event_id") Long event_id, Authentication authentication) {

        CustomUserDetails customUser = (CustomUserDetails) authentication.getPrincipal();
        Integer userId = customUser.getId();

        //достаем
        Event event = eventService.getEventById(event_id);
        //добавляем юзеру эвент
        userService.addEvent(userId, event);
        eventService.addParticipant(event, userId);

        return ResponseEntity.ok(event);
    }

    @PostMapping(value = "/ajax/event_un_register/{event_id}")
    public ResponseEntity<Object> unRegisterOnEvent(@PathVariable(name = "event_id") Long event_id, Authentication authentication) {

        CustomUserDetails customUser = (CustomUserDetails) authentication.getPrincipal();
        Integer userId = customUser.getId();

        //достаем
        Event event = eventService.getEventById(event_id);
        //удаляем у юзера эвент
        userService.deleteEvent(userId, event);

        return ResponseEntity.ok(event);
    }

    @PostMapping(value = "/ajax/event_delete/{event_id}")
    public ResponseEntity<Object> deleteEvent(@PathVariable(name = "event_id") Long event_id, Authentication authentication) {

        eventService.deleteParticipants(event_id);
        eventService.deleteEvent(event_id);

        return ResponseEntity.ok().build();
    }
}
