/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miu.edu.abrha.HW02_OneToMany;

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

        Student3 jack = new  Student3();
        List<Book3> books =  Arrays.asList(
                new Book3("Title 1",200),
                new Book3("Title 2",300),
                new Book3("Title 3",400));        
        jack.setName("Jack");
        jack.setGPA(2.9f);        
        jack.setBooks(books);
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ea_db_PU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction txn = em.getTransaction();
        
        txn.begin();        
        em.persist(jack); // Persisting
        txn.commit();        
        
        em.close();
        emf.close();

        System.out.println("End");

    }

}
