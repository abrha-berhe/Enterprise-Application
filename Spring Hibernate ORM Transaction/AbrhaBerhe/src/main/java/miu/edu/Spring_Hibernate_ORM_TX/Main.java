package miu.edu.Spring_Hibernate_ORM_TX;

import miu.edu.Spring_Hibernate_ORM_TX.Model.Student;
import miu.edu.Spring_Hibernate_ORM_TX.Service.CourseService;
import miu.edu.Spring_Hibernate_ORM_TX.Service.StudentService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;

public class Main {
    //Create Spring application context
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");

         StudentService studentService = context.getBean(StudentService.class);
       // CourseService courseService = context.getBean(CourseService.class);

        studentService.createStudent(new Student("Haleka", 3.2f));
        studentService.createStudent(new Student("Mabshura", 3.9f));
        studentService.createStudent(new Student("Rihan", 2.9f));


       // System.out.println("listAll: " + studentService.getNumberOfStudents());

      // context.close();
    }


}
