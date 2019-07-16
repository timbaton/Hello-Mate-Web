package tim.mytrello.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tim.mytrello.entity.Users;
import tim.mytrello.form.RegistrationForm;
import tim.mytrello.form.UserVk;
import tim.mytrello.repository.UserRepository;
import tim.mytrello.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Optional;

/**
 * Created by timurbadretdinov on Jun, 2019
 **/
@Controller
public class VkAuthController {

    private static final Logger logger = LoggerFactory.getLogger(VkAuthController.class);

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/register_vk")
    public ResponseEntity<Object> register(@Valid @RequestBody UserVk userVk, HttpServletRequest request) throws IOException {
        RegistrationForm registrationForm = RegistrationForm.builder()
                .login(userVk.getFirst_name())
                .password(userVk.toString())
                .repeatPassword(userVk.toString())
                .name(userVk.getFirst_name())
                .phone(userVk.getMobile_phone())
                .surname(userVk.getLast_name()).build();


        //save user
        userService.registerUser(registrationForm);

        //auto login
        try {
            request.login(registrationForm.getLogin(), registrationForm.getPassword());
        } catch (ServletException e) {
            logger.error("Error while login ", e);
        }
        return ResponseEntity.ok(registrationForm);
    }

    @PostMapping(value = "/login_vk")
    public ResponseEntity<Object> login(@Valid @RequestBody UserVk userVk, HttpServletRequest request) {
        RegistrationForm registrationForm = RegistrationForm.builder()
                .login(userVk.getFirst_name())
                .password(userVk.toString())
                .repeatPassword(userVk.toString())
                .name(userVk.getFirst_name())
                .phone(userVk.getMobile_phone())
                .surname(userVk.getLast_name()).build();


        //auto login
        Optional<Users> optionalUsers = userRepository.findUserByLogin(registrationForm.getLogin());

        //auto login
        if (optionalUsers.isPresent()) {
            try {
                request.login(registrationForm.getLogin(), registrationForm.getPassword());
                return ResponseEntity.ok(registrationForm);
            } catch (ServletException e) {
                logger.error("Error while login ", e);
            }
        }
        return ResponseEntity.notFound().build();
    }
}
