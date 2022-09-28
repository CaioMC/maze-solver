package main.java.model;

import main.java.model.enums.Direction;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NeighborUtils {

    public static Point unvisitedNeighbor(Point current, Point[][] maze) {
        Point unvisitedNeighbor ;
        List<Point> unvisitedNeighborList = new ArrayList<>();

        for (Direction direction : Direction.values()) {
            int newRow = 0;
            int newColumn = 0;

            if (Direction.RIGHT.equals(direction)) {
                newColumn = current.getColumn() +1;
                newRow = current.getRow();

                if (!verifyBounds(current, newRow, newColumn))
                    continue;
            } else if (Direction.DOWN.equals(direction)) {
                newColumn = current.getColumn();
                newRow = current.getRow() +1;

                if (!verifyBounds(current, newRow, newColumn))
                    continue;
            }

            unvisitedNeighbor = maze[newRow][newColumn];

            if (!unvisitedNeighbor.isVisited()) {
                unvisitedNeighborList.add(maze[newRow][newColumn]);
            }

        }

        if (unvisitedNeighborList.size() == 0) {
            return null;
        }

        for (Point point : unvisitedNeighborList) {
            if (point.getValue() == 0 && !point.isVisited()|| point.getValue() == 2 && !point.isVisited()|| point.getValue() == 3 && !point.isVisited()) {
                return point;
            }
        }

        Random rand = new Random();
        return unvisitedNeighborList.get(rand.nextInt(unvisitedNeighborList.size()));
    }

    public static boolean verifyBounds(Point point, int newRow, int newColumn) {
        if (newRow < 0 || newRow > point.getMSIZE() - 1) {
            return false;
        }

        if (newColumn < 0 || newColumn > point.getMSIZE() - 1) {
            return false;
        }

        return true;
    }

}
