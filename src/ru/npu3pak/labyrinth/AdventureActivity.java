package ru.npu3pak.labyrinth;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class AdventureActivity extends Activity {
    private Display display;

    private Player player;
    private Map map;

    private int stepsCounter = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adventure);
        TextView textDisplay = (TextView) findViewById(R.id.adventure_text_display);
        display = new Display(textDisplay);
        initNewGame();
    }

    public void initNewGame() {
        map = Map.load(this, "map1");
        player = new Player(map);
        refreshScreen();
    }

    @SuppressWarnings("unused")
    public void OnForwardButtonClick(View sender) {
        player.moveForward();
        refreshScreen();
        searchHorse();
    }

    @SuppressWarnings("unused")
    public void OnBackButtonClick(View sender) {
        player.moveBack();
        refreshScreen();
        searchHorse();
    }

    @SuppressWarnings("unused")
    public void OnTurnLeftButtonClick(View sender) {
        player.turnLeft();
        refreshScreen();
    }

    @SuppressWarnings("unused")
    public void OnTurnRightButtonClick(View sender) {
        player.turnRight();
        refreshScreen();
    }

    public void refreshScreen() {
        display.showScreen(map);
    }


    public void searchHorse() {
        stepsCounter++;
        if (stepsCounter % 5 == 0) {
            Toast.makeText(this, "Лошадка-а-а!", Toast.LENGTH_SHORT).show();
        }
        checkWinConditions();
    }

    public void checkWinConditions() {
        if (player.position.equals(map.horse.position))
            showWinMessage("Вы победили!", String.format("Доблестный ёжик нашел сраную лошадь за %d ходов", stepsCounter));
    }

    private void showWinMessage(String title, String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Прекратить маяться хуйней", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alertDialog.setIcon(R.drawable.ic_launcher);
        alertDialog.show();
    }

}