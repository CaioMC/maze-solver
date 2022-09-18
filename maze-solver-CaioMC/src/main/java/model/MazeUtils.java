package main.java.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Optional;
import java.util.Stack;
import java.util.stream.Collectors;

public class MazeUtils {

    private static final String MAZE_PATH = "src/main/resources/maze.txt";

    public static Point[][] loadMaze()  {
        BufferedReader fileReader = readTextFile();
        List<String> lines = fileReader.lines().collect(Collectors.toList());

        int MSIZE = Integer.parseInt(lines.get(0));
        Point[][] points = new Point[MSIZE][MSIZE];

        lines.remove(0);
        for (int i = 0; i < MSIZE; i++) {
            String line = lines.get(i);
            for (int j = 0; j < MSIZE; j++) {
                Point point = new Point();
                point.setValue(Integer.parseInt(String.valueOf(line.charAt(j))));
                point.setRow(i);
                point.setColumn(j);
                point.setMSIZE(MSIZE);

                points[i][j] = point;
            }
        }

        return points;
    }

    public static BufferedReader readTextFile() {
        try {
            InputStream file = new FileInputStream(new File(MAZE_PATH));

            Reader isr = new InputStreamReader(file);
            BufferedReader br = new BufferedReader(isr);
            return br;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
