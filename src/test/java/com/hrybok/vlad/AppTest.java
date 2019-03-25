package com.hrybok.vlad;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest {

    static class TestCase {
        boolean expectedCircular;
        String moves;

        TestCase(boolean expected, String moves) {
            this.expectedCircular = expected;
            this.moves = moves;
        }
    }

    @Test
    public void testCircular() {
        TestCase[] testCases = new TestCase[] {
            new TestCase(true, "GLGLGLG"),
            new TestCase(true, "GLLG"),
            new TestCase(true, "GRGRGRG"),
            new TestCase(true, "GRRG"),
            new TestCase(false, "GGGGL"),
            new TestCase(false, "GLRGRLGGLR"),
            new TestCase(false, "RGGGGRRGGRGRGGRRRRRGRGGRRRGGGGRRRGGGRGRGGGGRGRRGRGRGRRGRRRGGGRGRGRGGGRGRGRGRRGRGRRRR"),
            new TestCase(true, "GLRLGLRGLRLGRLGLRLGRLGLRLGRLGLRGLRLGLRGLRLGRLGLRLGRLG")
        };
        for(TestCase testCase : testCases) {
            boolean actual = App.isMovementCircular(testCase.moves);
            assertEquals(testCase.expectedCircular, actual);
        }
    }
}
