package com.hackbulgaria.milen.flappy;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Log;

public class Background extends GameObject {
    private Bitmap bitmap;

    Background(Context context, int id)
    {
        x = 0;
        y = 0;
        bitmap = BitmapFactory.decodeResource(context.getResources(), id);
        bitmap = bitmap.createScaledBitmap(bitmap, Settings.DEVICE_WIDTH, Settings.DEVICE_HEIGHT, false);
    }

    @Override
    public void draw(Canvas canvas) {
        Rect src, dst;

        if(-x > bitmap.getWidth()){
            x += bitmap.getWidth();
        }

        moveBackground();
        canvas.drawBitmap(bitmap, x, y, null);

    }

    @Override
    public int getWidth() {
        return getWidth();
    }

    @Override
    public int getHeight() {
        return getHeight();
    }

    @Override
    public void onClick() {

    }

    @Override
    public void onGameEvent(GameEvent event) {

    }

    private void moveBackground(){
        x = x - Settings.BACKGROUND_SPEED;
    }
}
