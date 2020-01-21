package com.dfeingol.springboot.demo.controller;

import com.dfeingol.springboot.demo.entity.Student;
import com.dfeingol.springboot.demo.repository.StudentRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for create, read, update, get for students
 */
@Api(tags = "Student Course Management RESTful Services", value = "StudentController", description = "Controller for Student Management Service")
@RestController
@RequestMapping(value = "/students")
public class StudentController {


  private StudentRepository studentRepository;

  @Autowired
  public StudentController(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  // create student
  @ApiOperation(value = "Create a Student", notes = "")
  @PostMapping(produces = "application/json; charset=UTF-8", consumes = "application/json; charset=UTF-8")
  public ResponseEntity<Student> saveStudent(@ApiParam("Student information for a new student to be created.")
                                             @RequestBody Student student) throws Exception {
    this.studentRepository.save(student);
    return new ResponseEntity<>(student, HttpStatus.OK);
  }

  // update student
  @ApiOperation(value = "Update a Student", notes = "")
  @PutMapping(produces = "application/json; charset=UTF-8", consumes = "application/json; charset=UTF-8")
  public ResponseEntity<Student> updateStudent(@ApiParam("Student information for a new student to be update.")
                                               @RequestBody Student student) throws Exception {
    this.studentRepository.save(student);
    return new ResponseEntity<>(student, HttpStatus.OK);
  }

  //find all students
  @ApiOperation(value = "Retrieve all Students", notes = "")
  @GetMapping(produces = "application/json; charset=UTF-8")
  public ResponseEntity<List<Student>> getAllStudent() throws Exception {
    List<Student> students = this.studentRepository.getAllStudents();
    return new ResponseEntity<>(students, HttpStatus.OK);
  }

  //get student by Id
  @ApiOperation(value = "Retriev Student by Id", notes = "")
  @GetMapping(value="/{id}",produces = "application/json; charset=UTF-8")
  public ResponseEntity<Student> findtudentById(Long id) throws Exception {
    Student student = this.studentRepository.findById(id);
    return new ResponseEntity<>(student, HttpStatus.OK);
  }
}
