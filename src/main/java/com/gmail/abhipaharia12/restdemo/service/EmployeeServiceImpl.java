package com.gmail.abhipaharia12.restdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gmail.abhipaharia12.restdemo.dao.EmployeeRepository;
import com.gmail.abhipaharia12.restdemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{
     private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
        employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        Employee theEmployee = null;
        if(result.isPresent()){
            theEmployee = result.get();
        } else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + id);
        }
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee resultEmployee = null;
        if(theEmployee != null){
            resultEmployee = employeeRepository.save(theEmployee);
        } else {
            throw new RuntimeException("Can't save null as Employee");
        }
        return resultEmployee;
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }  
}
