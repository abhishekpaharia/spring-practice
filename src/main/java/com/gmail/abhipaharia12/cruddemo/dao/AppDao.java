package com.gmail.abhipaharia12.cruddemo.dao;

import java.util.List;

import com.gmail.abhipaharia12.cruddemo.entity.Course;
import com.gmail.abhipaharia12.cruddemo.entity.Instructor;
import com.gmail.abhipaharia12.cruddemo.entity.InstructorDetail;

public interface AppDao {

    void save(Instructor instructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);

    List<Course> findCoursesByInstructorId(int theId);

    Instructor findInstructorByIdJoinFetch(int theId);

    void testTransactionAndSession();

    void update(Instructor tempInstructor);

    void update(Course tempCourse);

    Course findCourseById(int theId);

    void deleteCourseById(int theId);
}
