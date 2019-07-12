package tim.mytrello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by timurbadretdinov on Jul, 2019
 **/
@Controller
public class MapController {

    @GetMapping(value = "/map")
    public String openMap() {

        return "map";
    }
}
