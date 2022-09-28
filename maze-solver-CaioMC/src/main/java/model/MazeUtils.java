package main.java.model;

import java.util.Optional;
import java.util.Scanner;
import java.util.Stack;

public class MazeUtils {

    public static Point[][] loadMaze()  {
        int[][] maze = readTextFile();

        int MSIZE = maze[0].length;
        Point[][] points = new Point[MSIZE][MSIZE];

        for (int i = 0; i < MSIZE; i++) {
            for (int j = 0; j < MSIZE; j++) {
                int number = maze[i][j];
                Point point = new Point();
                point.setValue(number);
                point.setRow(i);
                point.setColumn(j);
                point.setMSIZE(MSIZE);

                points[i][j] = point;
            }
        }

        return points;
    }

    private static int[][] readTextFile() {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[][] tiles = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tiles[i][j] = in.nextInt();
            }
        }
        return tiles;
    }

    public static void printSolver(Stack<Point> pointStack) {
        int MSIZE = pointStack.stream().findFirst().get().getMSIZE();

        for (int i = 0; i < MSIZE; i++) {
            System.out.println("");
            for (int j = 0; j < MSIZE; j++) {
                int finalI = i;
                int finalJ = j;

                Optional<Point> value = pointStack.stream().filter(
                    point -> (point.getRow() == finalI && point.getColumn() == finalJ)
                ).findFirst();

                System.out.print(value.isPresent() ?
                    value.get().getValue() == 0 ? " S ": " " + value.get().getValue() + " " : " - ");
            }
        }
        System.out.println("");
    }

}
