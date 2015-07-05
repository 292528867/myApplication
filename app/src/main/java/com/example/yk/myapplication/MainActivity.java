package com.example.yk.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.yk.myapplication.EM.LoginActivity;
import com.example.yk.myapplication.Fragment.FragmentViewpagerActivity;
import com.example.yk.myapplication.activity.ActivityDemo;
import com.example.yk.myapplication.camera.CameraActivity;
import com.example.yk.myapplication.iamgeview.MixView;
import com.example.yk.myapplication.image.ImageUpload;
import com.example.yk.myapplication.image.ImageViewActivity;
import com.example.yk.myapplication.pageview.FragmentPagerSupportActivity;
import com.example.yk.myapplication.retrofit.RetrofitTest;
import com.example.yk.myapplication.service.HelloService;
import com.example.yk.myapplication.sharePreferences.SharePreferenceDemo;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity implements SwipeRefreshLayout.OnRefreshListener{


    private SwipeRefreshLayout mSwipeLayout;
    private ListView mainList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mainList = (ListView) findViewById(R.id.main_list);

      final  List<MainEntry> list = new ArrayList();

        MainEntry entry = new MainEntry();
        entry.setName(ActivityDemo.class);
        entry.setTitle("acrivityDemo");

        MainEntry entry1 = new MainEntry();
        entry1.setName(HelloService.class);
        entry1.setTitle("serviceDemo");

        MainEntry entry2 = new MainEntry();
        entry2.setName(ImageUpload.class);
        entry2.setTitle("UploadImage");

        MainEntry entry3 = new MainEntry();
        entry3.setName(SharePreferenceDemo.class);
        entry3.setTitle("sharePreferences");

        MainEntry entry4 = new MainEntry();
        entry4.setName(ImageViewActivity.class);
        entry4.setTitle("zoomImageView");

        MainEntry entry5 = new MainEntry();
        entry5.setName(CameraActivity.class);
        entry5.setTitle("camera");

        MainEntry entry6 = new MainEntry();
        entry6.setName(MixView.class);
        entry6.setTitle("mixView");

        MainEntry entry7 = new MainEntry();
        entry7.setName(SlidingMenuTest.class);
        entry7.setTitle("slidingmenu");

        MainEntry entry8 = new MainEntry();
        entry8.setName(RetrofitTest.class);
        entry8.setTitle("RetrofitTest");

        MainEntry entry9 = new MainEntry();
        entry9.setName(FragmentViewpagerActivity.class);
        entry9.setTitle("FragmentDemo");

        MainEntry entry10 = new MainEntry();
        entry10.setName(FragmentPagerSupportActivity.class);
        entry10.setTitle("pageview");

        MainEntry entry11 = new MainEntry();
        entry11.setName(LoginActivity.class);
        entry11.setTitle("emTest");

        list.add(entry);
        list.add(entry1);
        list.add(entry2);
        list.add(entry3);
        list.add(entry4);
        list.add(entry5);
        list.add(entry6);
        list.add(entry7);
        list.add(entry8);
        list.add(entry9);
        list.add(entry10);
        list.add(entry11);
//        String[] labels = {"activityDemo", "serviceDemo", "UploadImage"};



        MainAdapter myAdapter = new MainAdapter(this, list);

        mainList.setAdapter(myAdapter);

        mainList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.e("当前点击的是", "第" + position + "行");
                Log.e("当前要跳转的activity", "" + parent.getItemAtPosition(position));
               // MainEntry entry3 = list.get(position);
                MainEntry entry111 = (MainEntry) parent.getItemAtPosition(position);
                Intent intent = new Intent(MainActivity.this,entry111.getName());
                startActivity(intent);
            }
        });
        //this.setListAdapter(myAdapter);

        mSwipeLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_container);
        mSwipeLayout.setOnRefreshListener(this);
        mSwipeLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light, android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

    }


    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mSwipeLayout.setRefreshing(false);
            }
        }, 5000);
    }
}
