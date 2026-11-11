
package com.craft.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class TimingAspect {

    //@Around("com.craft.aspect.LoggingAspect.studentServiceMethods()")
    public Object measureTime(ProceedingJoinPoint joinPoint)
            throws Throwable {

        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long end = System.currentTimeMillis();

        System.out.println("[TIME] "
                + joinPoint.getSignature().getName()
                + " took " + (end - start) + " ms");

        return result;
    }
}
