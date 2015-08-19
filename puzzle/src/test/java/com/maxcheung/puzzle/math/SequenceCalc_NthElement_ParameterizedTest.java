package com.maxcheung.puzzle.math;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class SequenceCalc_NthElement_ParameterizedTest {
	SequenceCalc sequenceCalc = new SequenceCalc();

	private int totalElementsN;
	private int precedingElementsC;
	private String expected;

	// parameters pass via this constructor
	public SequenceCalc_NthElement_ParameterizedTest(int totalElementsN, int precedingElementsC, String expected) {
		this.totalElementsN = totalElementsN;
		this.precedingElementsC = precedingElementsC;
		this.expected = expected;
	}

	// Declares parameters here
	@Parameters(name = "{index}: sequenceCalc.nthElement({0},{1})={2}")
	public static Iterable<Object[]> data1() {
		return Arrays.asList(new Object[][] { { 1, 2, "0" }, { 2, 2, "1" }, { 3, 2, "2" }, { 4, 2, "6" },
				{ 5, 2, "12" }, { 100, 10, "56534085859976524800" } });
	}

	@Test
	public void shouldCalculateNthElement() {
		assertEquals(new BigInteger(expected), sequenceCalc.nthElement(totalElementsN, precedingElementsC));
	}

	
}
