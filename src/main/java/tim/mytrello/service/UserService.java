package tim.mytrello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tim.mytrello.entity.Event;
import tim.mytrello.entity.Image;
import tim.mytrello.entity.Users;
import tim.mytrello.form.EditProfileForm;
import tim.mytrello.form.RegistrationForm;
import tim.mytrello.repository.UserRepository;
import tim.mytrello.security.CustomUserDetails;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

/**
 * Created by timurbadretdinov on Jun, 2019
 **/
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private ImageService imageService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<Users> optionalUsers = userRepository.findUserByLogin(login);
        optionalUsers.orElseThrow(() -> new UsernameNotFoundException("Username not found"));

        return optionalUsers.map(CustomUserDetails::new).get();
    }

    public void registerUser(RegistrationForm registrationUser) {
        String password = new BCryptPasswordEncoder().encode(registrationUser.getPassword());

        Image ava = imageService.getAvatar();

        Users user = Users.builder()
                .name(registrationUser.getName())
                .surname(registrationUser.getSurname())
                .password(password)
                .login(registrationUser.getLogin())
                .mail(registrationUser.getMail())
                .avatar(ava)
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

    public Users editUser(EditProfileForm editProfileForm, int userId) {
        Optional<Users> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            Users user = userOptional.get();

            user.setName(editProfileForm.getName());
            user.setSurname(editProfileForm.getSurname());
            user.setMail(editProfileForm.getMail());
            user.setPhone(editProfileForm.getPhone());
            userRepository.save(user);

            return userRepository.findById(userId).get();
        }

        return null;
    }

    public boolean checkForUniqueness(String login) {
        return !userRepository.findUserByLogin(login).isPresent();
    }

    public Users updateAvatar(Integer userId, MultipartFile image) throws IOException {
        String avatar = fileStorageService.getFileName(image);
        Timestamp dateTimeStamp = new Timestamp(new Date().getTime());

        Image ava = Image.builder().path(avatar).date(dateTimeStamp).build();

        Optional<Users> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            Users user = userOptional.get();

            user.setAvatar(ava);
            userRepository.save(user);

            return userRepository.findById(userId).get();
        }
        return null;
    }
}
