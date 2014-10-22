package com.hackbulgaria.milen.gestureimage;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;


public class main extends Activity {
    private float mLastx;
    private float mLasty;
    private ImageView imageView;

    private float scale = 1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getActionBar().hide();

        imageView = (ImageView) findViewById(R.id.image);

        final ScaleGestureDetector scaleDetector;
        scaleDetector = new ScaleGestureDetector(this, new ScaleListener());


        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                scaleDetector.onTouchEvent(motionEvent);
                int action = motionEvent.getActionMasked();

                switch (action){

                    case MotionEvent.ACTION_DOWN:{

                        final float x = motionEvent.getRawX();
                        final float y = motionEvent.getRawY();
                        mLastx = x - imageView.getX();
                        mLasty = y - imageView.getY();
                        Log.v("First Pointer:", "fp:"+x+" y:"+y);
                        break;
                    }

                    case MotionEvent.ACTION_POINTER_DOWN:{


                        break;
                    }

                    case MotionEvent.ACTION_MOVE:{
                        final float x;
                        final float y;


                            x = motionEvent.getRawX();
                            y = motionEvent.getRawY();

                        final float dx = x - mLastx;
                        final float dy = y - mLasty;

                        imageView.setTranslationX(dx);
                        imageView.setTranslationY(dy);
                    }

                }
                return true;
            }
        });
    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {

        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            scale *= detector.getScaleFactor();

            imageView.setScaleX(scale);
            imageView.setScaleY(scale);
            return true;
        }
    }
}
