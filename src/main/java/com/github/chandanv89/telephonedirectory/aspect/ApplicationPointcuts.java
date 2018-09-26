package com.github.chandanv89.telephonedirectory.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * The type Application pointcuts.
 */
@Aspect
@Configuration
@Component
public class ApplicationPointcuts {
    private static final Logger LOGGER = LogManager.getLogger(ApplicationPointcuts.class);

    /**
     * Before.
     *
     * @param joinPoint the join point
     */
    @Before(value = "execution(* com.github.chandanv89.telephonedirectory.persistance.*.*(..)) || execution(* com.github.chandanv89.telephonedirectory.controller.*.*(..))")
    public void before(JoinPoint joinPoint) {
        LOGGER.debug("### Invoked {} with {}",
                joinPoint.toShortString(),
                joinPoint.getArgs());
    }

    /**
     * After.
     *
     * @param joinPoint the join point
     */
    @After(value = "execution(* com.github.chandanv89.telephonedirectory.persistance.*.*(..)) || execution(* com.github.chandanv89.telephonedirectory.controller.*.*(..))")
    public void after(JoinPoint joinPoint) {
        LOGGER.debug("### {} completed.", joinPoint.toShortString());
    }

    /**
     * After returning.
     *
     * @param joinPoint   the join point
     * @param returnValue the return value
     */
    @AfterReturning(value = "execution(* com.github.chandanv89.telephonedirectory.persistance.*.*(..))", returning = "returnValue")
    public void afterReturning(JoinPoint joinPoint, Object returnValue) {
        LOGGER.debug("### {} returned: {}", joinPoint.toShortString(), returnValue);
    }

    /**
     * After throwing.
     *
     * @param joinPoint the join point
     */
    @AfterThrowing(value = "execution(* com.github.chandanv89.telephonedirectory.persistance.*.*(..))")
    public void afterThrowing(JoinPoint joinPoint) {
        LOGGER.debug("!!! {} failed!", joinPoint.toShortString());
    }

    /**
     * Around object.
     *
     * @param joinPoint the join point
     * @return the object
     * @throws Throwable the throwable
     */
    @Around(value = "execution(* com.github.chandanv89.telephonedirectory.persistance.*.*(..)) || execution(* com.github.chandanv89.telephonedirectory.controller.*.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        LOGGER.debug("$$$ Time Taken by {} is {} ms. Returned: {}",
                joinPoint.toShortString(), (System.currentTimeMillis() - startTime));

        return result;
    }
}
