package com.tutorialsdesk.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.tutorialsdesk.model.Greeting;
import com.tutorialsdesk.service.GreetingService;

@Service
public class GreetingServiceImpl implements GreetingService {

	@Override
	public Greeting sayHello(String name) {
		Greeting greeting = new Greeting();
		greeting.setMessage("Hello " + name + "!!!");
		greeting.setDate(new Date());
		return greeting;
	}

	@Override
	public Greeting sayBye(String name) {
		Greeting greeting = new Greeting();
		greeting.setMessage("Bye " + name + "!!!");
		greeting.setDate(new Date());
		return greeting;
	}

}
