package tim.mytrello.service;

import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tim.mytrello.entity.Users;
import tim.mytrello.form.RegistrationForm;
import tim.mytrello.repository.UserRepository;

/**
 * Created by timurbadretdinov on Jun, 2019
 **/
@Component
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void registerUser(RegistrationForm registrationUser) {
        Users user = Users.builder()
                .name(registrationUser.getName())
                .surname(registrationUser.getSurname())
                .password(registrationUser.getPassword())
                .login(registrationUser.getLogin())
                .mail(registrationUser.getMail())
                .phone(registrationUser.getPhone())
                .build();
        userRepository.save(user);
    }
}
