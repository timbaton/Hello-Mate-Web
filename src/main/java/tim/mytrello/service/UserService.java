package tim.mytrello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tim.mytrello.entity.Event;
import tim.mytrello.entity.Users;
import tim.mytrello.form.RegistrationForm;
import tim.mytrello.repository.UserRepository;
import tim.mytrello.security.CustomUserDetails;

import java.util.Optional;

/**
 * Created by timurbadretdinov on Jun, 2019
 **/
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<Users> optionalUsers = userRepository.findUserByLogin(login);
        optionalUsers.orElseThrow(() -> new UsernameNotFoundException("Username not found"));

        return optionalUsers.map(CustomUserDetails::new).get();
    }

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

    public void addEvent(Integer userId, Event event) {
        Optional<Users> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            Users user = userOptional.get();
            user.addEvent(event);
            userRepository.save(user);
        }
    }

    public void deleteEvent(Integer userId, Event event) {
        Optional<Users> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            Users user = userOptional.get();
            user.deleteEvent(event);
            userRepository.save(user);
        }
    }
}
