package com.tutorialsdesk.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HelloService {

	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "callOtherServiceFallback")
	public String callOtherService() {
		String response = restTemplate.getForObject("http://localhost:8081/", String.class);

		System.out.println(response);

		return response;
	}

	
	@SuppressWarnings("unused")
    private String callOtherServiceFallback() {
 
        System.out.println("Other Service is down!!! fallback route enabled...");
 
        return "CIRCUIT BREAKER ENABLED!!! No Response From Other Service at this moment. " +
                    " Service will be back shortly - " + LocalDateTime.now();
    }
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
