package com.example;

import com.amazonaws.services.sqs.model.DeleteMessageRequest;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.example.Queue.Service.QueueRequestHandler;
import com.example.QueueRepository.QueueRepository;
import com.example.QueueRepository.InMemory.InMemoryQueueRepository;

public class InMemoryQueueService implements QueueService {

	private final QueueRepository queueRepository;
	private final QueueRequestHandler queueRequestHandler;

	public InMemoryQueueService() {
		queueRepository = new InMemoryQueueRepository();
		queueRequestHandler = new QueueRequestHandler(queueRepository);
	}

	public InMemoryQueueService(QueueRepository queueRepository) {
		this.queueRepository = queueRepository;
		this.queueRequestHandler = new QueueRequestHandler(queueRepository);
		;
	}

	//
	// Task 2: Implement me.
	//

	public ReceiveMessageResult pull(ReceiveMessageRequest receiveMessageRequest) {
		return queueRequestHandler.processReceiveMessageRequest(receiveMessageRequest);
	}

	public void push(SendMessageRequest sendMessageRequest) {
		queueRequestHandler.processSendMessageRequest(sendMessageRequest);
	}

	public void delete(DeleteMessageRequest deleteMessageRequest) {
		queueRequestHandler.processDeleteMessageRequest(deleteMessageRequest);
	}

}
