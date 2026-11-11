
package com.craft.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class StudentExceptionAspect {

    @AfterThrowing(
            pointcut = "execution(* com.craft.StudentService.findStudent(..))",
            throwing = "exception"
    )
    public void afterException(Exception exception) {

        System.out.println("[ERROR] Something went wrong: "
                + exception.getMessage());
    }
}
