package com.tutorialsdesk.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Component;

@Provider
@Component
public class AuthenticationException extends WebApplicationException //implements ExceptionMapper<AuthenticationException> 
{

	private static final long serialVersionUID = 1L;

	public AuthenticationException() {
		super("No Authorization found !!");
	}
	
	 public AuthenticationException(String message) {
         super(Response
                 .status(Status.UNAUTHORIZED)
                 .header("WWW-Authenticate", "Basic realm=\"" + "Dummy Realm" + "\"")
                 .type(MediaType.TEXT_PLAIN)
                 .entity(message)
                 .build());
     }

	
}
