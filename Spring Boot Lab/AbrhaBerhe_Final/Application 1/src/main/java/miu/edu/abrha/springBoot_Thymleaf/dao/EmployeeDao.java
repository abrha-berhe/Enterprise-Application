package miu.edu.abrha.springBoot_Thymleaf.dao;


import miu.edu.abrha.springBoot_Thymleaf.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee, Long> {
}
