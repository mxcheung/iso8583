package com.maxcheung.puzzle.service;

import java.math.BigInteger;
import java.util.concurrent.ExecutionException;

public interface SequenceCalculatorService {

    public BigInteger calculateSequence(int nSegments, int nElements, int nPrecedingC) throws ExecutionException;

    public void shutdown();

}