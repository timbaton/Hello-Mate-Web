package tim.mytrello.form;

import lombok.Data;
import lombok.NonNull;
import tim.mytrello.validation.Login;
import tim.mytrello.validation.Password;

import javax.validation.constraints.Size;

/**
 * Created by timurbadretdinov on May, 2019
 **/
@Data
public class LoginForm {

    @NonNull
    @Login
    @Size(min = 3, max = 10, message = "Логин должен иметь от 3 до 10 символов")
    private String login;

    @Password
    private String password;
}
