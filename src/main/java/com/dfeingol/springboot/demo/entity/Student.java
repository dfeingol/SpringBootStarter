package com.dfeingol.springboot.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@NamedQueries(value = {
        @NamedQuery(name = "query_get_all_students",
                query = "Select  s  From Student s order by s.name")})
@Entity
public class Student {

  @Id
  @GeneratedValue
  private Long id;

  @Column(nullable = false)
  private String name;

  protected Student() {
  }

  public Student(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  @Override
  public String toString() {
    return String.format("Student[%s]", name);
  }
}