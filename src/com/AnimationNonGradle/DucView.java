package com.AnimationNonGradle;

import android.content.Context;
import android.view.View;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;

/**
 * Created by DerpPC on 9/9/2014.
 */
public class DucView extends View {
    public DucView(Context testAnimation)
    {
        super(testAnimation);
        //set background
        setBackgroundResource(R.drawable.cropit);

        derDuc = scale(BitmapFactory.decodeResource(testAnimation.getResources(),R.drawable.theduck),150);
        derAlt = scale(BitmapFactory.decodeResource(testAnimation.getResources(),R.drawable.nottheduck),150);
        derX = derY= 51;


    }

    /**
     *
     * @param derBase bitmap image
     * @param derWidth width of image to be given
     * @return returns a scaled imaged based on the bitmap  to the width
     */
    public Bitmap scale(Bitmap derBase, float derWidth)
    {
        float scale = derWidth/derBase.getWidth();

        int scaleWidth = derBase.getWidth()*(int)scale;
        int scaleHeight =derBase.getHeight()*(int)scale;
        return Bitmap.createScaledBitmap(derBase,scaleWidth, scaleHeight,false);

    }

    /**
     * draw on canvas of custom view depending on click, may show alternative view
     * @param derScreen screen of phone
     */
    public void onDraw(Canvas derScreen)
    {
        if(gotClicked)
        {
            derScreen.drawBitmap(derAlt,derX,derY,null);
        }
        else
        {
            derScreen.drawBitmap(derDuc,derX,derY,null);
        }

    }

    /**
     * notification of touch event
     * @param dahEvent current touch event
     * @return return true if event happened
     */
    @Override
    public boolean onTouchEvent(MotionEvent dahEvent)
    {
        float onTEventX =dahEvent.getX();
        float onTEventY =dahEvent.getY();
        int action = dahEvent.getAction();


        if(derMoto)
        {
            if(action == MotionEvent.ACTION_DOWN)
            {
                if(derX <= onTEventX && derX + derDuc.getWidth() > onTEventX && derY <= onTEventY && derY+ derDuc.getHeight() > onTEventY)
                {
                    clickTime = System.currentTimeMillis();
                    gotClicked = true;
                    //redraw
                    invalidate();

                }
            }
        }
        else
        {
            if(action == MotionEvent.ACTION_DOWN)
            {
                if(derX <= onTEventX && derX + derDuc.getWidth() > onTEventX && derY <= onTEventY && derY+ derDuc.getHeight() > onTEventY)
                {
                    lastDragX= onTEventX;
                    lastDragY= onTEventY;
                    derDrag = true;

                }
                else // missing duck out of screen
                {
                    derX= onTEventX - derDuc.getWidth()/2;
                    derY = onTEventY - derDuc.getHeight()/2;
                   // redraw
                    invalidate();

                }

            }
            //finger drag
            else if(action == MotionEvent.ACTION_MOVE && derDrag)
            {
                float deltX = onTEventX - lastDragX;
                float deltY = onTEventY - lastDragY;

                //apply delta
                derX += deltX;
                derY += deltY;
                //redraw new location
                invalidate();
                //store current location
                lastDragX = onTEventX;
                lastDragY = onTEventY;
            }
        }




        return true; // change this too

    }
    private Runnable updateDerState= new Runnable() {

        public void run()
        {

        }
    };
    public void wrapper(){}
    public void randomDirection(){}
    public void start()
    {
    }

    public void stop()
    {

    }
///////////////////////////////////////////////////////////////////
    //for image
    private Bitmap derDuc;
    private Bitmap derAlt;
    //where it starts
    private float derX;
    private float derY;
    // click drag
    private boolean derDrag;
    private float lastDragX;
    private float lastDragY;
    // kept track with timer
    private boolean derMoto;
    private float trackPerSecX;
    private float trackperSecY;
    //click only
    private boolean gotClicked;
    private long clickTime;
    // current time
    private long updater;
}
