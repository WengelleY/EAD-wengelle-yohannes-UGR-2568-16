package com.craft;

public class Main {

    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();

        try {
            int id = dao.createStudent("Sara", "Java");

            System.out.println("Generated ID: " + id);

            Student student = dao.getStudentById(id);

            if (student != null) {
                System.out.println("Found: " + student);
            } else {
                System.out.println("Student not found.");
            }

            dao.updateStudent(id, "Sara Bekele", "Python");

            dao.deleteStudent(id);

        } finally {
            dao.close();
        }
    }
}
