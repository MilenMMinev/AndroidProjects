package com.hackbulgaria.projects.flags;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class Flags extends Activity {
    private int color_counter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medium_flag);
     //   setContentView(R.layout.easy_flag);
     //   setContentView(R.layout.easy_flag_italy);

    }


    public void changeColor(View v){
        int[] colors = getResources().getIntArray(R.array.rainbow);
        if(color_counter == colors.length)
            color_counter = 0;
        v.setBackgroundColor(colors[this.color_counter]);
        this.color_counter++;

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.flags, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
