package tim.mytrello.form;

import lombok.*;
import org.springframework.validation.annotation.Validated;
import tim.mytrello.validation.Login;
import tim.mytrello.validation.Password;

import javax.validation.constraints.Size;

/**
 * Created by timurbadretdinov on Jun, 2019
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class RegistrationForm {

    @NonNull
    @Login
    @Size(min = 3, max = 10, message = "Login must consists of 3 to 10 characters")
    private String login;
    @Password
    private String password;
    private String repeatPassword;

    private String name;
    private String surname;
    private String mail;
    private String phone;
}
