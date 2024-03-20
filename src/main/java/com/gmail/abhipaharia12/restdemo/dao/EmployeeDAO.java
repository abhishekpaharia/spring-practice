package com.gmail.abhipaharia12.restdemo.dao;

import java.util.List;

import com.gmail.abhipaharia12.restdemo.entity.Employee;

public interface EmployeeDAO {
    
    List<Employee> findAll();
}
