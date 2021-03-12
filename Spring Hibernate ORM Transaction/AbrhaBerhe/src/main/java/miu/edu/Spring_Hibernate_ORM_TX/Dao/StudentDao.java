package miu.edu.Spring_Hibernate_ORM_TX.Dao;

import miu.edu.Spring_Hibernate_ORM_TX.Model.Student;
 import org.hibernate.SessionFactory;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Repository;


@Repository
public class StudentDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Student getStudent(int id) {
         return sessionFactory.getCurrentSession().find(Student.class, id);
    }


     public void createStudent(Student student) {
         sessionFactory.getCurrentSession().persist(student);
     }

     public void updateStudent(Student student) {
         sessionFactory.getCurrentSession().saveOrUpdate(student);
     }

     public void deleteStudent(Student student) {
         sessionFactory.getCurrentSession().remove(student);
     }

    public int getAllStudents(){
         return sessionFactory.getCurrentSession().createQuery("SELECT a FROM Student a", Student.class).getResultList().size();
    }

    public void deleteAllStudents() {
        sessionFactory.getCurrentSession().createQuery("Delete FROM Student", Student.class).getResultList();
     }
}
