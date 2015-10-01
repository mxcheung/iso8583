package com.maxcheung.puzzle.math;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class SequenceCalcNextElementParameterizedTest {
    SequenceCalc sequenceCalc = new SequenceCalc();

    private int nthPosition;
    private String nthElementValue;
    private int precedingElementsC;
    private String expected;

    /*
     * parameters pass via this constructor
     * 
     * nthPosition - Postion N in array
     * 
     * nthElementValue - Product of C preceding elements
     * 
     * expected - Next Value in product
     */
    public SequenceCalcNextElementParameterizedTest(int nthPosition, int precedingElementsC, String nthElementValue,
            String expected) {
        this.nthPosition = nthPosition;
        this.nthElementValue = nthElementValue;
        this.precedingElementsC = precedingElementsC;
        this.expected = expected;
    }

    // Declares parameters here
    @Parameters(name = "{index}: sequenceCalc.NextElement({0},{1})={2}")
    public static Iterable<Object[]> data1() {
        return Arrays.asList(new Object[][] { { 1, 2, "0", "1" }, { 2, 2, "1", "2" }, { 3, 2, "2", "6" },
                { 4, 2, "6", "12" }, { 5, 2, "12", "20" }, { 6, 2, "20", "30" },
                { 99, 10, "50823572136746572800", "56534085859976524800" },
                { 100, 10, "56534085859976524800", "62815650955529472000" }, });
    }

    @Test
    public void shouldCalculatePrecedingSum() {
        assertEquals(new BigInteger(expected),
                sequenceCalc.nextElement(new BigInteger(nthElementValue), nthPosition, precedingElementsC));
    }

}
