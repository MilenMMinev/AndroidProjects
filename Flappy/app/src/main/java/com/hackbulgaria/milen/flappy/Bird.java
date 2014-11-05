package com.hackbulgaria.milen.flappy;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;


public class Bird extends GameObject {
    private Bitmap bitmap;
    private DrawingView view;


    public Bird(Context context, int id, DrawingView drawingView) {
        super();
        bitmap = BitmapFactory.decodeResource(context.getResources(), id);
        x = Settings.BIRD_START_X;
        y = Settings.BIRD_START_Y;
        view = drawingView;
    }

    @Override
    public void draw(final Canvas canvas) {

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveBirdUp();
            }
        });

        if (-y > bitmap.getHeight())
            y = bitmap.getHeight();

        if(y > Settings.DEVICE_HEIGHT - bitmap.getHeight()) {
            y = Settings.DEVICE_HEIGHT - bitmap.getHeight();
           // gameOver();
        }

        moveBirdDown();
        canvas.drawBitmap(bitmap, x, y, null);

    }

    private void gameOver() {
        Toast toast = Toast.makeText(view.getContext(), "Game Over", LENGTH_SHORT);
        toast.show();
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

    }

    @Override
    public void onGameEvent(GameEvent event) {

    }

    private void moveBirdDown(){
        int fallSpeed = Settings.FALL_SPEED;
        y = y + fallSpeed;
    }

    private void moveBirdUp() {
        y = y - Settings.BIRD_JUMP_DISTANCE;
    }

}
