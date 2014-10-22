package com.hackbulgaria.milen.animations;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;


public class main extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final ImageView imageView = (ImageView) findViewById(R.id.picture);

        final Animator anim = ObjectAnimator.ofFloat(imageView, "x", 600);
        final Animator animy = ObjectAnimator.ofFloat(imageView, "y", 600);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                anim.start();
                animy.start();
            }
        });

    }


}
