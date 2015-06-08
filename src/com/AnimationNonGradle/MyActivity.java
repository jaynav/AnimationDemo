package com.AnimationNonGradle;

        import android.app.Activity;
        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.Button;
        import android.widget.LinearLayout;

public class MyActivity extends Activity {

    /*
    by default the constructor opens up with the extended by of basic view.
    to open up duck view, it opens a second activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout container = (LinearLayout) findViewById(R.id.container);

        //making  the Bview
        final BasicV derView = new BasicV(this);
        derView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT));

        container.addView(derView);

        // change this button
        Button btn = (Button) findViewById(R.id.button1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                derView.increm();

                //dummy test
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    derView.increm();
                }
            }
        });
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
        // Handle action bar item clicks here.

       switch(item.getItemId())
       {
           case R.id.action_settings:
               selectImageNotFromGallary(1);
               return true;
           case R.id.action_alter:
               selectImageNotFromGallary(2);
               return true;

        default:
            return super.onOptionsItemSelected(item);
       }


    }

//may change this code to select an image from gallery browser
    // to access gallery use intent.settype("/image/*").setAction(Intent.action_get_Content)
    // then startActivityForResult(intent.createChooser(intent, getstring(),1);
    // then on onActivityResult(request, result, intent data).... if resultcode= ok and if requestcode =1,
    // get the uri location of data.getdata
    // also if implementing on custom view and using actionbar, make sure to import view.Menu.
    // with custom view, it does not automatically use the actionbar from the main activity
    private void selectImageNotFromGallary(int i)
    {
        int val;
        switch (i)
        {

            case 1:
                val = R.drawable.theduck;
                break;
            case 2:
                val = R.drawable.angus;
                break;
            default:
                val = R.drawable.theduck;
        }

        SharedPreferences prefer = getSharedPreferences("changeDefalut", 0);
        SharedPreferences.Editor edi = prefer.edit();
        edi.putInt("whichImage",val).commit();
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


    ////////////////////////////////////////click methods

    public void startMonkeyAni (View dahView)
    {
        Intent dahIntent =  new Intent(this,TestAnimation.class);
        startActivity(dahIntent);

    }






}
