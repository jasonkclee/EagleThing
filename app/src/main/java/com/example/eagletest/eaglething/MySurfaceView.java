package com.example.eagletest.eaglething;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Jason Lee on 2017-07-06.
 * hello hello testing testing
 */

public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    public MySurfaceView(Context context) {
        super(context);
        SurfaceHolder surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);
        myChar = BitmapFactory.decodeResource(getResources(), R.drawable.greencircle);
    }

    private Bitmap myChar;
    @Override
    protected void onDraw(Canvas canvas){
        canvas.drawColor(Color.BLUE);


        Matrix matrix = new Matrix();

        /*
        Image img = new Image(R.drawable.greencircle, getResources());

        img.setSize(canvas.getWidth()/4);
        img.setRotation(90);
        img.setTRanl
        img.draw(canvas);
        */

        matrix.setTranslate(-myChar.getWidth()/2, -myChar.getHeight()/2); //translate to center
        matrix.postScale(0.5f, 0.5f);
        matrix.postRotate(30); //USING POST MEANS THAT THE ORDER IS CORRECT: this code rotates, then translates
        matrix.postTranslate(canvas.getWidth()/2, canvas.getHeight()/2);
        //matrix.postTranslate(canvas.getWidth()-myChar.getWidth()/2*0.5f, canvas.getHeight() - myChar.getHeight()/2 * 0.5f);
        canvas.drawBitmap(myChar, matrix, null);
    }

    /**
     * This is called immediately after the surface is first created.
     * Implementations of this should start up whatever rendering code
     * they desire.  Note that only one thread can ever draw into
     * a {@link Surface}, so you should not draw into the Surface here
     * if your normal rendering will be in another thread.
     *
     * @param holder The SurfaceHolder whose surface is being created.
     */
    @SuppressLint("WrongCall")
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Canvas canvas = holder.lockCanvas(null);
        onDraw(canvas);
        holder.unlockCanvasAndPost(canvas);
    }

    /**
     * This is called immediately after any structural changes (format or
     * size) have been made to the surface.  You should at this point update
     * the imagery in the surface.  This method is always called at least
     * once, after {@link #surfaceCreated}.
     *
     * @param holder The SurfaceHolder whose surface has changed.
     * @param format The new PixelFormat of the surface.
     * @param width  The new width of the surface.
     * @param height The new height of the surface.
     */
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    /**
     * This is called immediately before a surface is being destroyed. After
     * returning from this call, you should no longer try to access this
     * surface.  If you have a rendering thread that directly accesses
     * the surface, you must ensure that thread is no longer touching the
     * Surface before returning from this function.
     *
     * @param holder The SurfaceHolder whose surface is being destroyed.
     */
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
