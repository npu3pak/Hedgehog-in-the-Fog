package ru.npu3pak.labyrinth;

/**
 * Created with IntelliJ IDEA.
 * User: EVSafronov
 * Date: 20.11.13
 * Time: 9:34
 */
public class StaticObject {
    public static class Wall {
        public Position position;

        public Wall(int x, int y) {
            this.position = new Position(x, y);
        }
    }
}
