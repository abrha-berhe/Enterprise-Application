package miu.edu.SpringB2.CRUDSpringB;

import miu.edu.SpringB2.CRUDSpringB.Controller.EmployeeController;
import miu.edu.SpringB2.CRUDSpringB.Service.EmployeeService;
import miu.edu.SpringB2.CRUDSpringB.Service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudSpringBApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringBApplication.class, args);
	}

}
