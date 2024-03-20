package com.gmail.abhipaharia12.restdemo.service;

import com.gmail.abhipaharia12.restdemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee theEmployee);

    void deleteById(int id);
}