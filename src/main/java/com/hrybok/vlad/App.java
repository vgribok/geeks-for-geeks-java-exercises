package com.hrybok.vlad;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in))
        {
            final int testCaseCount = Integer.parseInt(scanner.nextLine());
            for(int i = 0 ; i < testCaseCount ; i++) {
                final int matrixSize = Integer.parseInt(scanner.nextLine());
                int[] array = ReadArray(scanner.nextLine());
                array = rotateClockwise(array, matrixSize);
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

    private static int[] rotateCounter(int[] array, int matrixSize) {

        final int[] dest = new int[array.length];

        for(int i = 0 ; i < array.length ; i++) {
            
            final int destIndex = getDestIndexForCounterRotation(i, matrixSize);
            dest[destIndex] = array[i];
        }

        return dest;
    }

    private static int[] rotateClockwise(int[] array, int matrixSize) {
        for(int i = 1 ; i <= 3 ; i++) {
            array = rotateCounter(array, matrixSize);
        }
        return array;
    }

    private static int getDestIndexForCounterRotation(int sourceIndex, int matrixSize) {
        int destGroupIndex = sourceIndex / matrixSize;
        int indexInSourceGroup = sourceIndex % matrixSize;
        int destGroup = matrixSize - indexInSourceGroup - 1;
        int destIndex = destGroup * matrixSize + destGroupIndex;
        return destIndex;
    }
}
