package miu.edu.abrha.springBoot_Thymleaf.Advice;

   import miu.edu.abrha.springBoot_Thymleaf.model.Employee;
   import org.aspectj.lang.JoinPoint;
   import org.aspectj.lang.ProceedingJoinPoint;
   import org.aspectj.lang.annotation.After;
   import org.aspectj.lang.annotation.Aspect;
   import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
   import org.springframework.stereotype.Component;

@Component
@Aspect
public class MessagingAdvice {
//    @Autowired
//    private JmsTemplate jmsTemplate;

//    @After("execution(* miu.edu.abrha.springBoot_Thymleaf.service.EmployeeService.addEmployee(..))" +
//            " && args(employee)")
//    public void sendMessageToActiveQueue(JoinPoint jp, Employee employee) {
//        System.out.println("Logging employee-->"+employee+" Using Method " + jp.getSignature().getName());
//        System.out.println("Sending Employee to employeeQueue");
//        jmsTemplate.convertAndSend("employeeQueue", employee);
//    }

   @After("execution(* miu.edu.abrha.springBoot_Thymleaf.service.BookService.*(..))")
   public void sendMessageToActiveQueue(JoinPoint jp) {
      System.out.println("Logging Book Operation With Method --> "+ jp.getSignature().getName());
   }

}
