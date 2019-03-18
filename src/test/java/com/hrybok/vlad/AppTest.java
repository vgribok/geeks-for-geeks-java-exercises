package com.hrybok.vlad;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest {

    static class TestCase {
        long expectedArea;
        long[] histrogram;

        TestCase(long expectedArea, long[] histrogram) {
            this.expectedArea = expectedArea;
            this.histrogram = histrogram;
        }
    }

    @Test
    public void doSomething() {
        TestCase[] testCases = {
            new TestCase(12, new long[] { 6, 2, 5, 4, 5, 1, 6 }),
            new TestCase(0, new long[] { }),
            new TestCase(0, new long[] { 0 }),
            new TestCase(123, new long[] { 123 }),
            new TestCase(250, new long[] { 124, 0, 125, 126 }),
            new TestCase(10, new long[] { 6, 2, 5, 3, 5, 1, 6 }),
            new TestCase(7, new long[] { 6, 2, 5, 1, 5, 1, 6 }),
        };

        for (TestCase testCase : testCases) {
            App.SeriesInfo maxSeries = App.getMaximumArea(testCase.histrogram);
            assertEquals(testCase.expectedArea, maxSeries.getArea());
        }
    }
}
