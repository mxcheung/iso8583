package com.example.QueueRepository.InMemory;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import com.example.QueueRepository.QueueRepository;

public class InMemoryQueueRepository implements QueueRepository {


    private Map<String, InMemoryQueue> queues = new HashMap<String, InMemoryQueue>();

    public void save(String queueName, InMemoryQueue queue) {
        if (queue.isNew()) {
            queue.setName(queueName);
            queues.put(queue.getName(), queue);
        }
    }

    public Collection<InMemoryQueue> findAll() {
        return queues.values();
    }

    public InMemoryQueue find(String queueName) throws NoSuchElementException {
        if (!exists(queueName)) throw new NoSuchElementException("No queue with name " + queueName);
        return queues.get(queueName);
    }

    private boolean exists(String queueName) {
        return queues.containsKey(queueName);
    }

}