package ru.mccarl.client.api.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by vrudometkin on 11/01/2018.
 */
@Aspect
@Component
@Slf4j
public class ServiceAspect {

    @Pointcut("execution(* ru.mccarl.client.api.web.Controller.*(..))")
    public void allControllerMethods() {}

    @Before("allControllerMethods()")
    public void allLogsBefore(JoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        String argsContent = Arrays.toString(args);
        StringBuilder sb = createStringBuilder(joinPoint);
        sb.append("args: ").append(argsContent);
        log.info("allLogsBefore(): {}", sb);
    }

    @AfterReturning(pointcut = "allControllerMethods()", returning = "returnValue")
    public void allLogsBefore(JoinPoint joinPoint, Object returnValue) throws Throwable {
        Object[] args = joinPoint.getArgs();
        String argsContent = Arrays.toString(args);
        StringBuilder sb = createStringBuilder(joinPoint);
        sb.append("args: ").append(argsContent);
        sb.append("returnValue: ").append(returnValue);
        log.info("allLogsBefore(): {}", sb);
    }

    private static StringBuilder createStringBuilder(JoinPoint joinPoint) {
        StringBuilder sb = new StringBuilder(joinPoint.getSignature().toShortString());
        sb.append("\n");
        return sb;
    }

}
