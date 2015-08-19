package com.example;

import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageRequest;

public class SqsQueueService implements QueueService {
	//
	// Task 4: Optionally implement parts of me.
	//
	// This file is a placeholder for an AWS-backed implementation of
	// QueueService. It is included
	// primarily so you can quickly assess your choices for method signatures in
	// QueueService in
	// terms of how well they map to the implementation intended for a
	// production environment.
	//

	public SqsQueueService(AmazonSQSClient sqsClient) {
	}

	@Override
	public void push(SendMessageRequest sendMessageRequest) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public com.amazonaws.services.sqs.model.ReceiveMessageResult pull(ReceiveMessageRequest receiveMessageRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(com.amazonaws.services.sqs.model.DeleteMessageRequest deleteMessageRequest) {
		// TODO Auto-generated method stub
		
	}


}
