package com.tutorialsdesk.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.apache.cxf.annotations.Policies;
import org.apache.cxf.annotations.Policy;

import com.tutorialsdesk.model.Greeting;

@WebService(serviceName = "InfoService")
@Policies({ @Policy(uri = "/ut/policy.xml") })
public interface InfoService {
	@WebMethod()
	@WebResult(name = "Greeting")
	public Greeting sayHowAreYou(@WebParam(name = "GreetingsRequest") String name);	
}