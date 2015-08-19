package com.example;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.amazonaws.services.sqs.model.DeleteMessageRequest;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.example.QueueRepository.QueueRepository;
import com.example.QueueRepository.InMemory.InMemoryQueueRepository;

public class QueueServiceTest {
	//
	// Implement me.
	//

	private QueueService inMemoryQueueService;
	private QueueRepository queueRepository;
	private String queueName = "testQueue";
	private String testMsg = "This is my message text.";

	@Before
	public void setup() {
		queueRepository = new InMemoryQueueRepository();
		inMemoryQueueService = new InMemoryQueueService(queueRepository);
	}

	@Test
	public void shouldPush() {
		String expectMsgBody = "This is my message text.";
		int expectedMsgCount = 1;
		sendMessage(queueName, testMsg);
		ReceiveMessageResult receiveMessageResult = receiveMessage(queueName);
		Message message = getMessage(receiveMessageResult);
		assertEquals(expectedMsgCount, receiveMessageResult.getMessages().size());
		assertEquals(expectMsgBody, message.getBody());
	}

	@Test
	public void shouldPull() {
		int expectedMsgCount = 1;
		String expectMsgBody = "This is my message text.";
		sendMessage(queueName, testMsg);
		ReceiveMessageResult receiveMessageResult = receiveMessage(queueName);
		Message message = getMessage(receiveMessageResult);
		assertEquals(expectedMsgCount, receiveMessageResult.getMessages().size());
		assertEquals(expectMsgBody, message.getBody());
	}

	@Test
	public void shouldDelete() {

		int expectedMsgCount = 0;
		sendMessage(queueName, testMsg);
		ReceiveMessageResult receiveMessageResult = receiveMessage(queueName);
		Message message = getMessage(receiveMessageResult);
		deleteMessage(message);
		receiveMessageResult = receiveMessage(queueName);
		assertEquals(expectedMsgCount, receiveMessageResult.getMessages().size());
	}

	private Message getMessage(ReceiveMessageResult receiveMessageResult) {
		Message message = null;
		List<Message> messages = receiveMessageResult.getMessages();
		if (messages.size() > 0) {
			message = messages.get(0);
		}
		return message;
	}

	private void deleteMessage(Message message) {
		DeleteMessageRequest deleteMessageRequest = new DeleteMessageRequest();
		deleteMessageRequest.setQueueUrl(queueName);
		deleteMessageRequest.setReceiptHandle(message.getReceiptHandle());
		inMemoryQueueService.delete(deleteMessageRequest);
	}

	private void sendMessage(String queueName, String message) {
		SendMessageRequest sendMessageRequest = new SendMessageRequest(queueName, message);
		inMemoryQueueService.push(sendMessageRequest);
	}

	private ReceiveMessageResult receiveMessage(String queueName) {
		Integer visibilityTimeout = 120;
		ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest();
		receiveMessageRequest.setQueueUrl(queueName);
		receiveMessageRequest.setVisibilityTimeout(visibilityTimeout);
		ReceiveMessageResult receiveMessageResult = inMemoryQueueService.pull(receiveMessageRequest);
		return receiveMessageResult;
	}

}
