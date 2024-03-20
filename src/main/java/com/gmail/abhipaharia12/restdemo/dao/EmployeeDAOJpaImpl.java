package com.gmail.abhipaharia12.restdemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gmail.abhipaharia12.restdemo.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{
    // define field for entitymanager
    private EntityManager entityManager;


    // set up constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }


    @Override
    public List<Employee> findAll() {

        // create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        // execute query and get result list
        List<Employee> employees = theQuery.getResultList();

        // return the results
        return employees;
    }


    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class, id);
    }


    @Override
    public Employee save(Employee theEmployee) {
        return entityManager.merge(theEmployee);
    }


    @Override
    public void deleteById(int id) {
        Employee emp = entityManager.find(Employee.class, id);
        entityManager.remove(emp);
    }
}
