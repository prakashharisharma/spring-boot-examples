package com.tutorialsdesk;

import com.tutorialsdesk.model.Order;
import com.tutorialsdesk.service.OrderService;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Component
public class AppRunner implements CommandLineRunner {



    private static Logger log = LoggerFactory.getLogger(AppRunner.class);

    @Autowired
    private OrderService orderService;

    @Override
    public void run(String... strings) throws Exception {

        log.info("Spring Boot Embedded ActiveMQ Configuration Example");

        for (int i = 0; i < 5; i++){
            int priority=i+1;
            Order order = new Order(i,  " - Sending JMS Message using Embedded activeMQ", LocalDateTime.now());
            orderService.send(order);

        }

        log.info("Waiting for all ActiveMQ JMS Messages to be consumed");
        //TimeUnit.SECONDS.sleep(3);
        //System.exit(-1);
    }
}
