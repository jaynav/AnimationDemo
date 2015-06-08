package com.AnimationNonGradle;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by DerpPC on 6/7/2015.
 */
public class SelecImage
{

    protected static int size = 150;
    public static Bitmap getPref(Context testAnimation)
    {
        SharedPreferences prefer =  testAnimation.getSharedPreferences("changeDefalut", 0);
        return BitmapFactory.decodeResource(testAnimation.getResources(),prefer.getInt("whichImage", R.drawable.theduck));

    }

    public static int getSize()
    {
        return size;
    }
    public  static Bitmap getAlt(Context testAni)
    {
        return BitmapFactory.decodeResource(testAni.getResources(),R.drawable.nottheduck);
    }


}