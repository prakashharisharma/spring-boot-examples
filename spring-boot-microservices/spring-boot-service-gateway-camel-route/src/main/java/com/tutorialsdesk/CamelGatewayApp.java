package com.tutorialsdesk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class CamelGatewayApp {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(CamelGatewayApp.class, args);
	}

}
