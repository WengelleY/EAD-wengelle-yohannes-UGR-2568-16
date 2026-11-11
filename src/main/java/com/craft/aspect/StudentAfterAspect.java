
package com.craft.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class StudentAfterAspect {

    @AfterReturning(
            pointcut = "execution(* com.craft.StudentService.findStudent(..))",
            returning = "result"
    )
    public void afterFindStudent(Object result) {

        System.out.println("[LOG] Student found successfully: " + result);
    }
}
