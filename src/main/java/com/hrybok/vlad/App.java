package com.hrybok.vlad;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

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
                final int matrixSize = Integer.parseInt(scanner.nextLine());
                int[] array = ReadArray(scanner.nextLine());
                rotateInPlaceClockwise(array, matrixSize);
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

    static void rotateInPlaceClockwise(int[] array, int matrixSize) {
        int layerCount = matrixSize/2 + matrixSize % 1;
        for(int layer = 0, layerSize = matrixSize ; layerSize > 1 && layer < layerCount ; layer++, layerSize -= 2) {
            int layerStartIndex = matrixSize * layer + layer;
            rotateLayerInPlaceClockwise(array, layerStartIndex, layerSize, matrixSize);
        }
    }

    /**
     * Layers indexes go from 0 - the outermost, incrementing towards the center of the matrix
     */
    private static void rotateLayerInPlaceClockwise(int[] array, int startIndex, int layerSize, int matrixSize) {
        for(int index = startIndex, limit = startIndex + layerSize - 1; index < limit ; index++) {
            for(int nextIndex, i = 0, sourceIndex = index ; i < 3 ; i++, sourceIndex = nextIndex)
            {
                nextIndex = getDestIndexForCounterRotation(sourceIndex, matrixSize);
                swapArrayElemsInPlace(array, sourceIndex, nextIndex);
            }
        }
    }

    static void swapArrayElemsInPlace(int[] array, int a, int b) {
        array[b] = array[a] + array[b];
        array[a] = array[b] - array[a];
        array[b] = array[b] - array[a];
    }

    static int getDestIndexForCounterRotation(int sourceIndex, int matrixSize) {
        int destGroupIndex = sourceIndex / matrixSize;
        int indexInSourceGroup = sourceIndex % matrixSize;
        int destGroup = matrixSize - indexInSourceGroup - 1;
        int destIndex = destGroup * matrixSize + destGroupIndex;
        return destIndex;
    }

    static int getDestIndexForClockwiseRotation(int index, int matrixSize) {
        for(int i = 0 ; i < 3 ; i++) {
            index = getDestIndexForCounterRotation(index, matrixSize);
        }
        return index;
    }
}
