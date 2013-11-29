package ru.npu3pak.labyrinth;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: EVSafronov
 * Date: 20.11.13
 * Time: 9:55
 */
public class Util {
    Context context;

    public Util(Context context) {
        this.context = context;
    }

    Map loadMap(String mapName) {
        Map map = new Map();
        try {
            InputStream inStream = context.getAssets().open(mapName + ".map");
            Scanner in = new Scanner(inStream);
            int x, y = 0;
            while (in.hasNextLine()) {
                x = 0;
                for (char c : in.nextLine().toCharArray()) {
                    switch (c) {
                        case '#':
                            map.walls.add(new StaticObject.Wall(x, y));
                            break;
                        case 'P':
                            map.startPlayerPosition = new Position(x, y);
                            break;
                        case 'H':
                            map.horse = new Horse(x, y);
                            break;
                    }
                    x++;
                }
                y++;
            }
            return map;
        } catch (IOException e) {
            e.printStackTrace();
            return map;
        }
    }
}
