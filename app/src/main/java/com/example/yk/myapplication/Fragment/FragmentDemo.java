package com.example.yk.myapplication.Fragment;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;

import com.example.yk.myapplication.R;

public class FragmentDemo extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_demo);
        Display display = getWindowManager().getDefaultDisplay();
     /*   if (display.getWidth()>display.getHeight()) {
            Fragment1 fragment1 = new Fragment1();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, fragment1).commit();
        }
        if (display.getWidth()<display.getHeight()) {
            Fragment2 fragment2 = new Fragment2();
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, fragment2).commit();
        }*/
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_fragment_demo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
