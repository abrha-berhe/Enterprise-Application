/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miu.edu.abrha.HW03_Inhertiance_JoinedTable;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Mabshura
 */
public class Main {
     public static void main(String[] args) {

        System.out.println("Start Inheritance");

        Student_OnCampus2 teamani = new Student_OnCampus2();
        teamani.setName("Teamani");
        teamani.setGpa(4.0f);
        teamani.setRoom(12);
        teamani.setBuilding(143);

        Student_JobSearch2 freweyni = new Student_JobSearch2();
        freweyni.setName("Freqeyni");
        freweyni.setGpa(3.5f);
        freweyni.setCV("I have 5 years work experience");
        freweyni.setStartJobSearchDate(new Date());

        Student_CPT2 seare = new Student_CPT2();
        seare.setName("Seare");
        seare.setGpa(4.0f);
        seare.setJob("Software Engineer");
        seare.setSalary(50000.0f);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ea_db_PU");
        EntityManager em = emf.createEntityManager();

        EntityTransaction txn = em.getTransaction();

        txn.begin();

        em.persist(teamani);
        em.persist(freweyni);
        em.persist(seare);

        txn.commit();

        em.close();
        emf.close();

        System.out.println("End");

    }

}
