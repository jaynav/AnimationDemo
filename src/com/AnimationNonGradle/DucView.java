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
    {return true; // change this too

    }
    private Runnable updateDerState= new Runnable() {
        @Override
        public void run() {

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
    private float dragX;
    private float dragY;
    // kept track with timer
    private boolean derMoni;
    private float trackX;
    private float trackY;
    //click only
    private boolean gotClicked;
    private long clickTime;
    // current time
    private long updater;
}
