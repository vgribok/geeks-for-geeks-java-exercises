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
            new TestCase(4000, new long[] { 
                793, 476, 526, 815, 448, 317, 763, 896, 458, 260, 235, 210, 154, 696,
                367, 519, 970, 726, 382, 148, 774, 461, 312, 49, 148, 233, 40, 121, 253, 674, 628, 934, 315, 471, 577, 902, 274,
                417, 134, 994, 950, 541, 795, 119, 182, 406, 763, 92, 818, 397, 743, 252, 370, 867, 629, 131, 105, 800, 424, 250,
                64, 523, 997, 234, 349, 746, 362, 985, 956, 55, 835, 987, 954, 415, 609, 70, 968, 226, 460, 310, 987, 208, 192,
                418, 645, 945, 491, 385, 227, 899, 600, 47, 282, 226, 828, 655, 336, 713, 761, 752 }),
            new TestCase(3888, new long[] {
                93, 425, 854, 287, 408, 48, 269, 700, 324, 868, 946, 979, 358, 737, 505, 725, 555, 562, 451, 202, 
                75, 936, 779, 771, 418, 685, 329, 229, 157, 659, 152, 262, 510, 547, 929, 461, 898, 984, 415, 119, 
                788, 377, 198, 944, 899, 813, 259, 818, 534, 58, 503, 437, 554, 74, 670, 221, 13, 950, 589, 702, 
                90, 887, 841, 138, 658, 494, 40, 778, 658, 199, 656, 403, 155, 734, 812, 148, 192, 832, 923, 586, 
                61, 288, 797, 977, 309, 197, 788, 529, 297, 392, 718, 614, 336, 728, 877, 320, 9, 786, 201, 237
            })
        };

        for (TestCase testCase : testCases) {
            App.SeriesInfo maxSeries = App.getMaximumArea(testCase.histrogram);
            assertEquals(testCase.expectedArea, maxSeries.getArea());
        }
    }
}
