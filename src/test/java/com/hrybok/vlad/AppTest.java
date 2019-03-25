package com.hrybok.vlad;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void testReverseBits() {
        assertEquals(2684354560l, App.reverseBits(5));
        assertEquals(2147483648l, App.reverseBits(1));
    }
}
