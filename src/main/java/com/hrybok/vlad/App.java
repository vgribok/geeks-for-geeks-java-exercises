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

    static class SeriesWalker extends Thread {
        long[] histrogram;
        int boundIndex = -1;
        int seriesStartIndex;

        SeriesWalker(int seriesStartIndex, long[] histrogram) {
            this.histrogram = histrogram;
            this.seriesStartIndex = seriesStartIndex;
        }

        long getSeriesHeight() {
            return this.histrogram[this.seriesStartIndex];
        }
    }

    static class SeriesRightWalker extends SeriesWalker {
        SeriesRightWalker(int seriesStartIndex, long[] histrogram) {
            super(seriesStartIndex, histrogram);
        }

        @Override
        public void run() {

            long seriesHeight = this.getSeriesHeight();

            for(this.boundIndex = this.seriesStartIndex ; 
                this.boundIndex < this.histrogram.length-1 && seriesHeight <= histrogram[this.boundIndex+1] ; 
                this.boundIndex++)
            ;
        }
    }

    static class SeriesLeftWalker extends SeriesWalker {
        SeriesLeftWalker(int seriesStartIndex, long[] histrogram) {
            super(seriesStartIndex, histrogram);
        }

        @Override
        public void run() {

            long seriesHeight = this.getSeriesHeight();

            for(this.boundIndex = this.seriesStartIndex ; 
                this.boundIndex > 0 && this.histrogram[this.boundIndex-1] >= seriesHeight; 
                this.boundIndex--)
            ;
        }
    }

    static SeriesInfo getMaximumArea(long[] histrogram) {
        long maxArea = 0;

        SeriesInfo seriesInfo = new SeriesInfo();
        
        for(int seriesStart = 0 ; seriesStart < histrogram.length ; seriesStart++) {

            long seriesHeight = histrogram[seriesStart];

            SeriesLeftWalker leftWalker = new SeriesLeftWalker(seriesStart, histrogram);
            leftWalker.start();
            SeriesRightWalker rightWalker = new SeriesRightWalker(seriesStart, histrogram);
            rightWalker.start();

            try
            {
                leftWalker.join();
                rightWalker.join();
            }
            catch(InterruptedException ex) {
                // TODO: log exception
                return null;
            }

            int seriesWidth = rightWalker.boundIndex - leftWalker.boundIndex + 1;
            long seriesArea = seriesHeight * seriesWidth;

            if(seriesArea > maxArea) {
                maxArea = seriesArea;
                seriesInfo.seriesStartIndex = leftWalker.boundIndex;
                seriesInfo.seriesLength = seriesWidth;
                seriesInfo.seriesHeight = seriesHeight;
            }
        }

        return seriesInfo;
    }
}
