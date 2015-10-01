package com.maxcheung.core;

import java.math.BigInteger;
import java.util.Date;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.maxcheung.config.AppConfig;
import com.maxcheung.puzzle.service.SequenceCalculatorService;

public class App {
    private static ApplicationContext context;
    private static final int CORES = Runtime.getRuntime().availableProcessors();
    private static final int ONE_MIL = 1_000_000;
    private static final int TEN_MIL = 10_000_000;

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    private App() {
    }

    public static void main(String[] args) throws ExecutionException {
        context = new AnnotationConfigApplicationContext(AppConfig.class);
        SequenceCalculatorService sequenceCalculatorService = (SequenceCalculatorService) context
                .getBean("sequenceCalculatorService");
        calcSequence(sequenceCalculatorService, CORES, 5, 2);
        calcSequence(sequenceCalculatorService, CORES, 100, 10);
        calcSequence(sequenceCalculatorService, CORES, ONE_MIL, 200);
        calcSequence(sequenceCalculatorService, CORES, TEN_MIL, 200);
        sequenceCalculatorService.shutdown();
    }

    private static void calcSequence(SequenceCalculatorService sequenceCalculatorService, int nSegments, int nElements,
            int nPrecedingC) throws ExecutionException {
        long lStartTime = new Date().getTime();
        BigInteger total = sequenceCalculatorService.calculateSequence(nSegments, nElements, nPrecedingC);
        long lEndTime = new Date().getTime();
        long difference = lEndTime - lStartTime;
        LOGGER.info("\nN:" + nElements + ", C:" + nPrecedingC + ",\nTotal : " + total + "\nElapsed milliseconds: "
                + difference);
        LOGGER.info("\n***************************************************************");
    }
}