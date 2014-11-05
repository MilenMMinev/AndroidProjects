package com.hackbulgaria.milen.drawablebrush;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by milen on 05.11.14.
 */
public class Brush {
    private List<PointF> points;
    private DrawingView view;
    private Bitmap bitmap;
    private Paint paint;
    private float x, y;

    public Brush(DrawingView view){
        paint = new Paint();
        this.view = view;
        points = new ArrayList<PointF>();
        bitmap = BitmapFactory.decodeResource(view.getContext().getResources(), R.drawable.cross);


    }

    public void setBitmap(Bitmap bitmap){
        this.bitmap = bitmap;
    }

    public void draw(Canvas canvas) {
                view.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        x = motionEvent.getX();
                        y = motionEvent.getY();
                        points.add(new PointF(x, y));
                        return true;
                    }
                });

                paint.setAlpha(100);
                for (PointF point : points)
                    canvas.drawBitmap(bitmap, point.x, point.y, paint);
    }

    private void toast(String message) {
        Toast t = Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT);
        t.show();
    }

}


