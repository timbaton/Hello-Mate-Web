package tim.mytrello.restClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tim.mytrello.Dto.EventDto;
import tim.mytrello.Dto.UserDto;
import tim.mytrello.entity.Event;
import tim.mytrello.entity.Users;
import tim.mytrello.form.EditProfileForm;
import tim.mytrello.repository.UserRepository;
import tim.mytrello.restClient.entity.RestEditProfileForm;
import tim.mytrello.service.UserService;

import java.io.IOException;
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

    @Autowired
    UserService userService;

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

    @PostMapping(value = "/rest/editUser")
    @ResponseBody
    public ResponseEntity<Object> editUser(@RequestBody RestEditProfileForm userForm) throws IOException {
        EditProfileForm user = EditProfileForm.builder()
                .mail(userForm.getMail())
                .name(userForm.getName())
                .surname(userForm.getSurname())
                .phone(userForm.getPhone())
                .build();

        return ResponseEntity.ok(UserDto.from(userService.editUser(user, userForm.getId())));
    }

    @PostMapping(value = "/rest/editUser/avatar", params = "id")
    @ResponseBody
    public ResponseEntity<Object> editAvatar(@RequestParam(name = "id") Integer user_id, @RequestPart("picture") MultipartFile image) throws IOException {

        return ResponseEntity.ok(UserDto.from( userService.updateAvatar(user_id, image)));
    }
}
