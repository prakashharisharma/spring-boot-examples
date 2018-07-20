package com.tutorialsdesk.endpoint;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

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
import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.jaxrs.JaxRsLinkBuilder;
import org.springframework.stereotype.Component;

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
	@Produces(MediaTypes.HAL_JSON_VALUE)
	// http://localhost:8080/students-api/students
	public Response getStudentDetails() {
		List<Student> list = studentService.getAllStudents();
		
		final Resources<Student> studentResources = new Resources<>(list);
		
		studentResources.add(JaxRsLinkBuilder.linkTo(StudentEndpoint.class).withSelfRel());
		
		return Response.ok(studentResources).build();
	}

	@GET
	@Path("/{rollNumber}")
	@Produces(MediaTypes.HAL_JSON_VALUE)
	// http://localhost:8080/students-api/students/1
	public Response getStudentById(@PathParam("rollNumber") Integer rollNumber) {

		Student student = studentService.getStudentByRollNumber(rollNumber);
		
		final Resource<Student> studentResource = new Resource<>(student);
		
		studentResource.add(JaxRsLinkBuilder.linkTo(StudentEndpoint.class).withRel("allstudents"));
		studentResource.add(JaxRsLinkBuilder.linkTo(StudentEndpoint.class).slash(rollNumber).withSelfRel());
		
		return Response.ok(studentResource).build();
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
	public Response deleteStudent(@PathParam("rollNumber") Integer rollNumber) {

		boolean isDeleted = studentService.deleteStudent(rollNumber);

		if (isDeleted) {
			return Response.noContent().build();
		} else {
			return Response.status(Status.NOT_FOUND).build();
		}
	}
}
