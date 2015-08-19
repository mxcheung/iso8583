package com.maxcheung.config;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.maxcheung.puzzle.service.SequenceCalculatorService;
import com.maxcheung.puzzle.service.SequenceCalculatorServiceImpl;


@Configuration
public class AppConfig {

	private static final int cores = Runtime.getRuntime().availableProcessors();

	@Bean(name = "sequenceCalculatorService")
	public SequenceCalculatorService sequenceCalculatorService() {
		SequenceCalculatorService sequenceCalculatorService = new SequenceCalculatorServiceImpl(threadPoolExecutor());
		return sequenceCalculatorService;
	}

	public ThreadPoolExecutor threadPoolExecutor() {
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(cores);
		return executor;
	}

}