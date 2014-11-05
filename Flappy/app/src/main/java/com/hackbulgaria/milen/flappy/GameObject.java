package com.hackbulgaria.milen.flappy;

import android.graphics.Canvas;
import android.graphics.PointF;


public abstract class GameObject implements GameClock.GameClockListener{
    protected int x;
    protected int y;

    public abstract void draw(Canvas canvas);
    public abstract int getWidth();
    public abstract int getHeight();
    public abstract void onClick();
    public abstract void onGameEvent(GameEvent event);

    public PointF getPosition(){
        return new PointF(x, y);
    }


}
