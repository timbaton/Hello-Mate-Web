package tim.mytrello.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tim.mytrello.service.UserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class LoginValidator implements ConstraintValidator<Login, String> {

    @Autowired
    private UserService userService;

    public LoginValidator() {
    }

    @Override
    public void initialize(Login constraintAnnotation) {

    }

    @Override
    public boolean isValid(String login, ConstraintValidatorContext constraintValidatorContext) {
        return isUnique(login, constraintValidatorContext);
    }

    private boolean isUnique(String login, ConstraintValidatorContext constraintValidatorContext) {
        if (!userService.checkForUniqueness(login)) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext
                    .buildConstraintViolationWithTemplate("Login is already in use")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}
