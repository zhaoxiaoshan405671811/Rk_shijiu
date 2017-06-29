package com.example.rk_20dy;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by 1 on 2017/6/29.
 */

public class MyView extends View {
    private Paint mPaint;
    private float x=200;
    private float y=200;
    //实例化一个Rect对象，用来测量视图
    Rect rect = new Rect();
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        //创建画笔
        mPaint = new Paint();
        //设置颜色
        mPaint.setColor(Color.BLUE);
        //设置抗锯齿
        mPaint.setAntiAlias(true);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画圆方法 三个参数 前两个是x,y坐标，第三个是圆的半径，最后一个是画笔
        canvas.drawCircle(x,y,100,mPaint);

        rect.set((int)(x-100),(int)(y-100),(int)(x+100),(int)(y+100));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                float x1 = event.getX();
                float y1 = event.getY();
                if(x1>rect.left && x1<rect.right && y1>rect.top && y1<rect.bottom){
                    //得到当前的坐标
                    this.x = event.getX();
                    this.y = event.getY();
                    //刷新视图
                    invalidate();//主线程调用刷新
                    //子线程调用刷新  postInvalidate();
                }

                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }
}
