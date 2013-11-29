package ru.npu3pak.labyrinth;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: EVSafronov
 * Date: 20.11.13
 * Time: 8:47
 */
public class Map {
    public Player player;
    public Horse horse;
    public Position startPlayerPosition;

    public ArrayList<StaticObject.Wall> walls = new ArrayList<StaticObject.Wall>();

    public static Map load(Context context, String mapName) {
        Util u = new Util(context);
        return u.loadMap(mapName);
    }

    public boolean canMove(Position position) {
        for (StaticObject.Wall wall : walls) {
            if (wall.position.equals(position))
                return false;
        }
        return true;
    }

    public Position getStartPlayerPosition() {
        return startPlayerPosition;
    }

    public Direction getStartPlayerDirection() {
        return Direction.UP;
    }
}