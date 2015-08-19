package com.maxcheung.puzzle.service;

import java.math.BigInteger;

public interface SequenceCalculatorService {

	public BigInteger calculateSequence(int nSegments, int nElements, int nPrecedingC) throws Exception;
	public void shutdown() throws Exception ;

}