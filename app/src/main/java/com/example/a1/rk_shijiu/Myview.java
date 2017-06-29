package com.example.a1.rk_shijiu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 1 on 2017/6/28.
 */

public class Myview extends View {

    public Myview(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 创建画笔
        Paint p = new Paint();
        p.setColor(Color.RED);// 设置红色
        canvas.drawText("画矩形：", 10, 80, p);
        p.setColor(Color.RED);// 设置黑色
        p.setStyle(Paint.Style.FILL);//设置填满
//canvas.drawRect(60, 60, 80, 80, p);// 正方形
// canvas.drawRect(160, 190, 260, 200, p);// 长方形
        canvas.drawRect(new Rect(110,110,450,450),p);// 长宽
    }
}
