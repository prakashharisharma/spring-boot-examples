package com.tutorialsdesk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tutorialsdesk.service.HelloService;

@RestController
public class HelloController {

	@Autowired
	HelloService helloService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String getStudents() {
        System.out.println("Going to call hello service to get data!");
        return helloService.callOtherService();
    }
	
}
