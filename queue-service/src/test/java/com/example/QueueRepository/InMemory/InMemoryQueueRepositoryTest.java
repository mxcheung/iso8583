package com.example.QueueRepository.InMemory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import com.example.QueueRepository.InMemory.InMemoryQueue;
import com.example.QueueRepository.InMemory.InMemoryQueueRepository;

public class InMemoryQueueRepositoryTest {

	InMemoryQueueRepository inMemoryQueueRepository;

	@Before
	public void setUp() {
		inMemoryQueueRepository = new InMemoryQueueRepository();
	}

	@Test
	public void shouldSaveQueue() {
		String queueName = "testqueue";
		InMemoryQueue queue = new InMemoryQueue();
		queue.setName(queueName);
		inMemoryQueueRepository.save(queueName, queue);
		Collection<InMemoryQueue> queues = inMemoryQueueRepository.findAll();
		int expectedSize = 1;
		assertEquals(expectedSize, queues.size());
	}

	@Test
	public void shouldFindQueue() {
		String queueName = "testqueue";
		InMemoryQueue queue = new InMemoryQueue();
		queue.setName(queueName);
		inMemoryQueueRepository.save(queueName, queue);
		InMemoryQueue savedqueue = inMemoryQueueRepository.find(queueName);
		assertNotNull(savedqueue);
	}

	@Test(expected = NoSuchElementException.class)
	public void shouldThrowNoSuchElementException() {
		String queueName = "unknownqueue";
		inMemoryQueueRepository.find(queueName);
		fail("Exception not thrown");
	}


	@Test
	public void shouldAddItemsToRepository() {
		String queueName1 = "testqueue1";
		String queueName2 = "testqueue2";
		List<String> queueList = new ArrayList<String>();
		queueList.add(queueName1);
		queueList.add(queueName2);
		
		for (String queueName : queueList)
		{
			InMemoryQueue queue = new InMemoryQueue();
			queue.setName(queueName);
			inMemoryQueueRepository.save(queueName, queue);
		}
		
//		Message message1 = new Message();
//		message1.setMessageBody("Msg1"); 
//
//		Message message2 = new Message();
//		message1.setMessageBody("Msg2");
		
//		List<SendMessageRequest> requests = new ArrayList<SendMessageRequest>();
//		SendMessageRequest sendMessageRequest1 = new  SendMessageRequest();
//		sendMessageRequest1.setQueueName(queueName1);
//		sendMessageRequest1.setMessage(message1);
//		SendMessageRequest sendMessageRequest2 = new  SendMessageRequest();
//		sendMessageRequest2.setQueueName(queueName2);
//		sendMessageRequest2.setMessage(message2);
//		requests.add(sendMessageRequest1);
//		requests.add(sendMessageRequest2);
//
//	
//	
//		for (PushMessageRequest request : requests)
//		{
//			InMemoryQueue queue = inMemoryQueueRepository.find(request.getQueueName());
//			queue.addItem(request.getMessage());
//		}
//
//
//		Message msg = inMemoryQueueRepository.find(queueName1).peek();
//		assertEquals(message1, msg);

	}



}
