package com.example.eagletest.eaglething;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;

/**
 * Created by Shabalab on 2017-07-06.
 */

public class MyImage {

    private Bitmap img;
    private Matrix matrix;
    private float scale, translateX, translateY, rotation;

    //pull asdfalsdkfj
    //asdjfasldkfjlkjsadfj


    public MyImage(int id, Resources res) {
        img = BitmapFactory.decodeResource(res, id);
        matrix = new Matrix();
    }

    public void draw(Canvas canvas){
        matrix.setTranslate(-img.getWidth()/2, -img.getHeight()/2); //translate to center
        matrix.postScale(scale, scale);
        matrix.postRotate(rotation); //USING POST MEANS THAT THE ORDER IS CORRECT: this code rotates, then translates
        matrix.postTranslate(translateX, translateY);
        canvas.drawBitmap(img, matrix, null);
    }

    public void setSize(float size) {
        if (img.getWidth() > img.getHeight()) {
            scale = size / img.getWidth();
        } else {
            scale = size / img.getHeight();
        }
    }

    public void setTranslateX(float x){
        translateX = x;
    }

    public void setTranslateY(float y) {
        translateY = y;
    }

    public void setRotation(float rot) {
        rotation = rot;
    }
}
