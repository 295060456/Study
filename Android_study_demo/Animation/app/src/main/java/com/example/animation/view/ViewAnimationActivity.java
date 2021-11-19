package com.example.animation.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.animation.R;

public class ViewAnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animation);
    }

    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.viewAlphaAnimation:
                Animation alphaAnimation = AnimationUtils.loadAnimation(this,R.anim.alpha);
                view.startAnimation(alphaAnimation);
                break;
            case R.id.viewScaleAnimation:
                Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale);
                view.startAnimation(animation);
                break;
            case R.id.viewTranslateAnimation:
                Animation translateAnimation = AnimationUtils.loadAnimation(this, R.anim.translate);
                view.startAnimation(translateAnimation);
                break;
        }
    }
}