package com.tutorialsdesk.endpoint;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Path("/hello")
public class HelloEndpoint {

	private static final Logger logger = LoggerFactory.getLogger(HelloEndpoint.class);

	@PermitAll
	@GET
	@Path("/unsecured")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getHello() {
		return Response.ok("Hello, This resuorce is permittel to all.").build();
	}
	
	@DenyAll
	@GET
	@Path("/secured")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getNoHello() {
		return Response.ok("Hello, This resuorce is denied to all.").build();
	}
}
