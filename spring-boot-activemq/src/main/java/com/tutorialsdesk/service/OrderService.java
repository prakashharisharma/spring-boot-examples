package com.tutorialsdesk.service;

import com.tutorialsdesk.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import static com.tutorialsdesk.service.OrderConsumer.ORDER_QUEUE;

@Service
public class OrderService {
    private static Logger log = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    public void send(Order order) {
        log.info("sending with convertAndSend() to queue <" + order + ">");
        jmsTemplate.convertAndSend(ORDER_QUEUE, order);
    }
}
