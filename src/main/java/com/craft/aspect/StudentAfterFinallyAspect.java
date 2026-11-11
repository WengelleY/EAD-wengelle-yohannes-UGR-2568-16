
package com.craft.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class StudentAfterFinallyAspect {

    @After("execution(* com.craft.StudentService.findStudent(..))")
    public void afterFindStudent() {

        System.out.println("[LOG] findStudent() execution finished");
    }
}
