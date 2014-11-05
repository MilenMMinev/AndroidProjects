package com.hackbulgaria.milen.drawablebrush;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;



public class DrawingView extends ImageView{
    private Brush brush;

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

    public void setBrush(Brush brush){
        this.brush = brush;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        brush.draw(canvas);
        invalidate();
    }

    private void init(){
        brush = new Brush(this);
    }
}
