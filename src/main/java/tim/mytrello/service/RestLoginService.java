package tim.mytrello.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tim.mytrello.Dto.TokenDto;
import tim.mytrello.entity.Token;
import tim.mytrello.entity.Users;
import tim.mytrello.form.LoginForm;
import tim.mytrello.repository.TokenRepository;
import tim.mytrello.repository.UserRepository;

import java.util.Optional;

/**
 * Created by timurbadretdinov on May, 2019
 **/
@Component
public class RestLoginService {

    @Autowired
    TokenRepository tokenRepository;
    @Autowired
    UserRepository userRepository;

    public TokenDto login(LoginForm loginForm) {
        Optional<Users> possibleUser = userRepository.findUserByLogin(loginForm.getLogin());

        if (possibleUser.isPresent()) {
            Users user = possibleUser.get();

            if (user.getPassword().equals(loginForm.getPassword())) {
                Token token = Token.builder()
                        .responsibleUser(user)
                        .token(RandomStringUtils.random(10))
                        .build();
                tokenRepository.save(token);

                return TokenDto.from(token);
            } else throw new IllegalArgumentException("Password is not correct");
        }
        throw new IllegalArgumentException("User not found");
    }
}
