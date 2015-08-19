package com.maxcheung.puzzle.service.processor;

import java.math.BigInteger;
import java.util.concurrent.Callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.maxcheung.puzzle.math.SequenceCalc;

public class SequenceCalculatorProcessor implements Callable<BigInteger> {

	private static final Logger logger = LoggerFactory.getLogger(SequenceCalculatorProcessor.class);

	private final int c;
	private final int start;
	private final int end;
	final SequenceCalc sequenceCalc = new SequenceCalc();

	public SequenceCalculatorProcessor(int c, int start, int end) {
		this.c = c;
		this.start = Math.max(start - 1, 1);
		this.end = end;
	}

	@Override
	public BigInteger call() throws Exception {
		BigInteger result = sequenceCalc.sumNthElementSegment(c, start, end);
		logger.debug(Thread.currentThread().getName() + "Result for number - " + c + "," + start + "," + end + " \n -> "
				+ result);
		return result;
	}
}