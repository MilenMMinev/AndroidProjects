package com.hackbulgaria.milen.flappy;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import com.hackbulgaria.milen.flappy.GameClock;


public class Main extends Activity {
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        makeFullScreen();

        final DrawingView drawingView = new DrawingView(this);

        drawingView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawingView.onClickEvent();

            }
        });

        GameClock gameClock = new GameClock();
        gameClock.subscribe(drawingView);

        setContentView(drawingView);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mp.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMusic();
    }

    private void makeFullScreen() {
        getActionBar().hide();
        getWindow().getDecorView().setSystemUiVisibility(
                  View.SYSTEM_UI_FLAG_IMMERSIVE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

    private void setUpMusic() {
        mp = MediaPlayer.create(this, R.raw.prey_overture);
        mp.start();
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
            }
        });
    }

}
