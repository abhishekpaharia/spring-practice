package com.gmail.abhipaharia12.cruddemo.dao;

import com.gmail.abhipaharia12.cruddemo.entity.Instructor;
import com.gmail.abhipaharia12.cruddemo.entity.InstructorDetail;

public interface AppDao {

    void save(Instructor instructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);
}
