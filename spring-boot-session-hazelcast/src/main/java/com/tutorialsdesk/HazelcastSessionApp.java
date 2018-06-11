package com.tutorialsdesk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.hazelcast.config.annotation.web.http.EnableHazelcastHttpSession;

@SpringBootApplication
@EnableHazelcastHttpSession
public class HazelcastSessionApp {
	
    public static void main(String[] args) {
        SpringApplication.run(HazelcastSessionApp.class, args);
    }
}
