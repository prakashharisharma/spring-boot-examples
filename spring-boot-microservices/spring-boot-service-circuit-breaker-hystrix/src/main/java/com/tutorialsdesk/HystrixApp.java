package com.tutorialsdesk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableHystrixDashboard
@EnableCircuitBreaker
@SpringBootApplication
public class HystrixApp {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(HystrixApp.class, args);
	}

}
