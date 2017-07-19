package com.example.eagletest.eaglething;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

/**
 * Created by Jason Lee on 2017-07-06.
 * hello hello testing testing
 */

public class MySurfaceView extends SurfaceView implements  Runnable, View.OnTouchListener{
    private Paint paint;
    private SurfaceHolder surfaceHolder;
    private Thread gameThread;
    public volatile boolean isRunning;

    Box box, box2;
    MyImage fish;
    public MySurfaceView(Context context) {
        super(context);
        surfaceHolder = getHolder();
        paint = new Paint();
        box = new Box(30, 30, 190, 190);
        box2 = new Box(90, 90, 190 , 190);
        fish = new MyImage(R.drawable.fish, getResources());
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
            Canvas canvas = surfaceHolder.lockCanvas(); //lock canvas
            canvas.drawColor(Color.WHITE);

            box2.draw(canvas);
            if(box.intersects(box2)){
                box.setRgb(255, 0, 0);
            }
            else{
                box.setRgb(0, 255, 0);
            }
            box.draw(canvas);

            fish.setSize(box.getWidth()-15);
            fish.setTranslateX(box.getCenterX());
            fish.setTranslateY(box.getCenterY());
            fish.draw(canvas);
            surfaceHolder.unlockCanvasAndPost(canvas); //unlock canvas and draw
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


    /**
     * Called when a touch event is dispatched to a view. This allows listeners to
     * get a chance to respond before the target view.
     *
     * @param v     The view the touch event has been dispatched to.
     * @param event The MotionEvent object containing full information about
     *              the event.
     * @return True if the listener has consumed the event, false otherwise.
     */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int x = (int)event.getX();
        int y = (int)event.getY();
        box.updateCenterX(x);
        box.updateCenterY(y);
        return false;
    }
}
