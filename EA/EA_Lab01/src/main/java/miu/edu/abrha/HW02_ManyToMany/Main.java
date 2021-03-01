/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miu.edu.abrha.HW02_ManyToMany;

import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author 611519
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Start");

        List<Student4> students = Arrays.asList(
                new Student4("Hayelom", 4.0f),
                new Student4("Siyum", 3.9f),
                new Student4("Asme", 3.5f),
                new Student4("Abyom", 3.0f)
        );

        List<Course> courses = Arrays.asList(
                new Course("Enterprice Architecture", "CS544", 4),
                new Course("Modern Web Application", "CS572", 4),
                new Course("Big Data", "CS522", 4));

        students.get(0).setCourses(Arrays.asList(courses.get(0), courses.get(1)));
        students.get(1).setCourses(Arrays.asList(courses.get(1), courses.get(2)));
        students.get(2).setCourses(Arrays.asList(courses.get(2), courses.get(0)));
        students.get(3).setCourses(Arrays.asList(courses.get(1), courses.get(2)));

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ea_db_PU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction txn = em.getTransaction();

        txn.begin();
        for(Student4 st : students)
        em.persist(st); // Persisting
         for(Course c : courses)
        em.persist(c); // Persisting
        txn.commit();

        em.close();
        emf.close();

        System.out.println("End");

    }

}
