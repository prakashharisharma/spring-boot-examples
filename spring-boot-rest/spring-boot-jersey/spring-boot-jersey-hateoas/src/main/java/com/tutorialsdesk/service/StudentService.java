package com.tutorialsdesk.service;

import java.util.List;

import com.tutorialsdesk.model.Student;


public interface StudentService {
	List<Student> getAllStudents();
	Student getStudentByRollNumber(int rollNumber);
    boolean addStudent(Student student);
    Student updateStudent(Student student);
    boolean deleteStudent(int rollNumber);
}
