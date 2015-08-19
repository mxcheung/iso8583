package com.example.Queue.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import com.amazonaws.services.sqs.model.DeleteMessageRequest;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.example.QueueRepository.QueueRepository;
import com.example.QueueRepository.InMemory.InMemoryQueue;
import com.example.QueueRepository.InMemory.InMemoryQueueRepository;

public class QueueRequestHandler {

	private QueueRepository queueRepository;

	public QueueRequestHandler() {
		this(new InMemoryQueueRepository());
	}

	public QueueRequestHandler(QueueRepository queueRepository) {
		this.queueRepository = queueRepository;
	}

	public InMemoryQueue fetchQueue(String queueName) {
		InMemoryQueue inMemoryQueue = null;
		try {
			inMemoryQueue = queueRepository.find(queueName);
		} catch (NoSuchElementException e) {
			inMemoryQueue = createQueue(queueName);
		}
		return inMemoryQueue;
	}

	private InMemoryQueue createQueue(String queueName) {
		InMemoryQueue inMemoryQueue = new InMemoryQueue();
		inMemoryQueue.setName(queueName);
		queueRepository.save(queueName, inMemoryQueue);
		return inMemoryQueue;
	}

	public Message fetchMessage(String queueName) {
		InMemoryQueue inMemoryQueue = fetchQueue(queueName);
		Message message = inMemoryQueue.peek();
		if (message != null) {
			message.setReceiptHandle(UUID.randomUUID().toString());
		}
		return message;
	}

	public void processDeleteMessageRequest(DeleteMessageRequest deleteMessageRequest) {
		deleteMessage(deleteMessageRequest.getQueueUrl(), deleteMessageRequest.getReceiptHandle());
	}

	private void deleteMessage(String queueName, String messageReceiptHandle) {
		InMemoryQueue inMemoryQueue = fetchQueue(queueName);
		Message message = inMemoryQueue.peek();
		if (message.getReceiptHandle() == messageReceiptHandle) {
			inMemoryQueue.remove();
		}
	}

	public ReceiveMessageResult processReceiveMessageRequest(ReceiveMessageRequest receiveMessageRequest) {
		List<Message> messages = new ArrayList<Message>();
		Message message = fetchMessage(receiveMessageRequest.getQueueUrl());
		if (message != null) {
			if (receiveMessageRequest.getVisibilityTimeout() != null) {
				int timeout = receiveMessageRequest.getVisibilityTimeout();
				message.addAttributesEntry("VisibilityTimeout", new Integer(timeout).toString());
			}
			messages.add(message);
		}
		ReceiveMessageResult receiveMessageResult = new ReceiveMessageResult();
		receiveMessageResult.setMessages(messages);
		return receiveMessageResult;
	}

	public void processSendMessageRequest(SendMessageRequest sendMessageRequest) {
		InMemoryQueue inMemoryqueue = fetchQueue(sendMessageRequest.getQueueUrl());
		Message message = new Message().withBody(sendMessageRequest.getMessageBody());
		inMemoryqueue.addItem(message);
	}

}