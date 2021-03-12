package miu.edu.Spring_Hibernate_ORM_TX.Service;

import miu.edu.Spring_Hibernate_ORM_TX.Dao.CourseDao;
import miu.edu.Spring_Hibernate_ORM_TX.Model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CourseService {

    @Autowired
    private CourseDao courseDao;

    @Transactional
    public void createCourse(Course course) {
        courseDao.createCourse(course);
    }

    @Transactional
    public Course gatCourse(int id) {
        return courseDao.gatCourse(id);
    }

    @Transactional
    public void updateCourse(Course course) {
        courseDao.updateCourse(course);
    }

    @Transactional
    public void deleteCourse(Course course) {
        courseDao.deleteCourse(course);
    }
}
