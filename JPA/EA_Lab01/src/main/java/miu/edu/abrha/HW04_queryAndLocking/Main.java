/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miu.edu.abrha.HW04_queryAndLocking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author Mabshura
 */
public class Main {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ea_db_PU");

    private static void findBookWithStudentsGPAGT3(EntityManager em) {
        System.out.println("Printing ALL Books of Students with Grade>3");
        Query query = em.createQuery("SELECT st FROM Student_4 st WHERE st.gpa>3.0");
        query.setLockMode(LockModeType.PESSIMISTIC_READ);
        List<Student_4> students = query.getResultList();
        for (Student_4 st : students) {
            System.out.println("Student=" + st.getName());
            for (Book_4 bk : st.getBooks()) {
                System.out.println("Books=" + bk.getTitle());
            }

        }
    }

    private static void findBooksWith100Pages(EntityManager em) {
        System.out.println("Printing all books with >= 100 pages for students with gpa >= 3.0.");
//        Query query = em.createQuery("SELECT st.books FROM Student_4 st INNER JOIN st.books bk WHERE st.gpa>3.0f AND bk.pageNumber>=100");
        Query query = em.createQuery("SELECT distinct bk FROM  Student_4 st INNER JOIN Book_4 bk WHERE st.gpa>3.0f AND bk.pageNumber>=100");

        List<Book_4> books = query.getResultList();
        //for (List<Book_4> bks : books) {
        for (Book_4 bk : books) {
            System.out.println("Books=" + bk.getTitle());
        }
    }

    private static void selectionWithCriteriaBuilder(EntityManager em) {
        System.out.println("Printing book with pages more than or equal to 120 pages and belonging to students with gpa >= 3.0 "
                + "and written by an Author living in Iowa, "
                + "and the book is published by a publisher with more than 100 employees.");
 
//        Query Q = em.createQuery("Select distinct bks from Student_4 st Inner Join st.books bks WHERE "
//                + "bks.pageNumber>=120 AND st.gpa>=3.0 AND"
//                + " bks.Author.address.state='Iowa' AND bks.publisher.numOfEmployees>100");
        CriteriaBuilder criBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Student_4> criQuery = criBuilder.createQuery(Student_4.class);
        Root<Student_4> rootStudent = criQuery.from(Student_4.class);

        criQuery.select(rootStudent.get("books")).distinct(true);

        Join<Student_4, Book_4> joinBook = rootStudent.join("books");
        Predicate gpaPredicate = criBuilder.equal(rootStudent.get("gpa"), 3.0);
        Predicate bookPagePredicate = criBuilder.greaterThanOrEqualTo(joinBook.get("pageNumber"), 120);
     /*   CriteriaBuilder criBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Book_4> criQuery = criBuilder.createQuery(Book_4.class);
        Root<Book_4> rootBooks = criQuery.from(Book_4.class);

        criQuery.select(rootBooks.get("title")).distinct(true);

        Join<Student_4,Book_4> joinStudent = criQuery.from(Student_4.class).join("books");
        Predicate gpaPredicate = criBuilder.equal(joinStudent.get("gpa"), 3.0);
        Predicate bookPagePredicate = criBuilder.greaterThanOrEqualTo(rootBooks.get("pageNumber"), 120);
*/
// Predicate authorStatePredicate = criBuilder.equal(rootStudent.get("Author.address.state"), "Iowa");
        //  Predicate pubisherEmployeesPredicate = criBuilder.greaterThan(rootStudent.get("books.publisher.numOfEmployees"), 100);
        //    Predicate andPredicate = criBuilder.and(gpaPredicate, bookPagePredicate, authorStatePredicate, pubisherEmployeesPredicate);
        criQuery.where(bookPagePredicate);

        Query Q = em.createQuery(criQuery);
        List<Book_4> books = Q.getResultList();
        //for (List<Book_4> bks : books) {
        for (Book_4 bk : books) {
            System.out.println("Books=" + bk.getTitle());
        }
    }

    private static List<Book_4> createBooks() {
        List<Book_4> books = new ArrayList<>();

        Author_4 author1 = new Author_4("Author 1", new Address_4("101N", "Fairfield", "Iowa", 25556));
        Author_4 author2 = new Author_4("Author 2", new Address_4("102N", "NewYork", "NewYork", 41125));
        Author_4 author3 = new Author_4("Author 3", new Address_4("103N", "Otumwa", "Iowa", 12345));

        Publisher_4 pub1 = new Publisher_4("Publisher 1", 120);
        Publisher_4 pub2 = new Publisher_4("Publisher 2", 150);
        Publisher_4 pub3 = new Publisher_4("Publisher 3", 90);

        Book_4 book1 = new Book_4("Title 1", 70, author1, pub1);
        Book_4 book2 = new Book_4("Title 2", 110, author2, pub2);
        Book_4 book3 = new Book_4("Title 3", 120, author3, pub2);  // qualify
        Book_4 book4 = new Book_4("Title 4", 130, author3, pub3);
        Book_4 book5 = new Book_4("Title 5", 130, author1, pub2);  // qualify

        books = Arrays.asList(book1, book2, book3, book4, book5);
        return books;
    }

    private static List<Student_4> createStudents() {
        List<Student_4> students = new ArrayList<>();
        List<Book_4> books = createBooks();

        Student_4 student1 = new Student_4("Student 1", 3.0f, Arrays.asList(books.get(0), books.get(3)),1);
        Student_4 student2 = new Student_4("Student 2", 3.2f, Arrays.asList(books.get(1), books.get(3)),2);
        Student_4 student3 = new Student_4("Student 3", 3.5f, Arrays.asList(books.get(2), books.get(4)),3); // Qualify
        Student_4 student4 = new Student_4("Student 4", 2.9f, Arrays.asList(books.get(3), books.get(1)),4);
        Student_4 student5 = new Student_4("Student 5", 4.0f, Arrays.asList(books.get(4), books.get(2)),5); // Qualify

        students = Arrays.asList(student1, student2, student3, student4, student5);
        return students;
    }

    private static void persistStudents(EntityManager em) throws Exception {
        System.out.println("-- Persisting Students --");
        em.getTransaction().begin();
        for (Student_4 st : createStudents()) {
            em.persist(st);
        }
        em.getTransaction().commit();
    }

    public static void main(String[] args) throws Exception {

        System.out.println("Start ... ");
        EntityManager em = emf.createEntityManager();

        // persistStudents(em);
        //findBookWithStudentsGPAGT3(em);
        //findBooksWith100Pages(em);
        selectionWithCriteriaBuilder(em);
        em.close();
        emf.close();
        System.out.println("End ...");

    }
}


