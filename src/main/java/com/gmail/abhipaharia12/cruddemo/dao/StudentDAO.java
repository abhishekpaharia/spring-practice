package com.gmail.abhipaharia12.cruddemo.dao;

import java.util.List;

import com.gmail.abhipaharia12.cruddemo.entity.Student;

public interface StudentDAO {
    void save(Student theSudent);

    Student findById(int id);

    List<Student> findAll();

    List<Student> findByLastName(String theLastName);

    void update(Student theStudent);

    void delete(int id);

    int deleteAll();
}
