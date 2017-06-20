package com.example.kubyhuang.mymacpro;

import android.animation.PropertyValuesHolder;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

public class SVGActivity extends AppCompatActivity implements View.OnClickListener {

    private AnimatedVectorDrawable anima1;

    @ViewInject(value = R.id.imageView)
    private ImageView imageView;
    @ViewInject(value = R.id.imageView1)
    private ImageView imageView1;

    private AnimatedVectorDrawable anima2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_svg);
        x.view().inject(this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            anima1 = (AnimatedVectorDrawable) getDrawable(R.drawable.anim_edit_login);
            anima2 = (AnimatedVectorDrawable) getDrawable(R.drawable.anim_android_rotation);
        }

        imageView.setOnClickListener(this);
        imageView1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageView:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    imageView.setImageDrawable(anima1);
                    anima1.start();
                }

                break;
            case R.id.imageView1:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    imageView1.setImageDrawable(anima2);
                    anima2.start();
                }

                break;
        }
    }
}
