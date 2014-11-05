package com.hackbulgaria.milen.drawablebrush;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RelativeLayout;


public class Main extends Activity {
    private DrawingView drawView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getActionBar().hide();

        final RelativeLayout layout = (RelativeLayout) findViewById(R.id.main_layout);
        drawView = new DrawingView(this);

        layout.addView(drawView);
    }

}
