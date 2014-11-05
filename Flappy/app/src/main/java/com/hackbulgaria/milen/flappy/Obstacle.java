package com.hackbulgaria.milen.flappy;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Obstacle extends GameObject{

    public Obstacle(){
        super();
        x = 0;
        y = 0;
        spawn = true;
        counter = 0;
        count = 0;
        rect = new ArrayList<Rect>();
        rect.add(spawnObstacle());
        spawn = false;
        activeObstacle = rect.get(count);
    }

    private Paint paint;
    private boolean spawn;
    private List<Rect> rect;

    private int count;
    private int counter;
    private Rect activeObstacle;




    @Override
    public void draw(Canvas canvas) {
        if(spawn)
        {
           rect.add(spawnObstacle());
           spawn = false;
        }

        if(activeObstacle.right < Settings.BIRD_START_X + 64){
            count ++;
            activeObstacle = rect.get(count);
        }

        paint = new Paint();
        paint.setColor(Color.GREEN);


        for(Rect r : rect) {
            canvas.drawRect(r, paint);
            moveObstacle(r);
        }

        counter++;
        if(counter == 150)
        {
            spawn = true;
            counter = 0;
        }

    }

    @Override
    public int getWidth() {
        return activeObstacle.width();
    }

    @Override
    public int getHeight() {
        return activeObstacle.height();
    }

    public PointF getPosition(){return new PointF(activeObstacle.left, activeObstacle.top);}

    @Override
    public void onClick() {

    }

    @Override
    public void onGameEvent(GameEvent event) {

    }

    private Rect spawnObstacle(){
        Random random = new Random();

        int right, bottom;
        //Always at most right position
        x = Settings.DEVICE_WIDTH;
        right = x + Settings.OBSTACLE_WIDTH;

        if(random.nextBoolean())
        {
            y = 0;
            bottom = y + Settings.OBSTACLE_MIN_LENGTH + random.nextInt(Settings.OBSTACLE_MAX_LENGTH);
        }
        else
        {
            bottom = Settings.DEVICE_HEIGHT;
            y = bottom - Settings.OBSTACLE_MIN_LENGTH - random.nextInt(Settings.OBSTACLE_MAX_LENGTH);
        }

        Rect obstacle = new Rect(x, y, right, bottom);

    return obstacle;
    }

    private void moveObstacle(Rect r){
        r.offset(-1 * Settings.BACKGROUND_SPEED, 0);
    }

}
