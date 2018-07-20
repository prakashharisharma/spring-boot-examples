package com.tutorialsdesk.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.tutorialsdesk.model.User;

@Service
public class UserServiceImpl implements UserService{

	public static final Map<String, User> users = new ConcurrentHashMap<>();

    static {
        users.put("admin", new User("admin", "password", "ADMIN"));
        users.put("user", new User("user", "password", "USER"));
    }
	
	@Override
	public User getUser(String username) {
		
		return users.get(username);
	}

}
