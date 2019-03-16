package com.hrybok.vlad;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test.
     */
    @Test
    public void testArrayElemSwap() {
        int[] array = { 75, 0, 12 };
        App.swapArrayElemsInPlace(array, 0, 2);
        int[] expected = { 12, 0, 75 };
        assertArrayEquals(expected, array);
    }

    @Test
    public void testNextCounterClockwiseIndex() {
        final int[][] testCases = {
            // martix size, sourceIndex, destinationIndex
            {2, 0, 1},
            {2, 1, 2},
            {2, 2, 3},
            {2, 3, 0}
        };
        for(int testCaseIndex = 0 ; testCaseIndex < testCases.length ; testCaseIndex++) {
            int[] testCase = testCases[testCaseIndex];
            int matrixSize = testCase[0];
            int sourceIndex = testCase[1];
            int actualNextIndex = App.getDestIndexForClockwiseRotation(sourceIndex, matrixSize);
            int expectedNextIndex = testCase[2];
            assertEquals(expectedNextIndex, actualNextIndex);
        }
    }
}
