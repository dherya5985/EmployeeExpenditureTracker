package com.example.khatabook;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class Splash_Screen extends AppCompatActivity {
    private static int SPLASH_SCREEN = 5000;
    Animation topanim , bottomanim;
    ImageView logoimg;
    TextView slogan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__screen);

        topanim = AnimationUtils.loadAnimation(this,R.anim.top_wave);
        bottomanim = AnimationUtils.loadAnimation(this,R.anim.bottom_wave);
        logoimg = findViewById(R.id.logo);
        slogan = findViewById(R.id.slogantxt);

        logoimg.setAnimation(topanim);
        slogan.setAnimation(bottomanim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash_Screen.this,Register.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);

    }


}