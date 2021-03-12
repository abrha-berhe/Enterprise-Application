package miu.edu.Spring_Hibernate_ORM_TX.Advices;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.scheduling.annotation.Scheduled;

@Aspect
public class StudentAdvice {
    @Before("execution(* miu.edu.Spring_Hibernate_ORM_TX.Service.StudentService.*(..))")
    public void persistenceMethodLog(JoinPoint joinPoint) {
        System.out.println("Your Persistence Method " + joinPoint.getSignature().getName() + " is Logged");
        //System.out.println("With Parameters " + ((CodeSignature)joinPoint.getSignature()).getParameterNames()[0]);
        System.out.println("With Parameters " +  joinPoint.getArgs());
    }


//    @AfterReturning(pointcut = "execution(* miu.edu.Spring_Hibernate_ORM_TX.Service.StudentService.getNumberOfStudents(..))",returning = "numberOfStudents")
//    public void logNumberOfStudents(JoinPoint joinPoint, int numberOfStudents){
//        System.out.println("Total Number of Students = " + numberOfStudents);
//    }
}


