package tim.mytrello.restClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tim.mytrello.entity.Users;
import tim.mytrello.repository.UserRepository;
import tim.mytrello.service.UserService;

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
    @GetMapping(value = "/rest/users/", params = "id")
    public Users getUserByLogin(@RequestParam(name = "id") int id) {
        Optional<Users> userById = userRepository.findUserById(id);
        if (userById.isPresent()) {
            return userById.get();
        } else throw new IllegalArgumentException("User not found");
    }
}
