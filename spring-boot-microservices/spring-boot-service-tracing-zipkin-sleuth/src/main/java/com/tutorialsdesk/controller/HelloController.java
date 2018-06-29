package com.tutorialsdesk.controller;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

	private static final Logger LOG = Logger.getLogger(HelloController.class.getName());

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/")
	public String home() {
		LOG.log(Level.INFO, "you called home");
		return "Hello World";
	}

	@RequestMapping("/callhome")
	public String callHome() {
		LOG.log(Level.INFO, "calling home");
		return restTemplate.getForObject("http://localhost:8080", String.class);
	}

	
	@Bean
	public RestTemplate getRestTemplate() {
	    return new RestTemplate();
	}
}
