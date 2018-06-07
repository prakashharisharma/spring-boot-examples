package com.tutorialsdesk.service;

import com.tutorialsdesk.model.Student;
import com.tutorialsdesk.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findByName(String firstName) {
        return studentRepository.findByName(firstName);
    }

    @Override
    public Student findByRollNumberName(String rollNumber) {
        return studentRepository.findByRollNumber(rollNumber);
    }

    @Override
    public void deleteAll() {
        studentRepository.deleteAll();
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
}
