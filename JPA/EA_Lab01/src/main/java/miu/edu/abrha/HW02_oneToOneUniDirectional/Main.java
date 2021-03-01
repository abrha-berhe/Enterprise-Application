/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miu.edu.abrha.HW02_oneToOneUniDirectional;

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

        Student2 meseret = new  Student2();
        Book2 bk = new Book2();
        
        bk.setNum_of_pages(40);
        bk.setTitle("The Book"); 
        
        meseret.setName("Meseret");
        meseret.setGPA(4.0f);        
        meseret.setBook(bk);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ea_db_PU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction txn = em.getTransaction();
        
        txn.begin();        
        em.persist(meseret); // Persisting
        txn.commit();        
        
        em.close();
        emf.close();

        System.out.println("End");

    }

}
