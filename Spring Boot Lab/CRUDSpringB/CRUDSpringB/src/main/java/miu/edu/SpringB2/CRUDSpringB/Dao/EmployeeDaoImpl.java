package miu.edu.SpringB2.CRUDSpringB.Dao;

import miu.edu.SpringB2.CRUDSpringB.Entity.Employee;
import org.hibernate.EntityMode;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    @Override
    public List<Employee> findAll() {
        Session session = entityManager.unwrap(Session.class);
        Query myQuery = session.createQuery("from Employee", Employee.class);
        List<Employee> employees = myQuery.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int id) {
        Session session = entityManager.unwrap(Session.class);
        Employee employee = session.find(Employee.class, id);
        return employee;
    }

    @Override
    public void save(Employee employee) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(employee);
    }

    @Override
    public void deleteByID(int id) {
        Session session = entityManager.unwrap(Session.class);
        Query myQuery = session.createQuery("delete from Employee where id=:employeeID");
        myQuery.setParameter("employeeID",id);
        myQuery.executeUpdate();
    }
}
