package com.maxcheung.config;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.maxcheung.puzzle.service.SequenceCalculatorService;
import com.maxcheung.puzzle.service.SequenceCalculatorServiceImpl;

@Configuration
public class AppConfig {

    private static final int CORES = Runtime.getRuntime().availableProcessors();

    @Bean(name = "sequenceCalculatorService")
    public SequenceCalculatorService sequenceCalculatorService() {
        return new SequenceCalculatorServiceImpl(threadPoolExecutor());
    }

    public ThreadPoolExecutor threadPoolExecutor() {
        return (ThreadPoolExecutor) Executors.newFixedThreadPool(CORES);
    }

}