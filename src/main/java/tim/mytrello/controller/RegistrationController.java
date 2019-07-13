package tim.mytrello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import tim.mytrello.form.RegistrationForm;
import tim.mytrello.service.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

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
    public String register(@Valid RegistrationForm registrationForm, BindingResult result, ModelMap modelMap) {
        if (result.hasErrors()) {
            StringBuilder errorMessage = new StringBuilder("You have some error(s): ");
            for (FieldError error : result.getFieldErrors()) {
                errorMessage.append(error.getDefaultMessage());
                errorMessage.append(";\n ");
            }

            System.out.println(errorMessage.toString());
            modelMap.addAttribute("errors", errorMessage.toString());
            return "registration";
        }

        userService.registerUser(registrationForm);
        return "redirect:login";
    }
}
