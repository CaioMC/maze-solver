package main.java.model;

public class Point {

    private Integer value;
    private boolean isVisited = false;
    private int row;
    private int column;
    private int MSIZE;

    private boolean isCurrent = false;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public boolean getIsCurrent() {
        return isCurrent;
    }

    public void isCurrent(boolean current) {
        isCurrent = current;
    }

    public int getMSIZE() {
        return MSIZE;
    }

    public void setMSIZE(int MSIZE) {
        this.MSIZE = MSIZE;
    }
}
