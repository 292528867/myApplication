package com.example.yk.myapplication;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;

import com.example.yk.myapplication.Fragment.SampleListFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;


public class SlidingMenuTest extends FragmentActivity {

    private SlidingMenu slidingMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sliding_menu);

        slidingMenu = new SlidingMenu(this);
        slidingMenu.setMode(SlidingMenu.LEFT);
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
      /*  slidingMenu.setFadeDegree(0.35f);
        slidingMenu.setBehindOffsetRes(R.dimen.slidingmenu);
        slidingMenu.setBehindWidth(R.dimen.sliding_width);
        slidingMenu.setMenu(R.layout.activity_sliding_menu);
        slidingMenu.attachToActivity(this,SlidingMenu.SLIDING_CONTENT);*/

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, new SampleListFragment())
                .commit();


    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_MENU:
              //  slidingMenu.toggle(true);
                break;

            default:
                break;
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sliding_menu, menu);
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
