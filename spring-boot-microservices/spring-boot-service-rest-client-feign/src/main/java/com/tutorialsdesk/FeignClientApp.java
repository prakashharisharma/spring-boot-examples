package com.tutorialsdesk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class FeignClientApp {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(FeignClientApp.class, args);
	}

}
