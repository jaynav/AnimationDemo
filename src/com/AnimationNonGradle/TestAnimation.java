package com.AnimationNonGradle;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.view.View;
/**
 * Created by DerpPC on 9/9/2014.
 */
public class TestAnimation extends Activity {

    protected DucView duckview = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testmonkey);

        LinearLayout setLay = (LinearLayout) findViewById(R.id.thecontainer);


         duckview = new DucView(this);
        //make view

        duckview.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));
        setLay.addView(duckview);

        // add btns
        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);



    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //on resume goes here
    @Override
    public void onResume()
    {
        super.onResume();
    }

    //on pause goes here
    @Override
    public void onPause()
    {
        super.onPause();
    }
    //on save goes here
    @Override
    public void onSaveInstanceState(Bundle outSaveState)

    {
        super.onSaveInstanceState(outSaveState);
    }

    //on destroy goes here
    public void  onDestroy()
    {
        super.onDestroy();
    }

    public void monitorStart(View derView)
    {
        duckview.start();

    }
    public void monitorStop(View derView)
    {
        duckview.stop();

    }

    public void finishedActivity(View finishActivity)
    {
        //use this with startActivityForResult();
       // onActivityResult(); to get result
        //setResult();

        finish();

    }
}
