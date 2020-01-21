package com.dfeingol.springboot.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.dfeingol.springboot.demo.entity.Student;

import java.util.List;

@Repository
@Transactional
public class StudentRepository {

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  EntityManager em;

  // find student by id
  public Student findById(Long id) {
    return em.find(Student.class, id);
  }

  // this will save or update a student
  public Student save(Student student) {
    if (student.getId() == null) {
      em.persist(student);
    } else {
      em.merge(student);
    }
    return student;
  }

  //hard delete of a student
  public void deleteById(Long id) {
    Student student = findById(id);
    em.remove(student);
  }

  // Use a named query
  public List<Student> getAllStudents() {
    Query query = em.createNamedQuery("query_get_all_students");
    List<Student> resultList = query.getResultList();
    logger.info("Select  s  From Student s -> {}", resultList);
    return resultList;
  }
}
