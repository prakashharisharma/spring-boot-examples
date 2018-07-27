package com.tutorialsdesk.controller;



import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tutorialsdesk.model.Greetings;
import com.tutorialsdesk.service.producer.GreetingsService;

@RestController
public class GreetingsController {
    private final GreetingsService greetingsService;

    public GreetingsController(GreetingsService greetingsService) {
        this.greetingsService = greetingsService;
    }

    @GetMapping("/greetings")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String greetings(@RequestParam("message") String message) {
        Greetings greetings =new  Greetings(System.currentTimeMillis(), message);

        greetingsService.sendGreeting(greetings);
        
        return message +" Sent to KAFKA";
    }
}
