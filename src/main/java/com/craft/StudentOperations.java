package com.craft;

public interface StudentOperations {

    void addStudent(Student student);

    Student findStudent(int id);

    void deleteStudent(int id);

    void validateStudent();
}