package com.users.spring.jpa.h2.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class JmsListenerService {

    @JmsListener(destination = "test-jms-queue-name")
    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);

    }
}
