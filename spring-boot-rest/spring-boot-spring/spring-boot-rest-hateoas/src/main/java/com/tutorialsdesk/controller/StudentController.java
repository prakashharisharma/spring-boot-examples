package com.tutorialsdesk.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorialsdesk.model.Student;
import com.tutorialsdesk.service.StudentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

@RestController
@RequestMapping("/students")
@Api(value = "Student API - it's all about student services", produces = "application/json")
public class StudentController {

	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	private StudentService studentService;

	@GetMapping(value="/", produces = MediaType.APPLICATION_JSON_VALUE )
	@ApiOperation( // Swagger Annotation
			value = "get All Students", response = ArrayList.class)
	@ApiResponses(value = { // Swagger Annotation
			@ApiResponse(code = 200, message = "Resource found"),
			@ApiResponse(code = 404, message = "Resource not found") })
	// http://localhost:8080/students-api/students
	public ResponseEntity<List<Student>> getStudentDetails() {
		
		List<Student> list = studentService.getAllStudents();
		
		return ResponseEntity.ok(list);
	}

	@GetMapping(value="/{rollNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation( // Swagger Annotation
			value = "get Student By Roll Number", response = Student.class)
	@ApiResponses(value = { // Swagger Annotation
			@ApiResponse(code = 200, message = "Resource found"),
			@ApiResponse(code = 404, message = "Resource not found") })
	// http://localhost:8080/students-api/students/1
	public ResponseEntity<Student> getStudentById(@PathVariable("rollNumber") Integer rollNumber) {
		Student student = studentService.getStudentByRollNumber(rollNumber);
		
        student.add(
        		linkTo(methodOn(StudentController.class).getStudentDetails()).withRel("All Students")
        		);
        student.add(
        		linkTo(methodOn(StudentController.class).getStudentById(rollNumber)).withSelfRel()
        		);
		
		return ResponseEntity.ok(student);
	}

	@PostMapping(value="/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addStudent(Student student) {
		boolean isAdded = studentService.addStudent(student);
		if (!isAdded) {
			logger.info("Student already exits.");
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		return ResponseEntity.created(URI.create("/students/" + student.getRollNumber())).build();
		
	}

	@PutMapping(value="/{rollNumber}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> updateStudent(@PathVariable("rollNumber") Integer rollNumber, Student student) {

		studentService.updateStudent(student);

		return ResponseEntity.ok(student);

	}

	@DeleteMapping(value="/{rollNumber}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteStudent(@PathVariable("rollNumber") Integer rollNumber) {

		boolean isDeleted = studentService.deleteStudent(rollNumber);

		if (isDeleted) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
