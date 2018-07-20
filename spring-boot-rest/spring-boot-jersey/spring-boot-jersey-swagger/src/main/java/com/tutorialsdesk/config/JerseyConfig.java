package com.tutorialsdesk.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.tutorialsdesk.endpoint.StudentEndpoint;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.config.SwaggerConfigLocator;
import io.swagger.jaxrs.config.SwaggerContextService;
import io.swagger.jaxrs.listing.ApiListingResource;

/*import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;*/
//https://www.concretepage.com/spring-boot/spring-boot-jersey-rest-jpa-hibernate-crud-example
@Component
@ApplicationPath("/students-api")
public class JerseyConfig extends ResourceConfig {

	private String apiPath = "/students-api";

	public JerseyConfig() {
		register(StudentEndpoint.class);

		BeanConfig swaggerConfig = new BeanConfig();
		swaggerConfig.setBasePath(apiPath);
		SwaggerConfigLocator.getInstance().putConfig(SwaggerContextService.CONFIG_ID_DEFAULT, swaggerConfig);

		packages(getClass().getPackage().getName(), ApiListingResource.class.getPackage().getName());
	}

}
