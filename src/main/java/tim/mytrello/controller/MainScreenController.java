package tim.mytrello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by timurbadretdinov on Jun, 2019
 **/
@Controller
public class MainScreenController {

    @GetMapping(value = "/main")
    public String openMain() {
        return "main";
    }
}
