package com.gmail.abhipaharia12.cruddemo.dao;

import com.gmail.abhipaharia12.cruddemo.entity.Instructor;

public interface AppDao {

    void save(Instructor instructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);
}
