package com.tutorialsdesk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StreamKafkaApp {

    public static void main(String[] args) {
        SpringApplication.run(StreamKafkaApp.class, args);
    }
}

//http://localhost:8080/greetings?message=helloKafka