package com.example.eagletest.eaglething;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    MySurfaceView mySurfaceView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mySurfaceView = new MySurfaceView(this);
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
