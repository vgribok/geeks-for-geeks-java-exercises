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
		try(Scanner scanner = new Scanner(System.in)) {
		    int testCaseCount = Integer.parseInt(scanner.nextLine());
		    for(int i = 0 ; i < testCaseCount ; i++) {
		        long number = Long.parseLong(scanner.nextLine());
		        long reversedBits = reverseBits(number);
		        System.out.println(reversedBits);
		    }
		}
	}
	
	static long reverseBits(long num) {
	    
	    long reversed = 0;
	    
	    final int lastBitMask = 1;
	    for(int i = 0 ; i < 32 ; i++) {
	        long lastBit = num & lastBitMask;
	        long movedBit = lastBit << (31 - i);
	        reversed |= movedBit;
	        num >>= 1;
	    }
	    
	    return reversed;
	}
}
