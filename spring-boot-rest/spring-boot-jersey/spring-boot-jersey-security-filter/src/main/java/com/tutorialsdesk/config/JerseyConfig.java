package com.tutorialsdesk.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.tutorialsdesk.endpoint.HelloEndpoint;
import com.tutorialsdesk.endpoint.StudentEndpoint;
import com.tutorialsdesk.exception.AuthenticationException;
import com.tutorialsdesk.exception.MissingStudentException;
import com.tutorialsdesk.filter.AuthenticationFilter;
//https://www.concretepage.com/spring-boot/spring-boot-jersey-rest-jpa-hibernate-crud-example
@Component
@ApplicationPath("/students-api")
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		
		packages("com.tutorialsdesk");
		register(StudentEndpoint.class);
		register(HelloEndpoint.class);
		//To register Excpetion Provider
		register(MissingStudentException.class);
		register(AuthenticationException.class);
		//Register Auth Filter here
        register(AuthenticationFilter.class);
        
        
	   }
}
