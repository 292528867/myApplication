package com.example.yk.myapplication.RecyclerView;

import android.app.Activity;
import android.os.Bundle;

import com.example.yk.myapplication.R;

/**
 * Created by yk on 15/8/6.
 */
public class RecyclerViewActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction().replace(
                    R.id.container, RecyclerViewFragment.newInstance()
            ).commit();
        }
    }
}
