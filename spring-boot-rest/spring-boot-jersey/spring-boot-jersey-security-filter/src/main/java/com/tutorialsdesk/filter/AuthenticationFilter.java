package com.tutorialsdesk.filter;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Priority;
import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.ws.rs.Priorities;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;

import com.tutorialsdesk.config.CustomSecurityContext;
import com.tutorialsdesk.exception.AuthenticationException;
import com.tutorialsdesk.model.User;
import com.tutorialsdesk.service.UserService;
/**
 * This filter verify the access permissions for a user
 * based on username and passowrd provided in request
 * */
@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter {

	private static final Logger LOGGER = Logger.getLogger(AuthenticationFilter.class.getName());
	
	@Context
    private ResourceInfo resourceInfo;

    @Autowired
    private UserService userService;
      
    @Override
    public void filter(ContainerRequestContext requestContext)throws IOException
    {
        Method method = resourceInfo.getResourceMethod();
        //Access allowed for all
        if( ! method.isAnnotationPresent(PermitAll.class))
        {
            //Access denied for all
            if(method.isAnnotationPresent(DenyAll.class))
            {
                requestContext.abortWith(Response.status(Response.Status.FORBIDDEN).entity("Access blocked for all users !!").build());
                
                return;
            }
         
            String authentication = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
            
            if (authentication == null) {
               
				throw new AuthenticationException("Authentication credentials are required");
				
            }

            if (!authentication.startsWith("Basic ")) {
                return;
            }
            
            authentication = authentication.substring("Basic ".length());
            
            String[] values = new String(DatatypeConverter.parseBase64Binary(authentication), 
                                         Charset.forName("ASCII")).split(":");
            if (values.length < 2) {
                throw new WebApplicationException(400);
            }

            String username = values[0];
            
            String password = values[1];

            LOGGER.log(Level.INFO, "{0} - {1}", new Object[]{username, password});

            User user = userService.getUser(username);
            
            if (user == null) {
                
				throw new AuthenticationException("Authentication credentials are required");
				
            }

            if (!user.password.equals(password)) {
                throw new AuthenticationException("Authentication credentials are required");
            }

            requestContext.setSecurityContext(new CustomSecurityContext(user));
        }
    }
   
}