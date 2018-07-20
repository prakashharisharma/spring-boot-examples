package com.tutorialsdesk.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutorialsdesk.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
}
