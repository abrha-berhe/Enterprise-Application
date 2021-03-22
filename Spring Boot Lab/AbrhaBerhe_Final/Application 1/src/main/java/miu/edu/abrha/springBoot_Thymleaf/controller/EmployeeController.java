package miu.edu.abrha.springBoot_Thymleaf.controller;

import miu.edu.abrha.springBoot_Thymleaf.model.Employee;
import miu.edu.abrha.springBoot_Thymleaf.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> addEmployees(@RequestBody Employee emp) {
        return employeeService.addEmployee(emp);
    }

    @GetMapping("/employees/{id}")
    public Employee getOneEmployee(@PathVariable Long id) {
        Optional<Employee> em = employeeService.getOneEmployee(id);
        return em.orElse(null);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp, @PathVariable Long id) {
        Employee employee = employeeService.getOneEmployee(id).orElse(null);
        if (employee != null) {
            employee.setFirstName(emp.getFirstName());
            employee.setLastName(emp.getLastName());
            employee.setEmail(emp.getEmail());
        } else {
            employee = emp;
        }


        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable Long id) {
        Employee employee = employeeService.getOneEmployee(id).orElse(null);
        if (employee != null)
            return employeeService.deleteEmployee(id);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);//:"Data not found");
    }


}




