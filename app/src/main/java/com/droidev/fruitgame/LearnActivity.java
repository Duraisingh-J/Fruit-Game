package com.droidev.fruitgame;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class LearnActivity extends AppCompatActivity {

    /* Create the three buttons.
        fruits
        vegetables
        dry fruits
       Inside them create the recyclerview with name and photo and intent them to know about them.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learn);

    }
}
