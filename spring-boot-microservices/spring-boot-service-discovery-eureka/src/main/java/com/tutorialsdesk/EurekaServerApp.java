package com.tutorialsdesk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

//Eureka Server Can be accessed at http://localhost:8761/
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApp {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(EurekaServerApp.class, args);
	}

}
