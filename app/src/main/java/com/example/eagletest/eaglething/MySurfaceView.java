package com.example.eagletest.eaglething;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Jason Lee on 2017-07-06.
 * hello hello testing testing
 */

public class MySurfaceView extends SurfaceView implements  Runnable{
    private Paint paint;
    private SurfaceHolder surfaceHolder;
    private Thread gameThread;
    public volatile boolean isRunning;

    //private Bitmap myChar;
    private MyImage myChar;
    float x = 0;

    public MySurfaceView(Context context) {
        super(context);
        surfaceHolder = getHolder();
        paint = new Paint();
        myChar = new MyImage(R.drawable.greencircle, getResources());
        myChar.setSize(200);
        myChar.setRotation(0);
        myChar.setTranslateY(100);
        myChar.setTranslateX(100);
    }
    public void pause(){
        isRunning = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void resume(){
        isRunning = true;
        gameThread = new Thread(this);
        gameThread.start();
    }



    /**
     * Had to name it something other than "draw" to avoid conflict
     * **/
    private void render(){
        //checking if surface is valid
        if (surfaceHolder.getSurface().isValid()) {
            //locking the canvas
            Canvas canvas = surfaceHolder.lockCanvas();
            //drawing a background color for canvas
            canvas.drawColor(Color.BLUE);
            myChar.setRotation(myChar.getRotation()+2);
            myChar.setTranslateX(myChar.getTranslateX()+3);
            myChar.draw(canvas);
            surfaceHolder.unlockCanvasAndPost(canvas);
        }

    }

    @Override
    public void run() {
        while(isRunning){

            try { //sleep to 60 fps
                render();
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
