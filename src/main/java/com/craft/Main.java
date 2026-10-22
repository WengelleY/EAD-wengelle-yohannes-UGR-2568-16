
package com.craft;

public class Main {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();

        try {
            System.out.println("\n Find Student by ID ");
            System.out.println(dao.findStudentByIdJPQL(2));

            System.out.println("\nFind by Name and Tech");
            dao.getStudentsByNameAndTech("Sara", "Java")
                    .forEach(System.out::println);

            System.out.println("\n Get All Student Names");
            dao.getAllStudentNames()
                    .forEach(System.out::println);

            System.out.println("\n Check EntityManager.contains()");
            System.out.println(
                    "Is student 2 managed? " + dao.isStudentManaged(2)
            );

        } finally {
            dao.close();
        }
    }
}
