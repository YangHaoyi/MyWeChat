package com.yanghaoyi.mywechat;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import tyrantgit.widget.HeartLayout;

public class MainActivity extends FragmentActivity {

    private Random mRandom = new Random();
    private Timer mTimer = new Timer();
    private HeartLayout mHeartLayout;
    private TextView tvDear;
    private TextView tvQixi;
    private TextView tvHappy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHeartLayout = findViewById(R.id.heart_layout);
        tvDear = findViewById(R.id.tvDear);
        tvQixi = findViewById(R.id.tvQixi);
        tvHappy = findViewById(R.id.tvHappy);
        startHeartAnim();
        startDearAnim();
        startQixiAnim();
        startHappyAnim();
    }

    private int randomColor() {
        return Color.rgb(mRandom.nextInt(255), mRandom.nextInt(255), mRandom.nextInt(255));
    }

    private void startHeartAnim(){
        mTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                mHeartLayout.post(new Runnable() {
                    @Override
                    public void run() {
                        mHeartLayout.addHeart(randomColor());
                    }
                });
            }
        }, 500, 200);
    }

    private void startDearAnim(){
        ObjectAnimator translationX = ObjectAnimator.ofFloat(tvDear, "translationY", -200, 0);
        //创建透明度动画
        ObjectAnimator alpha = ObjectAnimator.ofFloat(tvDear, "alpha", 0.0f, 1.0f);
        //动画集合
        AnimatorSet set = new AnimatorSet();
        //添加动画
        set.play(translationX).with(alpha);
        //设置时间等
        set.setDuration(3000);
        set.start();
    }

    private void startQixiAnim(){
        ObjectAnimator translationX = ObjectAnimator.ofFloat(tvQixi, "translationX", -600, 0);
        //创建透明度动画
        ObjectAnimator alpha = ObjectAnimator.ofFloat(tvQixi, "alpha", 0.0f, 1.0f);
        //动画集合
        AnimatorSet set = new AnimatorSet();
        //添加动画
        set.play(translationX).with(alpha);
        //设置时间等
        set.setDuration(3000);
        set.start();
    }

    private void startHappyAnim(){
        ObjectAnimator translationX = ObjectAnimator.ofFloat(tvHappy, "translationX", 600, 0);
        //创建透明度动画
        ObjectAnimator alpha = ObjectAnimator.ofFloat(tvHappy, "alpha", 0.0f, 1.0f);
        //动画集合
        AnimatorSet set = new AnimatorSet();
        //添加动画
        set.play(translationX).with(alpha);
        //设置时间等
        set.setDuration(3000);
        set.start();
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        mTimer.cancel();
    }
}
