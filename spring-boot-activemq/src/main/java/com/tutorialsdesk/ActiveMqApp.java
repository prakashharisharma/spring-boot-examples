package com.tutorialsdesk;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;

import java.util.Arrays;

@SpringBootApplication
@EnableJms
public class ActiveMqApp {
    public static void main(String[] args) {
        SpringApplication.run(ActiveMqApp.class, args);
    }

}
