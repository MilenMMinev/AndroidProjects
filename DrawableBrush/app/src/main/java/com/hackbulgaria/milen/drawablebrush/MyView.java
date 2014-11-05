package com.hackbulgaria.milen.drawablebrush;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;


public class MyView extends View {
    private Paint paint;
    private Bitmap bitmap;
    private Canvas drawCanvas;

    public MyView(Context context){
        super(context);

    }

    public MyView(Context context, AttributeSet attributeSet)
    {
        super(context, attributeSet);
    }

    public MyView(Context context, AttributeSet attrs, int defStyle){
        super(context, attrs, defStyle);
    }

    public void setBitmap(Bitmap b){
        bitmap = b;
    }

    public void setCanvas(Canvas c){
        drawCanvas = c;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint = new Paint();
        paint.setAlpha(200);
        canvas.drawBitmap(bitmap, 50, 200, paint);
        Log.v("a", "s");
    }
}
