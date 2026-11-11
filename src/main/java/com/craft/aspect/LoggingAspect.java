
package com.craft.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;


@Order(1)
@Aspect
public class LoggingAspect {

    @Pointcut("execution(* com.craft.StudentService.*(..))")
    public void studentServiceMethods() {
    }

    @Before("studentServiceMethods()")
    public void logBefore(JoinPoint joinPoint) {

        System.out.println("[LOG] Before method: "
                + joinPoint.getSignature().getName());
    }
}
