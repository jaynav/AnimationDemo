package com.animationdemo.app;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
/**
 * Created by DerpPC on 8/13/2014.
 */
public class BasicV extends View
{
    private Paint mLineP;
    private Paint mTextPaint;
    private int mCounter;

    public BasicV(Context cnxt)
    {
        super(cnxt);

        //new paint object
        mLineP = new Paint();
        mLineP.setStyle(Paint.Style.STROKE);
        mLineP.setARGB(200,0,255,0);
        mLineP.setAntiAlias(true);
        mLineP.setStrokeWidth(10);

        mTextPaint = new Paint();
        mTextPaint.setTextSize(50);
        mTextPaint.setColor(Color.RED);

    }

    //sets the drawing to the canvas
    public void onDraw(Canvas canv)
    {
        //get screen width and height
        int width = getWidth();
        int height = getHeight();
        //line from upper to lower in a slant
        canv.drawLine(0,0, width-1,height -1, mLineP);

        //draw a rectangle
        canv.drawRect(0,0,width-1 , height-1, mLineP);

        //draw Text.. must put f for float
        canv.drawText("cout me:" + mCounter,30,height* 0.25f, mTextPaint);
    }

    public void increm()
    {
        mCounter++;
        invalidate(); // just a redraw request to the queue

    }
    public int GetCounter()
    {
        return  mCounter;
    }

    public void setCount(int count)
    {
        mCounter = count;
        invalidate();
    }
}
