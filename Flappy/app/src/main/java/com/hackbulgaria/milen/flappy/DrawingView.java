package com.hackbulgaria.milen.flappy;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class DrawingView extends ImageView implements GameClock.GameClockListener {
    private Bird bird;
    private Background background;
    private Obstacle obstacle;

    @Override
    public void onGameEvent(GameEvent gameEvent) {
        bird.onGameEvent(gameEvent);
        background.onGameEvent(gameEvent);
        obstacle.onGameEvent(gameEvent);
        if (collision(bird, obstacle))
        {
            gameOver();
        }
            invalidate();
    }


    public void onClickEvent(){
        bird.onClick();
    }

    public DrawingView(Context context) {
        super(context);
        init();
    }

    public DrawingView(Context context, AttributeSet attrs) {

        super(context, attrs);
        init();
    }

    public DrawingView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        obstacle = new Obstacle();
        background = new Background(this.getContext(), Settings.BACKGROUND_IMAGE_ID);
        bird = new Bird(this.getContext(), Settings.BIRD_IMAGE_ID, this);
    }

    private void gameOver() {
        Toast toast = Toast.makeText(getContext(), "Game Over", LENGTH_SHORT);
        toast.show();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        background.draw(canvas);
        bird.draw(canvas);
        obstacle.draw(canvas);

        super.onDraw(canvas);
    }

    private boolean collision(Bird bird, Obstacle obstacle) {
        if (obstacle.getPosition().y == 0) // Obstacle spawned at the top
            if (bird.getPosition().y < obstacle.getHeight() &&
                    bird.getPosition().x + bird.getWidth() >= obstacle.getPosition().x)
                return true;

        if (obstacle.getPosition().y != 0) //Obstacle spawned at the bottom
            if (bird.getPosition().y >= (Settings.DEVICE_HEIGHT - obstacle.getHeight()) &&
                    bird.getPosition().x + bird.getWidth() >= obstacle.getPosition().x)
                return true;
        return false;
    }
}