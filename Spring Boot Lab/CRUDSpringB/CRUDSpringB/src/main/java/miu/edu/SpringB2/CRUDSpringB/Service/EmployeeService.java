package miu.edu.SpringB2.CRUDSpringB.Service;

import miu.edu.SpringB2.CRUDSpringB.Entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();
    public Employee findById(int id);
    public void save(Employee employee);
    public void deleteByID(int id);
}
