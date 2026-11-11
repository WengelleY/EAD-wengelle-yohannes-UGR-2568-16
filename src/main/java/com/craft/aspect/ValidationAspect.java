package com.craft.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class ValidationAspect {

    @Before("execution(* com.craft.StudentService.validateStudent(..))")
    public void beforeValidation() {
        System.out.println("[AOP] Before validation");
    }
}