/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miu.edu.abrha.HW05_Callback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Mabshura
 */
public class Main {
    
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ea_db_PU");
    
    private static void persistStudents(EntityManager em) throws Exception {
        System.out.println("-- Persisting Students --");
        em.getTransaction().begin();
        for (Student_5 st : createStudents()) {
            em.persist(st);
        }
        em.getTransaction().commit();
    }
    
    private static void updateStudentName(EntityManager em, int id) throws Exception {
        System.out.println("-- Updating Students --");
        em.getTransaction().begin();
        Student_5 stud = em.find(Student_5.class, (long) id);
        stud.setName("Mabshura");
        em.getTransaction().commit();
    }
    
    private static void removeStudent(EntityManager em, int id) {
        System.out.println("-- Removing Students --");
        em.getTransaction().begin();
        Student_5 stud = em.find(Student_5.class, (long) id);
        em.remove(stud);
        em.getTransaction().commit();
    }
    
    private static List<Student_5> createStudents() {
        List<Student_5> students = new ArrayList<>();
        Student_5 student1 = new Student_5("Student 1", 3.0f);
        Student_5 student2 = new Student_5("Student 2", 3.2f);
        Student_5 student3 = new Student_5("Student 3", 3.5f);
        Student_5 student4 = new Student_5("Student 4", 2.9f);
        Student_5 student5 = new Student_5("Student 5", 4.0f);
        students = Arrays.asList(student1, student2, student3, student4, student5);
        return students;
    }
    
    public static void main(String[] args) throws Exception {
        
        System.out.println("Start ... ");
        EntityManager em = emf.createEntityManager();
        //  persistStudents(em);
        // updateStudentName(em,4);
        removeStudent(em, 4);
        
        em.close();
        emf.close();
        System.out.println("End ...");
        
    }
    
}
