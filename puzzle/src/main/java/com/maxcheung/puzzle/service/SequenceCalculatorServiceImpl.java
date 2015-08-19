package com.maxcheung.puzzle.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

import org.apache.commons.lang3.Range;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.maxcheung.puzzle.util.RangeSplitter;
import com.maxcheung.puzzle.service.processor.SequenceCalculatorProcessor;

public class SequenceCalculatorServiceImpl implements SequenceCalculatorService {

	private static final Logger logger = LoggerFactory.getLogger(SequenceCalculatorServiceImpl.class);

	final ThreadPoolExecutor executor;
	final RangeSplitter rangeSplitter = new RangeSplitter();
	int nSegments;
	int nElementsN;
	int nPrecedingC;

	public SequenceCalculatorServiceImpl(ThreadPoolExecutor executor) {
		this.executor = executor;
	}

	public BigInteger calculateSequence(int nSegments, int nElements, int nPrecedingC) throws Exception {
		this.nSegments = nSegments;
		this.nElementsN = nElements;
		this.nPrecedingC = nPrecedingC;

		BigInteger total = BigInteger.ZERO;

		List<Future<BigInteger>> resultList = new ArrayList<>();
		List<Range<Integer>> splitList = rangeSplitter.splitRange(Range.between(1, nElementsN), nSegments);

		for (Range<Integer> range : splitList) {
			SequenceCalculatorProcessor calculator = new SequenceCalculatorProcessor(nPrecedingC, range.getMinimum(),
					range.getMaximum());
			Future<BigInteger> result = executor.submit(calculator);
			resultList.add(result);
		}

		for (Future<BigInteger> future : resultList) {
			try {
				logger.debug(
						"Future result is - " + " \n -> " + future.get() + "; And Task done is " + future.isDone());

				total = total.add(future.get());

			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}

		return total;
	}

	public void shutdown() throws Exception {
		// shut down the executor service now
		executor.shutdown();
	}
}