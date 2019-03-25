package com.hrybok.vlad;

import java.util.Scanner;

/**
 * See  branches for specific GFG task solutions.
 * GFG https://practice.geeksforgeeks.org/problems/reverse-bits/0
 */
public final class App {
    private App() {
    }

    /**
     * @param args The arguments of the program.
     */
	public static void main (String[] args) {
		try(final Scanner scanner = new Scanner(System.in)) {
		    final int testCaseCount = Integer.parseInt(scanner.nextLine());
		    for(int i = 0 ; i < testCaseCount ; i++) {
		        final long number = Long.parseLong(scanner.nextLine());
		        final long reversedBits = reverseBits(number);
		        System.out.println(reversedBits);
		    }
		}
	}
	
	static long reverseBits(long num) {
	    long reversed = 0;
	    
	    for(int i = 0 ; i < 32 ; i++) {
	        final long lastBit = num & 1;
	        final long movedBit = lastBit << (31 - i);
	        reversed |= movedBit;
	        num >>= 1;
	    }
	    
	    return reversed;
	}
}
