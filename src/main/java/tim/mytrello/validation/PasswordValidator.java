package tim.mytrello.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator implements ConstraintValidator<Password, String> {

    @Override
    public void initialize(Password constraintAnnotation) {
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        return correct(password, constraintValidatorContext);
    }

    private boolean correct(String password, ConstraintValidatorContext context) {
        String pattern = "^[a-z]{3,10}$";
        Pattern p = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(password);
        if (m.matches()) {
            return true;
        } else {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Password should contain from 3 to 10 characters and consist of letters")
                    .addConstraintViolation();
            return false;
        }
    }
}
