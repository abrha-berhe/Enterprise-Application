package miu.edu.Spring_Hibernate_ORM_TX.Service;

import miu.edu.Spring_Hibernate_ORM_TX.Dao.StudentDao;
import miu.edu.Spring_Hibernate_ORM_TX.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {
    @Autowired
    private StudentDao studentDao;

    @Transactional
    public void createStudent(Student student) {
        studentDao.createStudent(student);
    }

    @Transactional
    public void updateStudent(Student student) {
        studentDao.updateStudent(student);
    }

    @Transactional
    public void deleteStudent(Student student) {
        studentDao.deleteStudent(student);
    }

    @Scheduled(cron = "0/5 * * * * *")
    @Transactional
    public int getNumberOfStudents() {
        int val = studentDao.getAllStudents();
        System.out.println("Number of Students ... "+val);
        return val;
    }

    @Transactional
    @Async
    public void deleteAllStudetns() {
        studentDao.deleteAllStudents();
    }

}
