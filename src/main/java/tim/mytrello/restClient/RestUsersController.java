package tim.mytrello.restClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tim.mytrello.Dto.EventDto;
import tim.mytrello.Dto.UserDto;
import tim.mytrello.entity.Event;
import tim.mytrello.entity.Users;
import tim.mytrello.repository.UserRepository;
import tim.mytrello.service.UserService;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by timurbadretdinov on May, 2019
 **/
@RestController
public class RestUsersController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/rest/users")
    List<Users> all() {
        return userRepository.findAll();
    }

    @PostMapping(value = {"/rest/users"})
    @ResponseBody
    public ResponseEntity<Object> addUser(@RequestBody Users user) {
        userRepository.save(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/rest/users/{user-login}")
    public Users getUserByLogin(@PathVariable(name = "user-login") String login) {
        Optional<Users> userByLogin = userRepository.findUserByLogin(login);
        if (userByLogin.isPresent()) {
            return userByLogin.get();
        } else throw new IllegalArgumentException("User not found");
    }

    @GetMapping(value = "/rest/users", params = "id")
    public UserDto getUserByLogin(@RequestParam(name = "id") int id) {
        Optional<Users> userById = userRepository.findUserById(id);
        if (userById.isPresent()) {
            return UserDto.from(userById.get());
        } else throw new IllegalArgumentException("User not found");
    }

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
}
