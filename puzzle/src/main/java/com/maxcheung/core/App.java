package com.maxcheung.core;

import java.math.BigInteger;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.maxcheung.config.AppConfig;
import com.maxcheung.puzzle.service.SequenceCalculatorService;

public class App {
	private static ApplicationContext context;
	private static final int cores = Runtime.getRuntime().availableProcessors();
	final static int ONE_MIL = 1_000_000;
	final static int TEN_MIL = 10_000_000;

	private static final Logger logger = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		context = new AnnotationConfigApplicationContext(AppConfig.class);
		SequenceCalculatorService sequenceCalculatorService = (SequenceCalculatorService) context.getBean("sequenceCalculatorService");
		try {
			calcSequence(sequenceCalculatorService,cores, 5, 2);
			calcSequence(sequenceCalculatorService,cores, 100, 10);
			calcSequence(sequenceCalculatorService,cores, ONE_MIL, 200);
			calcSequence(sequenceCalculatorService,cores, TEN_MIL, 200);
			sequenceCalculatorService.shutdown();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void calcSequence(SequenceCalculatorService sequenceCalculatorService, int nSegments, int nElements, int nPrecedingC) throws Exception {
		long lStartTime = new Date().getTime();
		BigInteger total = sequenceCalculatorService.calculateSequence(nSegments, nElements, nPrecedingC);
		long lEndTime = new Date().getTime();
		long difference = lEndTime - lStartTime;
		logger.info("\nN:" + nElements + ", C:" + nPrecedingC + ",\nTotal : " + total + "\nElapsed milliseconds: " + difference );
//		logger.info("Elapsed milliseconds: " + difference);
		logger.info("\n***************************************************************");
	}
}