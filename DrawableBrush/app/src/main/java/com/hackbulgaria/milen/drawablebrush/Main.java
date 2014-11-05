package com.hackbulgaria.milen.drawablebrush;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;


public class Main extends Activity {
    private Bitmap bitmap;
    private Canvas drawCanvas;
    private MyView surface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getActionBar().hide();

        final RelativeLayout layout = (RelativeLayout) findViewById(R.id.main_layout);

        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.rocket);
        bitmap = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        drawCanvas = new Canvas(bitmap);
        surface = new MyView(this);
        surface.setBitmap(bitmap);
        surface.setCanvas(drawCanvas);


        surface.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                drawCanvas.drawBitmap(bitmap, x, y, null);
                surface.invalidate();
                return true;
            }
        });

        layout.addView(surface);
    }

}
