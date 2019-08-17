package tim.mytrello.restClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tim.mytrello.form.LoginForm;
import tim.mytrello.restClient.Service.RestLoginService;
import tim.mytrello.restClient.response.LoginResponse;
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
    ResponseEntity<LoginResponse> login(@RequestBody LoginForm loginForm) {
        return ResponseEntity.ok(loginService.login(loginForm));
    }

    @PostMapping("/rest/register")
    ResponseEntity<LoginResponse> register(@RequestBody LoginForm loginForm) {
        LoginResponse register = loginService.register(loginForm);
        return ResponseEntity.ok(register);
    }
}
