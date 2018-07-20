package com.tutorialsdesk.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.core.MediaType;
import org.springframework.stereotype.Component;

@Provider
@Component
public class MissingStudentException extends Exception implements ExceptionMapper<MissingStudentException> {

	private static final long serialVersionUID = 1L;

	public MissingStudentException() {
		super("No Student found with given rollNumber !!");
	}

	public MissingStudentException(String string) {
		super(string);
	}

	@Override
	public Response toResponse(MissingStudentException exception) {
		return Response.status(Status.NOT_FOUND).entity(exception.getMessage()).type(MediaType.TEXT_PLAIN).build();
	}

}
