package com.tutorialsdesk.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tutorialsdesk.model.Student;

@Service
public class StudentServiceImpl implements StudentService{

	private static List<Student> studentList= new ArrayList<Student>();
	
	
	static {
		studentList.add(new Student(1,"Prakash", "B.Tech"));
	}
	
	@Override
	public List<Student> getAllStudents() {
		
		return studentList;
	}

	@Override
	public Student getStudentByRollNumber(final int rollNumber) {
		
		return studentList.stream().filter( s -> rollNumber == s.getRollNumber() ).findAny().orElse(null);	
	}
	
	@Override
	public boolean addStudent(Student student) {
		boolean isAdded = false;
		Student stu = studentList.stream().filter( s -> student.getRollNumber() == s.getRollNumber() ).findAny().orElse(null);
		if(stu==null) {
			studentList.add(student);
			isAdded = true;
		}
		
		return isAdded;
	}

	@Override
	public Student updateStudent(final Student student) {
		
		Student stu = studentList.stream().filter( s -> student.getRollNumber() == s.getRollNumber() ).findAny().orElse(null);
		
		if(stu!=null) {
			studentList.removeIf(s -> student.getRollNumber() == s.getRollNumber());
			stu.setName(student.getName());
			stu.setCourse(student.getCourse());
			studentList.add(stu);
		}else {
			studentList.add(student);
			stu = student;
		}
		
		return stu;
	}

	@Override
	public boolean deleteStudent(int rollNumber) {
		return studentList.removeIf(s -> rollNumber == s.getRollNumber());
		
	}

}
