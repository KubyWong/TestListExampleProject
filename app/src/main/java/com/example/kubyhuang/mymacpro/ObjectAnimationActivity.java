package com.example.kubyhuang.mymacpro;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.TextView;

import com.example.kubyhuang.mymacpro.utils.LogUtils;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

public class ObjectAnimationActivity extends AppCompatActivity {

    @ViewInject(value = R.id.textView)
    private TextView textView;
    @ViewInject(value = R.id.btn_start)
    private Button btn_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_animation);
        x.view().inject(this);

    }

    @Event(value = {R.id.btn_start})
    private void onclickLis(View view) {
        switch (view.getId()) {
            case R.id.btn_start:
                textView.setTextColor(getResources().getColor(android.R.color.black));
                ValueAnimator valueAnimator = ValueAnimator.ofFloat(10f,70f);
                valueAnimator.setDuration(3 * 1000);
//                valueAnimator.setInterpolator(new BounceInterpolator());
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        LogUtils.d_log("animValue  =  " + valueAnimator.getAnimatedValue());
                        float valueGet = (Float) valueAnimator.getAnimatedValue();
//                        textView.setTranslationX(valueGet);
                        textView.setTextSize(valueGet);
                    }
                });
                valueAnimator.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        textView.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
                    }
                });
                valueAnimator.start();




                /*ObjectAnimator animation = ObjectAnimator.ofFloat(textView, "translationX", 100f);
                animation.setDuration(1000);
                animation.start();
                animation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        LogUtils.d_log("animValue  =  " + valueAnimator.getAnimatedValue());
                        LogUtils.d_log("animTime  =  "+valueAnimator.getCurrentPlayTime());
                    }
                });*/
                break;
        }
    }
}
