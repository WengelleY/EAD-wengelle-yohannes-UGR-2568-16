package com.craft.aspect;

import com.craft.RequiresRole;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SecurityAspect {

    private String currentUserRole = "ADMIN";

    @Before("@annotation(requiresRole)")
    public void checkPermission(
            JoinPoint joinPoint,
            RequiresRole requiresRole) {

        String requiredRole = requiresRole.value();

        if (!currentUserRole.equals(requiredRole)) {
            throw new SecurityException(
                    "Access denied! Required role: " + requiredRole
            );
        }

        System.out.println("[SECURITY] Access granted!");
    }
}