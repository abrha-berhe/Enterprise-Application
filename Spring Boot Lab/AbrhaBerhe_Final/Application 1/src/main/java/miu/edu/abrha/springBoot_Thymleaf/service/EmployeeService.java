package miu.edu.abrha.springBoot_Thymleaf.service;

import miu.edu.abrha.springBoot_Thymleaf.dao.EmployeeDao;
import miu.edu.abrha.springBoot_Thymleaf.model.Employee;
import org.hibernate.loader.plan.spi.EntityReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
public class EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    public ResponseEntity<Employee> addEmployee(Employee employee) {
        employeeDao.save(employee);
        return ResponseEntity.status(200).build();
    }

    public List<Employee> getAllEmployees() {
        return employeeDao.findAll();
    }

    public Optional<Employee> getOneEmployee(Long id) {
        return employeeDao.findById(id);
    }

    public ResponseEntity<Employee> updateEmployee(Employee employee) {
        employeeDao.save(employee);
        return ResponseEntity.status(201).build();
    }

    public ResponseEntity<Employee> deleteEmployee(Long id) {
        employeeDao.deleteById(id);
        return ResponseEntity.status(201).build();
    }
}
