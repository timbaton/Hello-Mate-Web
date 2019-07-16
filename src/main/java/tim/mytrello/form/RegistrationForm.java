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
//@RequiredArgsConstructor
@Builder
public class RegistrationForm {

    @NonNull
    @Login
    @Size(min = 3, max = 15, message = "Login must consists of 3 to 15 characters")
    private String login;
    @Password
    private String password;
    private String repeatPassword;

    private String name;
    private String surname;
    private String mail;
    private String phone;
}
