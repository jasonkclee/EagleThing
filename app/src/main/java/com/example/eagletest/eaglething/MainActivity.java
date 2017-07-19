package com.example.eagletest.eaglething;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {

    MySurfaceView mySurfaceView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        mySurfaceView = new MySurfaceView(this);
        mySurfaceView.setOnTouchListener(mySurfaceView);
        setContentView(mySurfaceView);
        //setContentView(R.layout.activity_main);
    }

    //pausing the game when activity is paused
    @Override
    protected void onPause() {
        super.onPause();
        mySurfaceView.pause();
    }

    //running the game when activity is resumed
    @Override
    protected void onResume() {
        super.onResume();
        mySurfaceView.resume();
    }
}
