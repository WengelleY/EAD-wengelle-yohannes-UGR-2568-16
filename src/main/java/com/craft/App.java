
package com.craft;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        StudentOperations service =
                context.getBean(StudentOperations.class);


        System.out.println(service.getClass());
        service.addStudent(new Student(101, "John"));

        service.findStudent(101);

        try {
            service.deleteStudent(101);
        } catch (SecurityException e) {
            System.out.println(e.getMessage());
        }
    }
}
