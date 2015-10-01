package com.maxcheung.puzzle.math;

import java.math.BigInteger;

public class SequenceCalc {

    /*
     * Return the Nth Element = Product ( n - 1 .. n - c )
     */
    public BigInteger nthElement(int n, int c) {

        BigInteger product;
        if (n == 1) {
            product = BigInteger.ZERO;
        } else {
            product = BigInteger.ONE;
            for (int i = n - 1; i >= Math.max(n - c, 1); i--) {
                product = product.multiply(BigInteger.valueOf(i));
            }
        }
        return product;
    }

    public BigInteger nextElement(BigInteger currElement, int n, int c) {

        BigInteger nextElement;
        int prevPos = Math.max(n - c, 1);
        if (n == 1) {
            nextElement = BigInteger.ONE;
        } else {
            nextElement = currElement.multiply(BigInteger.valueOf(n));
            nextElement = nextElement.divide(BigInteger.valueOf(prevPos));
        }
        return nextElement;
    }

    public BigInteger sumNthElement(int n, int c) {
        return sumNthElementSegment(c, 1, n);
    }

    public BigInteger sumNthElementSegment(int c, int start, int end) {

        BigInteger total = BigInteger.ZERO;
        BigInteger currElement = nthElement(start, c);
        for (int i = start; i < end; i++) {
            currElement = nextElement(currElement, i, c);
            total = total.add(currElement);
        }
        return total;
    }

}
