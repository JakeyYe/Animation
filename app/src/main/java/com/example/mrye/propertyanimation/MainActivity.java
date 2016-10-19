package com.example.mrye.propertyanimation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.mrye.propertyanimation.CustomAnimation.ListViewTween;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.customanimation).setOnClickListener(this);//自定义动画
        findViewById(R.id.view_animation).setOnClickListener(this);//视图动画
        findViewById(R.id.property_animation).setOnClickListener(this);//属性动画
        findViewById(R.id.layouttransition).setOnClickListener(this);//布局动画
        findViewById(R.id.svg_animation).setOnClickListener(this);//SVG动画
    }

    @Override
    public void onClick(View v) {
        int viewId=v.getId();
        switch (viewId) {
            case R.id.customanimation:
                startActivity(new Intent(MainActivity.this, ListViewTween.class));
                break;
            case R.id.view_animation:
                startActivity(new Intent(MainActivity.this,ViewAnimation.class));
                break;
            case R.id.property_animation:
                startActivity(new Intent(MainActivity.this,PAnimatorAcitvity.class));
                break;
            case R.id.svg_animation:
                startActivity(new Intent(MainActivity.this,SVGActivity.class));
                break;
            case R.id.layouttransition:
                startActivity(new Intent(MainActivity.this,LayoutTransition.class));
                break;
        }
    }
}
