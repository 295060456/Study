package com.example.animation.frame;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;

import com.example.animation.R;

public class FrameAnimationActivity extends AppCompatActivity {

    private AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View view = findViewById(R.id.view);
        animationDrawable = (AnimationDrawable) view.getBackground();
    }

    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnStart:
                animationDrawable.start();
                break;
            case R.id.btnStop:
                animationDrawable.stop();
                break;
        }
    }
}