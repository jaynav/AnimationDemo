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
    /**
     * the extended view constructor for duck
     * @param testAnimation the parent context view from test animation.java needed in this extension view
     */
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
     * @param givenWidth width of image to be given
     * @return returns a scaled imaged based on the bitmap  to the given width
     */
    public Bitmap scale(Bitmap derBase, float givenWidth)
    {
        float scale = givenWidth/derBase.getWidth();

        int scaleWidth = (int)(derBase.getWidth()* scale);
        int scaleHeight =(int)(derBase.getHeight()*scale);
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




        return true;

    }

    /**
     * how many times per second to move the image across the screen
     */
    private Runnable updateDerState= new Runnable() {

        public void run()
        {
            long rightnow = System.currentTimeMillis();
            float elaspedTime =(rightnow -updater)/1000.0f;
            updater = rightnow;
           //bug must add last elapsed time to current time. if not it will stay in the same spot
            derX += trackPerSecX * elaspedTime;
            derY += trackperSecY * elaspedTime;
            wrapper();
            invalidate();

            // true for 1 sec
            if(gotClicked)
            {
                if(rightnow - clickTime >=1000)
                {
                 gotClicked = false;
                }
            }
            //run again in 5ms
            getHandler().postDelayed(this, 5);


        }
    };

    /**
     * wraps image from edge to edge
     */
    public void wrapper()
    { // make sure this is correct bugs hide here and image will stay in one spot
        if(derX< 0 )
        {
            derX += getWidth();
        }
        if (derY<0)
        {
            derY += getHeight();
        }
        if(derX >= getWidth())
        {
            derX -= getWidth();
        }
        if(derY >= getHeight())
        {
            derY -=getHeight();
        }
    }

    /**
     * changes direction at random
     */
    public void randomDirection()
    {

        trackPerSecX = (float)(Math.random()*600-299);
        trackperSecY = (float)(Math.random()*600-299);
    }
    public void start()
    {
        updater = System.currentTimeMillis();
        randomDirection();
        getHandler().removeCallbacks(updateDerState);
        getHandler().post(updateDerState);
        derMoto = true;
    }

    public void stop()
    {
       getHandler().removeCallbacks(updateDerState);
       derMoto = false;
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
