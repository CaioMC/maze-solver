package main.java;

import main.java.model.MazeUtils;
import main.java.model.NeighborUtils;
import main.java.model.Point;

import java.io.IOException;
import java.util.Stack;

import static java.util.Objects.nonNull;

public class Solver {

    public static void main(String[] args) {
        try {
            Stack<Point> pointStack = solver();

            if (!pointStack.isEmpty()) {
                MazeUtils.printSolver(pointStack);
            } else {
                System.out.println("Não é possível resolver o labirinto.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Stack<Point> solver() throws IOException {
        Point[][] maze = MazeUtils.loadMaze();

        Stack<Point> pointStack = new Stack<>();
        pointStack.push(maze[0][0]);

        Point current = pointStack.peek();

        while (!pointStack.isEmpty()) {
            current.isCurrent(true);
            current.setVisited(true);

            Point unvisitedNeighbor = NeighborUtils.unvisitedNeighbor(current, maze);

            if (nonNull(unvisitedNeighbor)) {
                unvisitedNeighbor.setVisited(true);
                current = unvisitedNeighbor;

                if (unvisitedNeighbor.getValue() == 2) {
                    Point start = unvisitedNeighbor;
                    pointStack.removeAllElements();
                    pointStack.push(start);
                } else if (unvisitedNeighbor.getValue() == 0) {
                    pointStack.push(unvisitedNeighbor);
                } else if (unvisitedNeighbor.getValue() == 3) {
                    pointStack.push(unvisitedNeighbor);
                    break;
                }
            } else {
                pointStack.removeAllElements();
            }
        }

        return pointStack;
    }

}
