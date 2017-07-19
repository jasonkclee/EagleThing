package com.example.eagletest.eaglething;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by Jason Lee on 2017-07-19.
 */

public class Box {
    private float minX, minY, maxX, maxY;
    private float width, height;
    private int r, g, b;
    public Box(float minX, float minY, float maxX, float maxY){
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
        width = Math.abs(maxX - minX);
        height = Math.abs(maxY - minY);
        r = 0;
        g = 255;
        b = 0;
    }

    public void setRgb(int r, int g, int b){
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public void updateCenterX(float centerX){
        minX = centerX - width/2;
        maxX = centerX + width/2;
    }

    public void updateCenterY(float centerY){
        minY = centerY - height/2;
        maxY = centerY + height/2;
    }

    public void draw(Canvas canvas){
        Paint paint = new Paint();
        //paint.setARGB(r, g, b, 0);
        paint.setARGB(255, r, g, b);
        canvas.drawRect(minX, maxY, maxX, minY, paint);
    }

    public float getCenterX(){return (minX + maxX)/2;}
    public float getCenterY(){return  (minY + maxY)/2;}
    public float getWidth(){return  Math.abs(maxX - minX);}

    /**Returns if this box intersects the given box**/
    public boolean intersects(Box box){
        float dx = Math.abs(getCenterX() - box.getCenterX());
        float dy = Math.abs(getCenterY() - box.getCenterY());
        return dx < width/2 + box.width/2&&
                dy < height/2 + box.height/2;
    }
}
