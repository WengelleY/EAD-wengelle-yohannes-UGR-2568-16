
package com.craft.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
@Order(2)
@Aspect
public class AnnotationTimingAspect {

    @Around("@annotation(com.craft.LogExecutionTime)")
    public Object measureTime(ProceedingJoinPoint joinPoint)
            throws Throwable {

        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long end = System.currentTimeMillis();

        System.out.println("[ANNOTATION TIME] "
                + joinPoint.getSignature().getName()
                + " took " + (end - start) + " ms");

        return result;
    }
}
