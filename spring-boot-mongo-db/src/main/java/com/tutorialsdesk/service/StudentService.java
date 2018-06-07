package com.tutorialsdesk.service;

import com.tutorialsdesk.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> findByName(String firstName);

    Student findByRollNumberName(String rollNumber);

    void deleteAll();

    List<Student> findAll();

    Student saveStudent(Student student);
}
