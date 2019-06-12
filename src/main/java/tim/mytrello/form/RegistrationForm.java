package tim.mytrello.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by timurbadretdinov on Jun, 2019
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationForm {

    private String login;
    private String password;
    private String repeatPassword;


    private String name;
    private String surname;
    private String mail;
    private String phone;
}
