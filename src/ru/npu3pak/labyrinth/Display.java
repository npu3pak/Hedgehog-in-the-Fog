package ru.npu3pak.labyrinth;

import android.widget.TextView;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: EVSafronov
 * Date: 20.11.13
 * Time: 8:18
 */
public class Display {
    public static final int VISIBLE_DISTANCE = 3;

    public static final char BLOCK_WALL = '#';
    public static final char BLOCK_HORSE = '4';
    public static final char BLOCK_PLAYER_UP = '^';
    public static final char BLOCK_PLAYER_LEFT = '<';
    public static final char BLOCK_PLAYER_DOWN = 'v';
    public static final char BLOCK_PLAYER_RIGHT = '>';

    private TextView displayView;

    public Display(TextView displayView) {
        this.displayView = displayView;
    }

    public void showScreen(Map map) {
        char[][] region = new char[VISIBLE_DISTANCE * 2 + 1][VISIBLE_DISTANCE * 2 + 1];
        for (char[] row : region)
            Arrays.fill(row, ' ');

        //Рисуем стены
        for (StaticObject.Wall wall : map.walls) {
            drawObject(region, map.player.position, wall.position, BLOCK_WALL);
        }

        //Рисуем лошадь
        drawObject(region, map.player.position, map.horse.position, BLOCK_HORSE);

        //Рисуем игрока
        int regionPlayerX = VISIBLE_DISTANCE;
        int regionPlayerY = VISIBLE_DISTANCE;
        char playerChar = '@';
        switch (map.player.direction) {
            case UP:
                playerChar = BLOCK_PLAYER_UP;
                break;
            case LEFT:
                playerChar = BLOCK_PLAYER_LEFT;
                break;
            case RIGHT:
                playerChar = BLOCK_PLAYER_RIGHT;
                break;
            case DOWN:
                playerChar = BLOCK_PLAYER_DOWN;
                break;
        }
        region[regionPlayerY][regionPlayerX] = playerChar;

        //Формируем строку для вывода на экран
        StringBuilder builder = new StringBuilder();
        for (char[] row : region) {
            for (char aRow : row) {
                builder.append(aRow);
            }
            builder.append('\n');
        }

        displayView.setText(builder.toString());
    }

    private void drawObject(char[][] region, Position playerPosition, Position objectPosition, char objectChar) {
        if (objectPosition.x >= playerPosition.x - VISIBLE_DISTANCE && objectPosition.y >= playerPosition.y - VISIBLE_DISTANCE &&
                objectPosition.x <= playerPosition.x + VISIBLE_DISTANCE && objectPosition.y <= playerPosition.y + VISIBLE_DISTANCE) {
            int regionObjX = objectPosition.x - playerPosition.x + VISIBLE_DISTANCE;
            int regionObjY = objectPosition.y - playerPosition.y + VISIBLE_DISTANCE;
            region[regionObjY][regionObjX] = objectChar;
        }
    }
}
