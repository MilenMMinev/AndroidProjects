package com.hackbulgaria.milen.flappy;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.animation.DecelerateInterpolator;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;


public class Bird extends GameObject {
    private Bitmap bitmap;
    private DrawingView view;
    private int moveUpCounter;


    public Bird(Context context, int id, DrawingView drawingView) {
        super();
        moveUpCounter = 0;
        bitmap = BitmapFactory.decodeResource(context.getResources(), id);
        x = Settings.BIRD_START_X;
        y = Settings.BIRD_START_Y;
        view = drawingView;
    }

    @Override
    public void draw(final Canvas canvas) {

        canvas.drawBitmap(bitmap, x, y, null);

    }

    @Override
    public int getWidth() {
        return bitmap.getWidth();
    }

    @Override
    public int getHeight() {
        return bitmap.getHeight();
    }

    @Override
    public void onClick() {
        moveUpCounter = 0;
    }

    @Override
    public void onGameEvent(GameEvent event) {

        if(moveUpCounter <= 15)
            moveBirdUp();

        if (-y > bitmap.getHeight())
            y = bitmap.getHeight();

        if(y > Settings.DEVICE_HEIGHT - bitmap.getHeight()) {
            y = Settings.DEVICE_HEIGHT - bitmap.getHeight();
            // gameOver();
        }
        moveBirdDown();
    }

    private void moveBirdDown(){
        y = y + Settings.BIRD_FALL_SPEED;
    }


    private void moveBirdUp() {

        y = y - Settings.BIRD_JUMP_DISTANCE + moveUpCounter * 2;
        moveUpCounter += 1;
    }

}
