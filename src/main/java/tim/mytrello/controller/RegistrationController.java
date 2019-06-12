package tim.mytrello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import tim.mytrello.form.RegistrationForm;
import tim.mytrello.service.UserService;

/**
 * Created by timurbadretdinov on Jun, 2019
 **/
@Controller
public class RegistrationController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/registration")
    public String openRegistration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String register(RegistrationForm registrationForm) {
        userService.registerUser(registrationForm);
        return "redirect:login";
    }
}
