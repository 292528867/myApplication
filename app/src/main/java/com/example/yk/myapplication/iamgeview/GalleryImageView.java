package com.example.yk.myapplication.iamgeview;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Gallery;

import com.example.yk.myapplication.R;

public class GalleryImageView extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_image_view);

        Gallery gallery = (Gallery) findViewById(R.id.imageGallery);

        int[] imageids = {
                android.R.drawable.btn_minus,
                android.R.drawable.btn_radio,
                android.R.drawable.ic_lock_idle_low_battery,
                android.R.drawable.btn_radio,
                android.R.drawable.btn_dialog
        };

        gallery.setAdapter(new ImageAdapter(imageids,this));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_gallery_image_view, menu);
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
