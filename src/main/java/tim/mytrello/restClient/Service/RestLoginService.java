package tim.mytrello.restClient.Service;

import org.apache.commons.lang3.RandomStringUtils;
import org.aspectj.weaver.bcel.BcelAccessForInlineMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import tim.mytrello.entity.Image;
import tim.mytrello.entity.Token;
import tim.mytrello.entity.Users;
import tim.mytrello.form.LoginForm;
import tim.mytrello.repository.TokenRepository;
import tim.mytrello.repository.UserRepository;
import tim.mytrello.restClient.response.LoginResponse;
import tim.mytrello.service.ImageService;

import java.util.Optional;

/**
 * Created by timurbadretdinov on May, 2019
 **/
@Component
public class RestLoginService {

    @Autowired
    TokenRepository tokenRepository;

    @Autowired
    ImageService imageService;

    @Autowired
    UserRepository userRepository;

    public LoginResponse login(LoginForm loginForm) {
        Optional<Users> possibleUser = userRepository.findUserByLogin(loginForm.getLogin());

        if (possibleUser.isPresent()) {
            Users user = possibleUser.get();

            boolean passCorrect = new BCryptPasswordEncoder().matches(loginForm.getPassword(), user.getPassword());
            if (passCorrect) {
                Token token = getToken(user);

                return new LoginResponse(token.getToken(), user.getId());
            } else throw new IllegalArgumentException("Password is not correct");
        }
        throw new IllegalArgumentException("User not found");
    }

    public LoginResponse register(LoginForm loginForm) {
        String password = new BCryptPasswordEncoder().encode(loginForm.getPassword());
        Image ava = imageService.getAvatar();

        Users user = Users.builder()
                .login(loginForm.getLogin())
                .avatar(ava)
                .password(password).build();

        userRepository.save(user);

        Token token = getToken(user);

        return new LoginResponse(token.getToken(), user.getId());
    }

    private Token getToken(Users user) {
        Token token = Token.builder()
                .responsibleUser(user)
                .token(RandomStringUtils.random(10))
                .build();
        tokenRepository.save(token);
        return token;
    }
}
