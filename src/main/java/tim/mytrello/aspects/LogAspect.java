package tim.mytrello.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Aspect
@Configuration
public class LogAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @After("execution (* *..UserService.loadUserByUsername(..))")
    public void logLoadUserByName(JoinPoint joinPoint) {
        logger.info("LOG.INFO: got user successfully: " + Arrays.toString(joinPoint.getArgs()));
    }

    @After("execution (* *..UserService.registerUser(..))")
    public void logRegisterUser(JoinPoint joinPoint) {
        logger.info("LOG.INFO: registered successfully: " + Arrays.toString(joinPoint.getArgs()));
    }

    @Before("execution (* *..UserService.addEvent(..))")
    public void logAddEvent(JoinPoint joinPoint) {
        logger.info("LOG.INFO: started adding event " + Arrays.toString(joinPoint.getArgs()));
    }

    @After("execution (* *..UserService.deleteEvent(..))")
    public void logDeleteEvent(JoinPoint joinPoint) {
        logger.info("LOG.INFO: deleted event successfully: " + Arrays.toString(joinPoint.getArgs()));
    }

    @After("execution (* *..UserService.editUser(..))")
    public void loEditUser(JoinPoint joinPoint) {
        logger.info("LOG.INFO: edited user successfully: " + Arrays.toString(joinPoint.getArgs()));
    }
}
