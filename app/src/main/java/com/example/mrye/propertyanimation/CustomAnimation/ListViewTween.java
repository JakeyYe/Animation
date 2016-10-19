package com.example.mrye.propertyanimation.CustomAnimation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;

import com.example.mrye.propertyanimation.R;

/**
 * Created by Mr.Ye on 2016/8/25.
 */
public class ListViewTween extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_tween);

        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar_listview);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        //获取ListView组件
        ListView listView=(ListView)findViewById(R.id.list_item);

        WindowManager windowManager=(WindowManager)getSystemService(WINDOW_SERVICE);
        Display display=windowManager.getDefaultDisplay();
        DisplayMetrics metrics=new DisplayMetrics();
        display.getMetrics(metrics);//获取屏幕的宽和高
        //设置对ListView组件应用动画
        listView.setAnimation(new CustomAnimation(metrics.xdpi/2,metrics.ydpi/2,3500));
        //就是将设置好的动画效果附加到listview组件上
    }
}
