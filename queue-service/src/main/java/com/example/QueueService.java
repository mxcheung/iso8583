package com.example;

import com.amazonaws.services.sqs.model.DeleteMessageRequest;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;
import com.amazonaws.services.sqs.model.SendMessageRequest;

public interface QueueService {

	//
	// Task 1: Define me.
	//
	// This interface should include the following methods. You should choose
	// appropriate
	// signatures for these methods that prioritise simplicity of implementation
	// for the range of
	// intended implementations (in-memory, file, and SQS). You may include
	// additional methods if
	// you choose.
	//
	// - push
	// pushes a message onto a queue.
	// - pull
	// retrieves a single message from a queue.
	// - delete
	// deletes a message from the queue that was received by pull().
	//
	public void push(SendMessageRequest sendMessageRequest );

	public ReceiveMessageResult pull(ReceiveMessageRequest receiveMessageRequest);

	public void delete(DeleteMessageRequest deleteMessageRequest);
}
