package com.example;

import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageRequest;

public class FileQueueService implements QueueService {

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


  //
  // Task 3: Implement me if you have time.
  //



}
