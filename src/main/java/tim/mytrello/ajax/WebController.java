package tim.mytrello.ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by timurbadretdinov on Jun, 2019
 **/
@Controller
public class WebController {

    @GetMapping(value="/")
    public String homepage(){
        return "index";
    }
}
