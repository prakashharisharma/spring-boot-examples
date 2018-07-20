package com.tutorialsdesk.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.stereotype.Component;

import com.tutorialsdesk.endpoint.StudentEndpoint;
//https://www.concretepage.com/spring-boot/spring-boot-jersey-rest-jpa-hibernate-crud-example
@Component
@ApplicationPath("/students-api")
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		//packages("com.tutorialsdesk");
		register(StudentEndpoint.class);
		register(JacksonContextResolver.class);
        
	   }
}
