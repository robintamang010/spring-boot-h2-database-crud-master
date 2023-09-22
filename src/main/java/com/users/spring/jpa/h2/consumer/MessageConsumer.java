package com.users.spring.jpa.h2.consumer;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.*;

public class MessageConsumer {

    private final AmazonSQS sqs;
    private final String queueUrl;

    public MessageConsumer(AmazonSQS sqs, String queueUrl) {
        this.sqs = sqs;
        this.queueUrl = queueUrl;
    }

    public void receiveMessages() {
        ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(queueUrl)
                .withMaxNumberOfMessages(5) // Adjust as needed
                .withWaitTimeSeconds(20); // Adjust as needed

        ReceiveMessageResult receiveMessageResult = sqs.receiveMessage(receiveMessageRequest);

        for (Message message : receiveMessageResult.getMessages()) {
            // Process the message (you can replace this with your logic)
            System.out.println("Received message: " + message.getBody());

            // Delete the message from the queue after processing
            String receiptHandle = message.getReceiptHandle();
            sqs.deleteMessage(new DeleteMessageRequest(queueUrl, receiptHandle));
        }
    }

}
