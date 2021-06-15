package com.example.rudhira.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.android.loginscreen.R;

import java.util.Timer;
import java.util.TimerTask;

public class IntroductoryActivity extends AppCompatActivity {
    ImageView logo, splashImg;
    TextView appName;
    LottieAnimationView lottieAnimationView;
    ConstraintLayout constraintLayout;

    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introductory);

        logo = findViewById(R.id.logo);
        appName = findViewById(R.id.app_name);
        splashImg = findViewById(R.id.background);
        lottieAnimationView = findViewById(R.id.lottie);
        constraintLayout = findViewById(R.id.introActivity);


//        constraintLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
//                startActivity(intent);
//            }
//        });

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 5300);


        splashImg.animate().translationY(-2400).setDuration(1000).setStartDelay(4000);
        logo.animate().translationY(2000).setDuration(1000).setStartDelay(4000);
        appName.animate().translationY(2000).setDuration(1000).setStartDelay(4000);
        lottieAnimationView.animate().translationY(2000).setDuration(1000).setStartDelay(4000);


    }
}