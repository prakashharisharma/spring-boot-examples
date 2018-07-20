package com.tutorialsdesk.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.tutorialsdesk.endpoint.StudentEndpoint;
import com.tutorialsdesk.exception.MissingStudentException;
//https://www.concretepage.com/spring-boot/spring-boot-jersey-rest-jpa-hibernate-crud-example
@Component
@ApplicationPath("/students-api")
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		
		register(StudentEndpoint.class);
		//To register Excpetion Provider
		register(MissingStudentException.class);
	   }
}
