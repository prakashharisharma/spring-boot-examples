package com.tutorialsdesk.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/")
	public String echoTheUsersEmailAddress() {
	   return "Hey there from consul client service";
	}
}
