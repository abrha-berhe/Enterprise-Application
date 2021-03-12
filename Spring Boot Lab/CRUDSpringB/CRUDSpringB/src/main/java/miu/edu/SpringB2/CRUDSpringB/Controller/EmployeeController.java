package miu.edu.SpringB2.CRUDSpringB.Controller;

import miu.edu.SpringB2.CRUDSpringB.Dao.EmployeeDao;
import miu.edu.SpringB2.CRUDSpringB.Entity.Employee;
import miu.edu.SpringB2.CRUDSpringB.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee employee = employeeService.findById(employeeId);
        if (employee == null) {
            throw new RuntimeException("Employee not found with id - " + employeeId);
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee save(@RequestBody Employee newEmployee) {
        newEmployee.setId(0);
        employeeService.save(newEmployee);
        return newEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee emp) {
        employeeService.save(emp);
        return emp;
    }

    @DeleteMapping("/employees/{empID}")
    public String deleteById(@PathVariable int empID) {
        Employee employee = employeeService.findById(empID);
        if (employee == null) {
            return "Employee with Id = " + empID + " doesn't exist";
        }
        employeeService.deleteByID(empID);
        return "Employee with ID = " + empID + " Deleted !";
    }

    @Value("${hello.name}")
    private String helloName;

    @RequestMapping("/hello")
    public String readHelloFromApplicationProperty(){
      return  "Reading value of hello.name = "+helloName;
    }

}
