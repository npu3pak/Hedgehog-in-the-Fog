package ru.npu3pak.labyrinth;

/**
 * Created with IntelliJ IDEA.
 * User: EVSafronov
 * Date: 20.11.13
 * Time: 8:36
 */
public enum Direction {
    UP, LEFT, RIGHT, DOWN;

    public Direction getNextLeft() {
        switch (this) {
            case UP:
                return LEFT;
            case LEFT:
                return DOWN;
            case DOWN:
                return RIGHT;
            case RIGHT:
                return UP;
        }
        return UP;
    }

    public Direction getNextRight() {
        switch (this) {
            case UP:
                return RIGHT;
            case LEFT:
                return UP;
            case DOWN:
                return LEFT;
            case RIGHT:
                return DOWN;
        }
        return UP;
    }
}
