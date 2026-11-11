
package com.craft;

import com.craft.aspect.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import com.craft.aspect.SecurityAspect;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = false)
public class AppConfig {

    @Bean
    public StudentService studentService() {
        return new StudentService();
    }

    @Bean
    public LoggingAspect loggingAspect() {
        return new LoggingAspect();
    }

    @Bean
    public StudentAfterAspect studentAfterAspect() {
        return new StudentAfterAspect();
    }


    @Bean
    public StudentExceptionAspect studentExceptionAspect() {
        return new StudentExceptionAspect();
    }


    @Bean
    public StudentAfterFinallyAspect studentAfterFinallyAspect() {
        return new StudentAfterFinallyAspect();
    }

    @Bean
    public TimingAspect timingAspect() {
        return new TimingAspect();
    }


    @Bean
    public AnnotationTimingAspect annotationTimingAspect() {
        return new AnnotationTimingAspect();
    }

    @Bean
    public SecurityAspect securityAspect() {
        return new SecurityAspect();
    }

    @Bean
    public ValidationAspect validationAspect() {
        return new ValidationAspect();
    }
}
