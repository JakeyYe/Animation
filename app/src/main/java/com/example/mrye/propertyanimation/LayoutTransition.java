package com.example.mrye.propertyanimation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class LayoutTransition extends AppCompatActivity {
    private LinearLayout parent;
    private int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_transition);
        parent=(LinearLayout)findViewById(R.id.parent_LinearLayout);
    }
    public void buttonAdd(View view){
         addButtonView();
    }
    public void buttonRemove(View view){
        removeButtonView();
    }
    private void addButtonView() {
        i++;
        Button button = new Button(this);
        button.setText("Button" + i);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams
                (ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);//线性布局
        parent.addView(button, params);
    }

    private void removeButtonView() {
        if (i > 0)
            parent.removeViewAt(0);//移除ViewGroup父布局中的子项，总是删除第0位置的子项
    }

}
