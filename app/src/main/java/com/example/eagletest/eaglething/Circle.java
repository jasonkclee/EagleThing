package com.example.eagletest.eaglething;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by Jason Lee on 2017-07-09.
 */

public class Circle {
    private float radius;
    private float x, y;

    public Circle(float radius, float x, float y){
        this.radius = radius;
        this.x = x;
        this.y = y;
    }

    public void draw(Canvas canvas){
        Paint paint = new Paint();
        paint.setARGB(255, 255, 0, 0);
        canvas.drawCircle(x, y, radius, paint);
    }

    public boolean isIntersecting(Circle circle){
        float dx = x - circle.x;
        float dy = y - circle.y;
        float distanceSquared = (radius+circle.radius)*(radius+circle.radius);
        return dx * dx + dy * dy <= distanceSquared;
    }

    public float getRadius(){return  radius;}
    public float getX(){return  x;}
    public float getY() {
        return y;
    }
    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }
}
