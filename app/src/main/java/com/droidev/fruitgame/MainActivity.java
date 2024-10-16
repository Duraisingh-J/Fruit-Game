package com.droidev.fruitgame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.GameState;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    /*TO DO
        1. Create the front page with attractive template.
             i  Start new Game
            ii  Learn about the fruits, vegetables, dry fruits
                along with names, pictures, benefits and causes if we eat too much.
           iii  Settings.
           iv   Exit.

        2. Make the second page in which we play the game.
            i   3 Lives
            ii  Increase the speed
        3. Show the result in the next page along with the wrong matches and help learn those wrong matches*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button start = findViewById(R.id.start);
        Button learn = findViewById(R.id.learn);
        Button settings = findViewById(R.id.settings);
        Button exit = findViewById(R.id.exit);

        start.setOnClickListener(v -> {
            Intent entry = new Intent(MainActivity.this, EntryActivity.class);
            startActivity(entry);
        });

        learn.setOnClickListener(v -> {
            Intent know = new Intent(MainActivity.this, LearnActivity.class);
            startActivity(know);
        });

        settings.setOnClickListener(v -> {
            Intent set = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(set);
        });



    }

}