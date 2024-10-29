package com.droidev.fruitgame;

import android.icu.util.ICUUncheckedIOException;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class EntryActivity extends AppCompatActivity {


    int[] images = {R.drawable.lady_sfinger,R.drawable.pista, R.drawable.orange, R.drawable.carrot, R.drawable.banana, R.drawable.apple, R.drawable.drygrapes};
    TextView fruits, vegetables, dryfruits;
    String[] categories = {"Fruits", "Vegetables", "Dry Fruits"};
    int currentpos = 0;
    ImageView dynamicimage;

    float dX, dY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entry);

        dynamicimage = findViewById(R.id.image);
//        TextView fruitspts = findViewById(R.id.fruits_no);
//        TextView vegetablespts = findViewById(R.id.vegetables_no);
//        TextView dryfruitspts = findViewById(R.id.dryfruits_no);
        fruits = findViewById(R.id.fruits_bucket);
        vegetables = findViewById(R.id.vegetables_bucket);
        dryfruits = findViewById(R.id.dryfruits_bucket);



        dynamicimage.setImageResource(images[currentpos]);



        toggleImageSizeandSwap();


    }

    private void checkMatch(View dynamicimage) {
        String correctcategory = categories[currentpos];
        boolean isMatch = false;

        if(isNear(dynamicimage, fruits) && correctcategory.equals("Fruits")) isMatch = true;
        else if(isNear(dynamicimage, vegetables) && correctcategory.equals("Vegetables")) isMatch = true;
        else if(isNear(dynamicimage, dryfruits) && correctcategory.equals("Dry Fruits")) isMatch = true;

        if(isMatch) showMessage("Well Done");
        else showMessage("Wrong match");

//        new Handler().postDelayed(this::nextImage, 2000);
        toggleImageSizeandSwap();
    }

    private void toggleImageSizeandSwap() {
//        dynamicimage.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                switch(event.getAction()) {
//                    case MotionEvent.ACTION_DOWN:
//                        dX = v.getX() - event.getRawX();
//                        dY = v.getY() - event.getRawY();
//                        return true;
//                    case MotionEvent.ACTION_MOVE:
//                        v.animate()
//                                .x(event.getRawX() + dX)
//                                .y(event.getRawY() + dY)
//                                .setDuration(0)
//                                .start();
//                        return true;
//                    case MotionEvent.ACTION_UP:
//                        checkMatch(v);
//                        v.performClick();
//                        return true;
//
//                }
//                return false;
//            }
//        });
        animateImage(1.0f, 10f, this::nextImage);
    }

//    public boolean performClick() {
//        super.performClick();
//        return true;
//    }

    private void animateImage(float fromScale, float toScale, Runnable onEnd) {

        ScaleAnimation animation = new ScaleAnimation(
                fromScale, toScale,
                fromScale, toScale,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );
        animation.setDuration(5000);
        animation.setFillAfter(true);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if(onEnd != null) onEnd.run();
                toggleImageSizeandSwap();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

        });
        dynamicimage.startAnimation(animation);
    }

    private boolean isNear(View dynamicimage, TextView textView) {

        int[] imagelocation = new int[2];
        int[] textlocation = new int[2];

        dynamicimage.getLocationOnScreen(imagelocation);
        textView.getLocationOnScreen(textlocation);

        int imageX = imagelocation[0];
        int imageY = imagelocation[1];
        int textX = textlocation[0];
        int textY = textlocation[1];

        return Math.abs(imageX - textX) < 150 && Math.abs(imageY - textY) < 150;
    }

    private void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT);
    }

    private void nextImage() {
        checkMatch(dynamicimage);
        currentpos = (currentpos + 1) % images.length;
        dynamicimage.setImageResource(images[currentpos]);
        dynamicimage.animate()
                .x(((ViewGroup) dynamicimage.getParent()).getWidth() / 2f - dynamicimage.getWidth() / 2f)
                .y(((ViewGroup) dynamicimage.getParent()).getHeight() / 2f - dynamicimage.getHeight() / 2f)
                .setDuration(10)
                .start();
    }
}
