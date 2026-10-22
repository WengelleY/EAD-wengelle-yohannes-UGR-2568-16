package com.craft;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

import java.util.Properties;

public class StudentDAO {

    private final EntityManagerFactory emf;

    public StudentDAO() {
        String password = System.getenv("DB_PASSWORD");

        if (password == null || password.isBlank()) {
            throw new IllegalStateException(
                    "The DB_PASSWORD environment variable was not found."
            );
        }

        Properties properties = new Properties();
        properties.setProperty(
                "jakarta.persistence.jdbc.password",
                password
        );

        emf = Persistence.createEntityManagerFactory(
                "studentPU",
                properties
        );
    }


    public int createStudent(String name, String tech) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Student student = new Student();
            student.setName(name);
            student.setTech(tech);

            em.persist(student);

            em.getTransaction().commit();

            System.out.println("Student saved: " + student);

            return student.getId();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;

        } finally {
            em.close();
        }
    }


    public Student getStudentById(int id) {
        EntityManager em = emf.createEntityManager();

        try {
            return em.find(Student.class, id);
        } finally {
            em.close();
        }
    }


    public List<Student> getAllStudents() {
        EntityManager em = emf.createEntityManager();

        try {
            return em.createQuery(
                    "SELECT s FROM Student s",
                    Student.class
            ).getResultList();

        } finally {
            em.close();
        }
    }

    public List<Student> getStudentsByTech(String tech) {
        EntityManager em = emf.createEntityManager();

        try {
            return em.createQuery(
                            "SELECT s FROM Student s WHERE s.tech = :tech",
                            Student.class
                    )
                    .setParameter("tech", tech)
                    .getResultList();

        } finally {
            em.close();
        }
    }

    public long countStudents() {
        EntityManager em = emf.createEntityManager();

        try {
            return em.createQuery(
                    "SELECT COUNT(s) FROM Student s",
                    Long.class
            ).getSingleResult();
        } finally {
            em.close();
        }
    }


    public void updateStudent(int id, String newName, String newTech) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Student student = em.find(Student.class, id);

            if (student != null) {
                student.setName(newName);
                student.setTech(newTech);

                em.getTransaction().commit();

                System.out.println("Student updated: " + student);
            } else {
                em.getTransaction().rollback();

                System.out.println("Student not found.");
            }

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;

        } finally {
            em.close();
        }
    }


    public void deleteStudent(int id) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Student student = em.find(Student.class, id);

            if (student != null) {
                em.remove(student);
                em.getTransaction().commit();

                System.out.println("Student deleted successfully!");
            } else {
                em.getTransaction().rollback();

                System.out.println("Student not found.");
            }

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;

        } finally {
            em.close();
        }
    }

    public void close() {
        emf.close();
    }

    public Student findStudentByIdJPQL(int id) {
        EntityManager em = emf.createEntityManager();

        try {
            List<Student> students = em.createQuery(
                            "SELECT s FROM Student s WHERE s.id = :id",
                            Student.class
                    )
                    .setParameter("id", id)
                    .getResultList();

            return students.isEmpty() ? null : students.get(0);

        } finally {
            em.close();
        }
    }


    public List<Student> getStudentsByNameAndTech(
            String name, String tech) {

        EntityManager em = emf.createEntityManager();

        try {
            return em.createQuery(
                            "SELECT s FROM Student s " +
                                    "WHERE s.name = :name AND s.tech = :tech",
                            Student.class
                    )
                    .setParameter("name", name)
                    .setParameter("tech", tech)
                    .getResultList();

        } finally {
            em.close();
        }
    }

    public List<String> getAllStudentNames() {
        EntityManager em = emf.createEntityManager();

        try {
            return em.createQuery(
                    "SELECT s.name FROM Student s",
                    String.class
            ).getResultList();

        } finally {
            em.close();
        }
    }

    public boolean isStudentManaged(int id) {
        EntityManager em = emf.createEntityManager();

        try {
            Student student = em.find(Student.class, id);
            return student != null && em.contains(student);
        } finally {
            em.close();
        }
    }
}

