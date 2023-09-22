package com.users.spring.jpa.h2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsTemplate;

@SpringBootTest
public class SQSMessageListenerTest {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Test
    public void testSQSMessageListener() throws InterruptedException {
        // Send a sample message to the queue for testing
        jmsTemplate.convertAndSend("testQueue", "Test Message");

        // Sleep to allow the listener to process the message (you can adjust the timing as needed)
        Thread.sleep(5000);
    }
}
