
package com.craft;

public class StudentService implements StudentOperations {

    @LogExecutionTime
    public void addStudent(Student student) {
        System.out.println("Saving student " + student.getName());

        validateStudent();
    }

    @LogExecutionTime
    public Student findStudent(int id) {
        Student s = new Student(id, "John Doe");
        return s;
    }

    @RequiresRole("ADMIN")
    public void deleteStudent(int id) {
        System.out.println("Deleting student with ID: " + id);
    }

    public void validateStudent() {
        System.out.println("Validating student");
    }
}
