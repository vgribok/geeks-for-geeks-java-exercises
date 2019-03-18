package com.hrybok.vlad;

import java.util.Arrays;
import java.util.Scanner;

/**
 * See  branches for specific GFG task solutions.
 * This is just a starting point for tasks.
 */
public final class App {
    private App() {
    }

    static class SeriesInfo {
        int seriesStartIndex = -1;
        int seriesLength = -1;
        long seriesHeight = 0;

        long getArea() {
            return seriesHeight * seriesLength;
        }
    }

    /**
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in))
        {
            final int testCaseCount = Integer.parseInt(scanner.nextLine());
            for(int i = 0 ; i < testCaseCount ; i++) {
                scanner.nextLine(); // Array size will be determined dynamcally
                long[] array = ReadArray(scanner.nextLine());
                SeriesInfo maxAreaSeries = getMaximumArea(array);
                System.out.println(Long.toString(maxAreaSeries.getArea()));
            }
        }
    }

    private static long[] ReadArray(String arrayString) {
        final String[] arrayNumbers = arrayString.split(" ");
        final long[] nums = Arrays.stream(arrayNumbers)
                                    .map(stringNumber -> Long.parseLong(stringNumber))
                                    .mapToLong(i -> i)
                                    .toArray();
        return nums;
    }

    static SeriesInfo getMaximumArea(long[] histrogram) {
        long maxArea = 0;

        SeriesInfo seriesInfo = new SeriesInfo();
        
        for(int seriesStart = 0 ; seriesStart < histrogram.length ; seriesStart++) {

            long seriesHeight = histrogram[seriesStart];

            int seriesLeft = 0;
            int seriesRight = 0;
            // Walk left
            for(seriesLeft = seriesStart ; 
                seriesLeft > 0 && histrogram[seriesLeft-1] >= seriesHeight; 
                seriesLeft--)
            ;

            // Walk right
            for(seriesRight = seriesStart ; 
                seriesRight < histrogram.length-1 && seriesHeight <= histrogram[seriesRight+1] ; 
                seriesRight++)
            ;

            int seriesWidth = seriesRight - seriesLeft + 1;
            long seriesArea = seriesHeight * seriesWidth;

            if(seriesArea > maxArea) {
                maxArea = seriesArea;
                seriesInfo.seriesStartIndex = seriesLeft;
                seriesInfo.seriesLength = seriesWidth;
                seriesInfo.seriesHeight = seriesHeight;
            }
        }

        return seriesInfo;
    }
}
