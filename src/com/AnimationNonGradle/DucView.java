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

    }


    public Bitmap scale(Bitmap derBase, float derWidth)
    {return null;// change from null

    }

    public void onDraw(Canvas derScreen)
    {}
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
    private boolean gotClick;
    private long clickTime;
    // current time
    private long updater;
}
