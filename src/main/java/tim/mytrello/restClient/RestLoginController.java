package tim.mytrello.restClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tim.mytrello.Dto.TokenDto;
import tim.mytrello.form.LoginForm;
import tim.mytrello.service.RestLoginService;
import tim.mytrello.service.UserService;

/**
 * Created by timurbadretdinov on May, 2019
 **/
@RestController
public class RestLoginController {

    @Autowired
    UserService userService;
    @Autowired
    RestLoginService loginService;

    @PostMapping("/rest/login")
    ResponseEntity<TokenDto> login(@RequestBody LoginForm loginForm) {
        return ResponseEntity.ok(loginService.login(loginForm));
    }
}
