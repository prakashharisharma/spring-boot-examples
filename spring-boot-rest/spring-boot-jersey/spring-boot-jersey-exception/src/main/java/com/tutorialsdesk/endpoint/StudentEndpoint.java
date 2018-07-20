package com.tutorialsdesk.endpoint;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tutorialsdesk.exception.MissingStudentException;
import com.tutorialsdesk.model.Student;
import com.tutorialsdesk.service.StudentService;

@Component
@Path("/students")
public class StudentEndpoint {

	private static final Logger logger = LoggerFactory.getLogger(StudentEndpoint.class);

	@Autowired
	private StudentService studentService;

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	// http://localhost:8080/students-api/students
	public Response getStudentDetails() {
		List<Student> list = studentService.getAllStudents();
		return Response.ok(list).build();
	}

	@GET
	@Path("/{rollNumber}")
	@Produces(MediaType.APPLICATION_JSON)
	// http://localhost:8080/students-api/students/1
	public Response getStudentByRollNumbner(@PathParam("rollNumber") Integer rollNumber) {
		Student student = studentService.getStudentByRollNumber(rollNumber);
		return Response.ok(student).build();
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addStudent(Student student) {
		boolean isAdded = studentService.addStudent(student);
		if (!isAdded) {
			logger.info("Student already exits.");
			return Response.status(Status.CONFLICT).build();
		}
		return Response.created(URI.create("/students/" + student.getRollNumber())).build();
	}

	@PUT
	@Path("/{rollNumber}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateStudent(@PathParam("rollNumber") Integer rollNumber, Student student) {

		studentService.updateStudent(student);

		return Response.ok(student).build();

	}

	@DELETE
	@Path("/{rollNumber}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteStudent(@PathParam("rollNumber") Integer rollNumber) throws MissingStudentException {

		boolean isDeleted = studentService.deleteStudent(rollNumber);

		if (isDeleted) {
			return Response.noContent().build();
		} else {
			throw new MissingStudentException("RollNumber : " +rollNumber + " does not exist!!!");
		}
	}
}
