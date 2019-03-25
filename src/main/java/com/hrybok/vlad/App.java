package com.hrybok.vlad;

import java.util.Scanner;

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
                String moves = scanner.nextLine();

                boolean circular = isMovementCircular(moves);

                // do something 
                System.out.println(circular ? "Circular" : "Not Circular");
            }
        }
    }

    static class Direction {
        int x;
        int y;

        Direction(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean isMovementCircular(String moves) {
        char[] moveArray = moves.toUpperCase().toCharArray();

        Direction[] directions = new Direction[] {
            new Direction(1, 0),
            new Direction(0, 1),
            new Direction(-1, 0),
            new Direction(0, -1)
        };
        
        int direction = 0;
        int x = 0, y = 0;

        for(char move : moveArray) {
            switch(move) {
                case 'G':
                    int directionIndex = direction % 4;
                    if(directionIndex < 0) {
                        directionIndex = -directionIndex;
                    }
                    x += directions[directionIndex].x;
                    y += directions[directionIndex].y;
                    continue;
                case 'L':
                    direction++;
                    break;
                case 'R':
                    direction--;
                    break;
            }
        }

        return x == 0 && y == 0;
    }
}
