package ru.npu3pak.labyrinth;

/**
 * Created with IntelliJ IDEA.
 * User: EVSafronov
 * Date: 20.11.13
 * Time: 8:34
 */
public class Player {
    public Map map;

    public Position position;
    public Direction direction;

    public Player(Map map) {
        this.map = map;
        this.map.player = this;
        this.position = map.getStartPlayerPosition();
        this.direction = map.getStartPlayerDirection();
    }

    public void moveForward() {
        Position nextPosition = position.getNextForwardPosition(direction);
        if (map.canMove(nextPosition))
            position = nextPosition;
    }

    public void moveBack() {
        Position nextPosition = position.getNextBackwardPosition(direction);
        if (map.canMove(nextPosition))
            position = nextPosition;
    }

    public void turnLeft() {
        direction = direction.getNextLeft();
    }

    public void turnRight() {
        direction = direction.getNextRight();
    }
}