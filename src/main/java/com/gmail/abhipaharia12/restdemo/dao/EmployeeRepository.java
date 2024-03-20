package com.gmail.abhipaharia12.restdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gmail.abhipaharia12.restdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
    // that's it ... no need to write any code LOL!
}
