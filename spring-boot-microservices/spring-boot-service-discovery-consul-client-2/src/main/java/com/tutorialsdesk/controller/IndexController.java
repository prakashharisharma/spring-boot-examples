package com.tutorialsdesk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class IndexController {

	@Autowired
    RestTemplate restTemplate;
	
	@GetMapping("/")
	public String echoTheUsersEmailAddress() {
	   return "Hey there from consul client service 2";
	}
	
	@GetMapping("/call-discovery-service/")
	public String callOtherServiceUsingConsulDiscovery() {
		String response = restTemplate.getForObject("http://consul-client-service/", String.class);
		
		System.out.println(response);
		
		return response;
	}
	
	
	@Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
