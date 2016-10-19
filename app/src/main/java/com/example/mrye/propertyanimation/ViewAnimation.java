package com.example.mrye.propertyanimation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Mr.Ye on 2016/8/22.
 */
public class ViewAnimation extends AppCompatActivity {
    private AnimationDrawable animationDrawable;
    private ImageView image,tween;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animation);

        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar_drawabletest);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        image=(ImageView)findViewById(R.id.image);
        Button start1=(Button)findViewById(R.id.start);
        start1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animationDrawable=(AnimationDrawable) image.getDrawable();//获取AnimationDrawable对象
                animationDrawable.start();//调用AnimationDrawable的start()方法播放动画
                //animationDrawable.stop()//停止播放动画

            }
        });
        Button start2=(Button)findViewById(R.id.start2);
        tween=(ImageView)findViewById(R.id.Image_tween_anim);
        //加载动画资源
        final Animation anim= AnimationUtils.loadAnimation(this,R.anim.anim_tween);
        anim.setFillAfter(true);//设置动画结束后保留结束状态
        start2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tween.startAnimation(anim);
            }
        });

    }
}
