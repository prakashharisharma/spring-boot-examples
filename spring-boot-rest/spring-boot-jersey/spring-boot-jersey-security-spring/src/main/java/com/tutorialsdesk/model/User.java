package com.tutorialsdesk.model;

public class User {

	public final String username;
    public final String role;
    public final String password;

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

	public String getUsername() {
		return username;
	}

	public String getRole() {
		return role;
	}

	public String getPassword() {
		return password;
	}

}
