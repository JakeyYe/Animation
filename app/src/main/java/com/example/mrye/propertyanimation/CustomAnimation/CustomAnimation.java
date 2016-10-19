package com.example.mrye.propertyanimation.CustomAnimation;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;

/**
 * Created by Mr.Ye on 2016/8/25.
 */
         //自定义补间动画，也就是自定义动画效果
public class CustomAnimation extends Animation {//Animation补间动画抽象基类
    //继承Animation时关键是要重写该抽象基类的applyTransformation()方法
    private float centerX;
    private float centerY;
    private int duration;//定义动画持续时间
    private Camera camera=new Camera();//定义一个空间变换工具

    public CustomAnimation(float x, float y, int duration){
        this.centerX=x;
        this.centerY=y;
        this.duration=duration;
    }

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        setDuration(duration);//设置动画持续时间
        setFillAfter(true);//设置动画结束后停在最后一帧
        setInterpolator(new LinearInterpolator());//设置动画变化速度
        // LinearInterpolator动画以均匀遇到速度变化
    }

    /*该方法的interpolatedTime代表了抽象的动画持续时间，不管动画实际持续时间多长，
    * interpolatedTime参数总是从0（动画开始时）到1（动画结束时），
    * Transformation参数代表了组件所做的改变
    */
    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        camera.save();
        //根据interpolatorTime时间来控制向，x,y，z上的偏移
        camera.translate(100.0f-100.0f*interpolatedTime,150.0f*interpolatedTime-150,
                80.0f-80.0f*interpolatedTime);
        //设置根据interpolatedTime时间在Y轴上旋转不同角度
        camera.rotateX(360*interpolatedTime);
        //设置根据interpolatedTime时间在X轴上旋转不同角度
        camera.rotateX(360*interpolatedTime);
        //获取Transformation参数的Matrix对象
        Matrix matrix=t.getMatrix();
        camera.getMatrix(matrix);
        matrix.preTranslate(-centerX,-centerY);
        matrix.postTranslate(centerX,centerY);
        camera.restore();
    }
}
