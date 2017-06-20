package com.example.animationtestproject;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_test1,tv_test2;
    private ImageView iv_1,iv_2;
    private int count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        tv_test1 = (TextView) findViewById(R.id.tv_test1);
        tv_test2 = (TextView) findViewById(R.id.tv_test2);
        iv_1 = (ImageView) findViewById(R.id.iv_1);
        iv_2 = (ImageView) findViewById(R.id.iv_2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.frame_animation:
                iv_1.setImageResource(R.drawable.animation_test_frame);
                AnimationDrawable animationDrawable = (AnimationDrawable) iv_1.getDrawable();
                animationDrawable.start();
                break;
            case R.id.tween_animation_set:
                Animation animationSet = AnimationUtils.loadAnimation(this, R.anim.anim_set);
                iv_1.startAnimation(animationSet);
                break;
            case R.id.tween_animation_translate:
                Animation animationTranslate = AnimationUtils.loadAnimation(this, R.anim.anim_tranlate);
                iv_1.startAnimation(animationTranslate);
                break;
            case R.id.transprate:
                if (tv_test1.getVisibility() == View.GONE) {
                    tv_test1.setVisibility(View.VISIBLE);
                    float destance = 100f;
                    ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(tv_test1, "translationX", -destance * 2);
                    ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(tv_test2, "translationX", destance * 2);
                    objectAnimator1.setDuration(1000);
                    objectAnimator2.setDuration(1000);
                    objectAnimator1.start();
                    objectAnimator2.start();
                } else {
                    float destance = 0f;
                    AnimatorSet set = new AnimatorSet();
                    ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(tv_test1, "translationX", -destance * 2);
                    ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(tv_test2, "translationX", destance * 2);
                    objectAnimator1.setDuration(1000);
                    objectAnimator2.setDuration(1000);
                    set.play(objectAnimator1).with(objectAnimator2);
                    set.start();
                    objectAnimator2.addListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            tv_test1.setVisibility(View.GONE);
                        }
                    });
                }
                break;
            case R.id.alpha:
                //iv_1.setAlpha(1.0f);该view必须有get和set这个属性的方法才行
                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(iv_1, "alpha", 0.1f);
                objectAnimator.start();

                //监听动画，方式1，监听全部
                objectAnimator.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {

                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                });

                //监听动画，方式2，监听单个
                objectAnimator.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                    }
                });

                break;
            case R.id.rotation:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    //属性动画简写方式
                    iv_1.animate()
                            .rotation(90.0f)
                            .setDuration(500)
                            .withStartAction(new Runnable() {
                                @Override
                                public void run() {
                                    //动画开始
                                }
                            })
                            .withEndAction(new Runnable() {
                                @Override
                                public void run() {
                                    //动画结束
                                }
                            })
                            .start();
                }else{
                    ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 100);
                    valueAnimator.setDuration(600);
                    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float valueGet = (float) valueAnimator.getAnimatedValue();
                            tv_test2.setRotation(valueGet);
                        }
                    });
                    valueAnimator.start();
                }

                break;
            case R.id.scale:
                Animator animator = AnimatorInflater.loadAnimator(this, R.animator.animator_scale);
                animator.setTarget(iv_1);
                animator.start();
                break;
            case R.id.svg_animator_lujing:
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    AnimatedVectorDrawable animatedVectorDrawable =
                            (AnimatedVectorDrawable) getDrawable(R.drawable.animated_vector_lujing_xin);
                    iv_2.setImageDrawable(animatedVectorDrawable);
                    animatedVectorDrawable.start();
                }
                break;

            case R.id.svg_animator_bianxing:
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    AnimatedVectorDrawable animatedVectorDrawable =
                            (AnimatedVectorDrawable) getDrawable(R.drawable.animated_vector_bianxing_xin);
                    iv_2.setImageDrawable(animatedVectorDrawable);
                    animatedVectorDrawable.start();
                }
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}
