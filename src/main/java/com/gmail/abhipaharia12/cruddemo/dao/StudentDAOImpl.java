package com.gmail.abhipaharia12.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gmail.abhipaharia12.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO{

    private EntityManager entityManager;

    @Autowired
    StudentDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    @Transactional
    public void save(Student theSudent) {
        this.entityManager.persist(theSudent);
    }
    @Override
    public Student findById(int id) {
        Student s = this.entityManager.find(Student.class, id);
        return s;
    }
    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query= this.entityManager.createQuery("FROM Student order by lastName asc", Student.class);
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery(
                                        "FROM Student WHERE lastName=:theData", Student.class);

        // set query parameters
        theQuery.setParameter("theData", theLastName);

        // return query results
        return theQuery.getResultList();
    }
    @Override
    @Transactional
    public void update(Student theStudent) {
        Student s = entityManager.merge(theStudent);
        System.out.println("returned state" + s);
    }
    @Override
    @Transactional
    public void delete(int id) {
        entityManager.remove(findById(id));
    }
    @Override
    @Transactional
    public int deleteAll() {
        return entityManager.createQuery("DELETE FROM Student").executeUpdate();
    }

}
