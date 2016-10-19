package com.example.mrye.propertyanimation;

import android.annotation.TargetApi;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class SVGActivity extends AppCompatActivity {
    private ImageView imageView;
    private AnimatedVectorDrawable go,back;
    private boolean flag=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_svg);
        imageView=(ImageView) findViewById(R.id.image);
        //获取AnimatedVectorDrawable对象
        go = (AnimatedVectorDrawable) getResources().getDrawable(R.drawable.svg_animated_vectordrawable);
        back = (AnimatedVectorDrawable) getResources().getDrawable(R.drawable.svg_animated_vectordrawable2);

        imageView.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                if (!flag ) {
                    imageView.setImageDrawable(go);//动态设置ImageView的src
                    go.start();
                    flag=true;
                }
                else{
                    imageView.setImageDrawable(back);
                    back.start();
                    flag=false;
                }

            }
        });
    }


}
