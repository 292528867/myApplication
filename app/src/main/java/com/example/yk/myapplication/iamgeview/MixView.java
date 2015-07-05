package com.example.yk.myapplication.iamgeview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.yk.myapplication.R;

public class MixView extends Activity {

    final   int[] images = {
            R.drawable.logged_in,
            R.drawable.play_video,
            R.drawable.record,
            R.drawable.tab2,
            R.drawable.text
    };

    int currentImg = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mix_view);


        LinearLayout main = (LinearLayout) findViewById(R.id.root);

       final ImageView imageView = new ImageView(this);

        main.addView(imageView);

        imageView.setImageResource(images[0]);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentImg >= (images.length-1))
                {
                    currentImg = -1;
                }
                //改变ImageView里显示的图片
                imageView.setImageResource(images[++currentImg]);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mix_view, menu);
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
