package tim.mytrello.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import tim.mytrello.aspects.LogAspect;
import tim.mytrello.form.RegistrationForm;
import tim.mytrello.security.CustomUserDetails;
import tim.mytrello.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by timurbadretdinov on Jun, 2019
 **/
@Controller
public class RegistrationController {

    private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    UserService userService;

    @GetMapping(value = "/registration")
    public String openRegistration() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getPrincipal() != "anonymousUser") {
            return "redirect:main";
        } else {
            return "registration";
        }
    }

    @PostMapping("/registration")
    public String register(@Valid RegistrationForm registrationForm, BindingResult result, ModelMap modelMap, HttpServletRequest request) {
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

        //auto login
        try {
            request.login(registrationForm.getLogin(), registrationForm.getPassword());
        } catch (ServletException e) {
            logger.error("Error while login ", e);
        }
        return "redirect:main";
    }
}
