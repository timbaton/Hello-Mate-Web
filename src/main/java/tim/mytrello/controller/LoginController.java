package tim.mytrello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by timurbadretdinov on Jun, 2019
 **/
@Controller
public class LoginController {

    @GetMapping({"/login", "/"})
    public String openLogin() {
        return "login";
    }
}
