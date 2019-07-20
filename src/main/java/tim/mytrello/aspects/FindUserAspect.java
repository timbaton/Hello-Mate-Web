package tim.mytrello.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Aspect
@Configuration
public class FindUserAspect {

    private static final Logger logger = LoggerFactory.getLogger(FindUserAspect.class);

    @Around("execution(* *..UserService.loadUserByUsername(..))")
    public Object cacheDesk(ProceedingJoinPoint joinPoint) {

        logger.info("Method name : "
                + joinPoint.getSignature().getName());
        logger.info("Method arguments : "
                + Arrays.toString(joinPoint.getArgs()));

        logger.info("Before method called");
        try {
            // proceed to original method call
            Object result = joinPoint.proceed();

            logger.info("After method called");

            return result;

        } catch (Throwable throwable) {
            logger.error("Throw exception!");
            throwable.printStackTrace();
            return throwable;
        }
    }
}
