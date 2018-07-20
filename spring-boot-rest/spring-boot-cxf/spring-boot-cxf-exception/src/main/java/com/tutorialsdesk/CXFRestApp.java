package com.tutorialsdesk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//http://localhost:8080/api/services/
@SpringBootApplication
public class CXFRestApp {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(CXFRestApp.class, args);
	}

}
