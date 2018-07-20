package com.tutorialsdesk.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class MissingStudentException extends WebApplicationException implements ExceptionMapper<MissingStudentException> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MissingStudentException() {
		super("No Student found with given rollNumber !!");
	}

	public MissingStudentException(String string) {
		super(string);
	}

	@Override
	public Response toResponse(MissingStudentException exception) {
		// 
		return Response.status(Status.NOT_FOUND).entity(exception.getMessage()).type(MediaType.TEXT_PLAIN).build();
	}

}
