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
            {2, 0, 2},
            {2, 2, 3},
            {2, 3, 1},
            {2, 1, 0}
        };
        for(int testCaseIndex = 0 ; testCaseIndex < testCases.length ; testCaseIndex++) {
            int[] testCase = testCases[testCaseIndex];
            int matrixSize = testCase[0];
            int sourceIndex = testCase[1];
            int actualNextIndex = App.getDestIndexForCounterRotation(sourceIndex, matrixSize);
            int expectedNextIndex = testCase[2];
            assertEquals(expectedNextIndex, actualNextIndex);
        }
    }

    
    @Test
    public void testNextClockwiseIndex() {
        final int[][] testCases = {
            // martix size, sourceIndex, destinationIndex
            {3, 4, 4},
            {3, 0, 2},
            {3, 7, 3 },
            {3, 1, 5},
            {3, 5, 7},
            {4, 8, 1},
            {4, 5, 6},
            {4, 10, 9}
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

    @Test
    public void testRotate2x2Clockwise() {
        int[] source = { 1, 2, 3, 4 };
        int[] expected = { 3, 1, 4, 2 };

        App.rotateInPlace(source, 2, true);
        assertArrayEquals(expected, source);
    }

    @Test
    public void testRotate3x3Clockwise() {
        int[] source = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int[] expected = { 7, 4, 1, 8, 5, 2, 9, 6, 3 };

        App.rotateInPlace(source, 3, true);
        assertArrayEquals(expected, source);
    }


    @Test
    public void testRotate4x4Clockwise() {
        int[] source = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
        int[] expected = { 13, 9, 5, 1, 14, 10, 6, 2, 15, 11, 7, 3, 16, 12, 8, 4 };

        App.rotateInPlace(source, 4, true);
        assertArrayEquals(expected, source);
    }
}
