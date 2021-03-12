package miu.edu.Spring_Hibernate_ORM_TX.Dao;

import miu.edu.Spring_Hibernate_ORM_TX.Model.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CourseDao {
    @Autowired
    private SessionFactory sessionFactory;

   // private Session session = sf.getCurrentSession();

    public void createCourse(Course course) {
        sessionFactory.getCurrentSession().persist(course);
    }

    public Course gatCourse(int id) {
         return sessionFactory.getCurrentSession().find(Course.class, id);
    }

    public void updateCourse(Course course) {
        sessionFactory.getCurrentSession().saveOrUpdate(course);
    }

    public void deleteCourse(Course course) {
        sessionFactory.getCurrentSession().remove(course);
     }

    public List<Course> findAllCourses() {
        return sessionFactory.getCurrentSession().createQuery("SELECT c FROM Course  c").getResultList();
    }


}
