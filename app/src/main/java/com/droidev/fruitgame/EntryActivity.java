package com.droidev.fruitgame;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EntryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entry);

        TextView fruitspts = findViewById(R.id.fruits_no);
        TextView vegetablespts = findViewById(R.id.vegetables_no);
        TextView dryfruitspts = findViewById(R.id.dryfruits_no);


    }
}
