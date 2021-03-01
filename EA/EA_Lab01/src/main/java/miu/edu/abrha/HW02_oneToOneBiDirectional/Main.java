/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miu.edu.abrha.HW02_oneToOneBiDirectional;

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

        Student abrha = new  Student();
        Book bk = new Book();
        
        bk.setNum_of_pages(40);
        bk.setTitle("Pro JPA"); 
        
        abrha.setName("Abrha");
        abrha.setGPA(5.0f);        
        abrha.setBook(bk);
        
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ea_db_PU");
        EntityManager em = emf.createEntityManager();

        EntityTransaction txn = em.getTransaction();

        txn.begin();
        
        em.persist(abrha);

        txn.commit();
        
        em.close();
        emf.close();

        System.out.println("End");

    }

}
