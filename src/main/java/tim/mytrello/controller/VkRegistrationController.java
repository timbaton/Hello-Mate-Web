package tim.mytrello.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;
import tim.mytrello.form.RegistrationForm;
import tim.mytrello.form.UserVk;
import tim.mytrello.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

/**
 * Created by timurbadretdinov on Jun, 2019
 **/
@Controller
public class VkRegistrationController {

    private static final Logger logger = LoggerFactory.getLogger(VkRegistrationController.class);

    @Autowired
    UserService userService;

    @PostMapping("/register_vk")
    public ResponseEntity<Object> authorizeVk(@Valid @RequestBody UserVk userVk, HttpServletRequest request, HttpServletResponse httpServletResponse) throws IOException {
        RegistrationForm registrationForm = RegistrationForm.builder()
                .login(userVk.getFirst_name())
                .password(userVk.toString())
                .repeatPassword(userVk.toString())
                .name(userVk.getFirst_name())
                .phone(userVk.getMobile_phone())
                .surname(userVk.getLast_name()).build();



        //auto login
        userService.registerUser(registrationForm);

        //auto login
        try {
            request.login(registrationForm.getLogin(), registrationForm.getPassword());
        } catch (ServletException e) {
            logger.error("Error while login ", e);
        }
        return ResponseEntity.ok(registrationForm);
    }

    @GetMapping(value = "/register_vk")
    public String openRegistration() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getPrincipal() != "anonymousUser") {
            return "redirect:main";
        } else {
            return "registration";
        }
    }
}
