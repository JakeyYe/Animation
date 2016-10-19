package com.example.mrye.propertyanimation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PAnimatorAcitvity extends AppCompatActivity implements View.OnClickListener {

    private int[] mRes = {R.id.imageView_a, R.id.imageView_b, R.id.imageView_c,
            R.id.imageView_d, R.id.imageView_e};
    private List<ImageView> mImageViews = new ArrayList<>();
    private boolean IsOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panimator);

        for (int i = 0; i < mRes.length; i++) {
            ImageView imageView = (ImageView) findViewById(mRes[i]);
            imageView.setOnClickListener(this);
            mImageViews.add(imageView);
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.imageView_a:
                if (IsOpen) {//展开状态
                    closeAnimator();
                } else {
                    startAnimator();
                }
                break;
            case R.id.imageView_b:
                Toast.makeText(this, "b", Toast.LENGTH_SHORT).show();
                break;
            case R.id.imageView_c:
                Toast.makeText(this, "c", Toast.LENGTH_SHORT).show();
                break;
            case R.id.imageView_d:
                Toast.makeText(this, "d", Toast.LENGTH_SHORT).show();
                break;
            case R.id.imageView_e:
                Toast.makeText(this, "e", Toast.LENGTH_SHORT).show();
                break;
            default:
                if (IsOpen) {//展开状态
                    closeAnimator();
                }
                break;

        }
    }

    private void startAnimator() {
        ObjectAnimator animator_a = ObjectAnimator.ofFloat(
                mImageViews.get(0),
                "alpha",
                1.0F,
                0.5F);
        ObjectAnimator animator_b = ObjectAnimator.ofFloat(
                mImageViews.get(1),
                "translationY",
                200F);
        ObjectAnimator animator_c = ObjectAnimator.ofFloat(
                mImageViews.get(2),
                "translationX",
                200F);
        ObjectAnimator animator_d = ObjectAnimator.ofFloat(
                mImageViews.get(3),
                "translationY",
                -200F);
        ObjectAnimator animator_e = ObjectAnimator.ofFloat(
                mImageViews.get(4),
                "translationX",
                -200F);
        AnimatorSet set = new AnimatorSet();
        set.setDuration(500);
        set.setInterpolator(new BounceInterpolator());
        set.playTogether(animator_a, animator_b, animator_c, animator_d, animator_e);
        set.start();
        IsOpen = true;

    }

    private void closeAnimator() {
        ObjectAnimator animator_a = ObjectAnimator.ofFloat(mImageViews.get(0),
                "alpha", 0.5F, 1F);
        ObjectAnimator animator_b = ObjectAnimator.ofFloat(mImageViews.get(1),
                "translationY", 200F, 0);
        ObjectAnimator animator_c = ObjectAnimator.ofFloat(mImageViews.get(2),
                "translationX", 200F, 0);
        ObjectAnimator animator_d = ObjectAnimator.ofFloat(mImageViews.get(3),
                "translationY", -200F, 0);
        ObjectAnimator animator_e = ObjectAnimator.ofFloat(mImageViews.get(4),
                "translationX", -200F, 0);
        AnimatorSet set = new AnimatorSet();
        set.setDuration(500);
        set.setInterpolator(new BounceInterpolator());
        set.playTogether(animator_a, animator_b, animator_c, animator_d, animator_e);
        set.start();
        IsOpen = false;
    }
}
