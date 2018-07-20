package com.tutorialsdesk.config;

import java.security.Principal;

import javax.ws.rs.core.SecurityContext;

import com.tutorialsdesk.model.User;

public class CustomSecurityContext implements SecurityContext{

	private User user;
	
	public CustomSecurityContext( User user){
		this.user = user;
	}
	
	@Override
	public String getAuthenticationScheme() {
		
		return "Basic";
	}

	@Override
	public Principal getUserPrincipal() {
		
		return new Principal() {
            @Override
            public String getName() {
                return user.getUsername();
            }
        };
	}

	@Override
	public boolean isSecure() {
	
		return true;
	}

	@Override
	public boolean isUserInRole(String role) {
	
		System.out.println(role);
		
		return role.equals(user.getRole());
	}

}
