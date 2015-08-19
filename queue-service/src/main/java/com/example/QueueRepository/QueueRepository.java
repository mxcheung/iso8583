package com.example.QueueRepository;


import java.util.Collection;
import java.util.NoSuchElementException;

import com.example.QueueRepository.InMemory.InMemoryQueue;

public interface QueueRepository {

    void save(String queueName, InMemoryQueue queue);

    Collection<InMemoryQueue> findAll();

    InMemoryQueue find(String queueName) throws NoSuchElementException;
}