package com.example.QueueRepository.InMemory;

import java.util.LinkedList;
import java.util.Queue;

import com.amazonaws.services.sqs.model.Message;
import com.example.QueueRepository.Entity;

public class InMemoryQueue extends Entity  {

	private String name;

	private Queue<Message> messages = new LinkedList<Message>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addItem(Message message) {
		this.messages.add(message);
	}

	public void removeItem(Message message) {
		this.messages.add(message);
	}

	public Queue<Message> getMessages() {
		return messages;
	}

	public Message peek() {
		return this.messages.peek();
	}

	public Message remove() {
		return this.messages.remove();
	}

}