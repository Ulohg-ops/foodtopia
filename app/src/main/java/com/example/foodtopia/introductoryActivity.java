package com.example.foodtopia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Timer;
import java.util.TimerTask;

public class introductoryActivity extends AppCompatActivity {

    //splash底
    ImageView background;
    //動畫
    LottieAnimationView animation;
    //Foodtopia
    TextView text_logo;
    Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introductory);

        background = findViewById(R.id.background);
        animation = findViewById(R.id.animation);
        text_logo = findViewById(R.id.text_logo);

        // change color of text_logo
        // 配色可能要改！
        String text = "Foodtopia";
        SpannableString spannableString = new SpannableString(text);

        ForegroundColorSpan yellow = new ForegroundColorSpan(getResources().getColor(R.color.my_yellow));
        ForegroundColorSpan green = new ForegroundColorSpan(getResources().getColor(R.color.my_green));
        ForegroundColorSpan red = new ForegroundColorSpan(getResources().getColor(R.color.my_red));

        spannableString.setSpan(yellow, 1, 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(green, 2, 3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(red, 7, 8, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        text_logo.setText(spannableString);

        // add animation of text_logo
        Animation am = new AlphaAnimation(0.0f, 1.0f);
        am.setDuration(2000);
        am.setRepeatCount(0);
        text_logo.startAnimation(am);

        background.animate().translationY(-2000).setDuration(1000).setStartDelay(4000);
        animation.animate().translationY(2000).setDuration(1000).setStartDelay(4000);
        text_logo.animate().translationY(1400).setDuration(1000).setStartDelay(4000);

        //automatically switch to another activity
        timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent=new Intent(introductoryActivity.this,OnboardingActivity.class);
                startActivity(intent);
            }
        },6000);
    }
}