package com.tutorialsdesk.ws;

import java.util.Date;

import com.dlizarra.app.out.SayHiResponse;
import com.tutorialsdesk.service.Greeting;
import com.tutorialsdesk.service.GreetingService;
import com.tutorialsdesk.service.SayHelloResponse;

public class GreetingServiceImpl implements GreetingService {

	@Override
	public Greeting sayBye(String greetingsRequest) {
		Greeting greeting = new Greeting();
		greeting.setMessage("Bye " + greetingsRequest + "!!!");
		greeting.setDate(null);
		return greeting;
	}

	@Override
	public Greeting sayHello(String greetingsRequest) {
		Greeting greeting = new Greeting();
		greeting.setMessage("Hello " + greetingsRequest + "!!!");
		greeting.setDate(null);
		return greeting;
		
	}

}
