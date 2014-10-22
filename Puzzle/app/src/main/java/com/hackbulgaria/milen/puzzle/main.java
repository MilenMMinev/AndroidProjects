package com.hackbulgaria.milen.puzzle;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class main extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        makeFullScreen();

        final GridLayout masterParent = (GridLayout) findViewById(R.id.main_layout);

        TypedArray pieces = getResources().obtainTypedArray(R.array.pieces);
        List<Drawable> orderedPieces = obtainDrawables(pieces);
        List<Drawable> shuffledPieces = obtainDrawables(pieces);
        Collections.shuffle(shuffledPieces);

        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
        final GridLayout gl = new GridLayout(this);

        gl.setLayoutParams(params);
        gl.setColumnCount(4);
        gl.setRowCount(4);
        masterParent.addView(gl);

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++)
            {
                final ImageView imageView = new ImageView(this);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setPadding(1,1,1,1);
                ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(1920/4, 1080/4);
                imageView.setImageDrawable(shuffledPieces.get(i*4+j));
                imageView.setLayoutParams(lp);
                imageView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        View.DragShadowBuilder builder = new View.DragShadowBuilder(view);
                        imageView.startDrag(null, builder, imageView, 0);
                        return false;
                    }
                });
                imageView.setOnDragListener(new View.OnDragListener() {
                    @Override
                    public boolean onDrag(View view, DragEvent dragEvent) {
                        if (dragEvent.getAction() == DragEvent.ACTION_DROP) {

                            ImageView dragSource = (ImageView) dragEvent.getLocalState();

                            Drawable temp = dragSource.getDrawable();
                            ObjectAnimator animSourceX = new ObjectAnimator().ofFloat(dragSource, "x", imageView.getX());
                            ObjectAnimator animSourceY = new ObjectAnimator().ofFloat(dragSource, "y", imageView.getY());
                            float x = dragSource.getX();
                            float y = dragSource.getY();
                            animSourceX.start();
                            animSourceY.start();
                            ObjectAnimator animEnteredX = new ObjectAnimator().ofFloat(imageView, "x",x);
                            ObjectAnimator animEnteredY = new ObjectAnimator().ofFloat(imageView, "y",y);
                            animEnteredX.start();
                            animEnteredY.start();
                        }
                        return true;
                    }
                });
                gl.addView(imageView);
        }
    }
}
    private void makeFullScreen() {
        getActionBar().hide();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_IMMERSIVE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

    private List<Drawable> obtainDrawables(TypedArray array){
        List<Drawable> drawables = new ArrayList<Drawable>();
        for(int i = 0; i < 16; i++)
            drawables.add(array.getDrawable(i));
        return drawables;
    }



}
