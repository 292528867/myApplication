package com.example.yk.myapplication.drawerLayout;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.example.yk.myapplication.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by yk on 15/8/9.
 */
public class DrawerLayoutActivity  extends Activity {

    @InjectView(R.id.drawer_Layout)
    DrawerLayout drawerLayout;



    @InjectView(R.id.left_drawer)
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_layout);
        ButterKnife.inject(this);


        String[] strings = {"test1","test2","test3","test4","test5","test6","test7"};

        listView.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_list_item, strings));
    }
}
