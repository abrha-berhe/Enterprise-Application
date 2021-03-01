/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miu.edu.abrha.HW03_Inheritance_SingleTable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Mabshura
 */
public class Main {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ea_db_PU");

    private static void findCPTStudents(EntityManager em) {
        System.out.println("Printing ALL CPT Students ");
        Query query = em.createQuery("SELECT cpt FROM Student_CPT1 cpt");
        List<Student_CPT1> cpt_Students = query.getResultList();
        for (Student_CPT1 st : cpt_Students) {
            System.out.println("Name=" + st.getName() + " GPA=" + st.getGpa() + " JOB=" + st.getJob() +
                    " Laptop RAM=" + st.getLaptop().getRAM_Size());
        }
    }

    private static void findLaptopOCPTWithGrade(EntityManager em, float gpa_param) {
        Query query = em.createQuery("SELECT cpt.laptop FROM Student_CPT1 cpt WHERE cpt.gpa=:gpa_val");
        query.setParameter("gpa_val", gpa_param);
        List<Laptop> laptops = query.getResultList();

        System.out.println("Printing Laptop of CPT Students with GPA 3.0");

        for (Laptop L : laptops) {
            System.out.println("Laptop info \n Price=" + L.getPrice() + " HDD=" + L.getHD_Size() + " RAM=" + L.getRAM_Size());
        }
    }
    
        private static void findStudentsWithLaptop32RAM(EntityManager em) {
        Query query = em.createQuery("SELECT st FROM Student_Parent1 st WHERE st.laptop.RAM_Size=32");
        List<Student_Parent1> students = query.getResultList();

        System.out.println("Printing Students with Laptop of RAM size 32 GB");

        for (Student_Parent1 st : students) {
            System.out.println(" Name = " + st.getName() + " GPA = " + st.getGpa());
        }
    }

    private static List<Student_Parent1> createStudents() {
        List<Student_Parent1> students = new ArrayList<>();
        Student_OnCampus1 teamani = new Student_OnCampus1();
        teamani.setName("Teamani");
        teamani.setGpa(4.0f);
        teamani.setRoom(12);
        teamani.setBuilding(143);
        teamani.setLaptop(new Laptop(1000.0f, 32, 1000));
        students.add(teamani);

        Student_JobSearch1 freweyni = new Student_JobSearch1();
        freweyni.setName("Freqeyni");
        freweyni.setGpa(3.5f);
        freweyni.setCV("I have 5 years work experience");
        freweyni.setStartJobSearchDate(new Date());
        freweyni.setLaptop(new Laptop(500.0f, 32, 500));
        students.add(freweyni);

        Student_CPT1 seare = new Student_CPT1();
        seare.setName("Seare");
        seare.setGpa(3.0f);
        seare.setJob("Software Engineer");
        seare.setSalary(50000.0f);
        seare.setLaptop(new Laptop(1500.0f, 32, 2000));
        students.add(seare);

        Student_CPT1 gere = new Student_CPT1();
        gere.setName("Gere");
        gere.setGpa(3.5f);
        gere.setJob("Java Developer");
        gere.setSalary(120000.0f);
        gere.setLaptop(new Laptop(300.0f, 4, 500));
        students.add(gere);

        return students;
    }

    private static void persistStudents(EntityManager em) throws Exception {
        System.out.println("-- Persisting Students --");
        em.getTransaction().begin();
        for (Student_Parent1 st : createStudents()) {
            em.persist(st);
        }
        em.getTransaction().commit();
    }

    public static void main(String[] args) throws Exception {

        System.out.println("Start ... ");
        EntityManager em = emf.createEntityManager();

        //persistStudents(em);
       // findCPTStudents(em);
       // findLaptopOCPTWithGrade(em, 3.0f);
        findStudentsWithLaptop32RAM(em);

        em.close();
        emf.close();
        System.out.println("End ...");

    }

}
