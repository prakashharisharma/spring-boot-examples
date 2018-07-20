package com.tutorialsdesk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//https://jersey.github.io/documentation/latest/declarative-linking.html

@SpringBootApplication
public class JerseyApp {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(JerseyApp.class, args);
	}

}
