package com.hrybok.vlad;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * See  branches for specific GFG task solutions.
 * This is just a starting point for tasks.
 */
public final class App {
    private App() {
    }

    /**
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in))
        {
            final int testCaseCount = Integer.parseInt(scanner.nextLine());
            for(int i = 0 ; i < testCaseCount ; i++) {
                //final int size = Integer.parseInt(scanner.nextLine());
                int[] array = ReadArray(scanner.nextLine());
                // do something 
                System.out.println(formatOutput(array));
            }
        }
    }

    private static int[] ReadArray(String arrayString) {
        final String[] arrayNumbers = arrayString.split(" ");
        final int[] nums = Arrays.stream(arrayNumbers)
                                    .map(stringNumber -> Integer.parseInt(stringNumber))
                                    .mapToInt(i -> i)
                                    .toArray();
        return nums;
    }

    private static String formatOutput(int[] array) {
        return Arrays.stream(array)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" "));
    }
}
