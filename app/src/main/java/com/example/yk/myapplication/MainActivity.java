package com.example.yk.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.yk.myapplication.activity.ActivityDemo;
import com.example.yk.myapplication.imageupload.ImageUpload;
import com.example.yk.myapplication.service.HelloService;
import com.example.yk.myapplication.sharePreferences.SharePreferenceDemo;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {



    private ListView mainList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mainList = (ListView) findViewById(R.id.main_list);


//        TextView activityDemoClick = (TextView) findViewById(R.id.activityDemo);
//
//        activityDemoClick.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, ActivityDemo.class);
//                startActivity(intent);
//            }
//        });
      final  List<MainEntry> list = new ArrayList();
       /* Map<String, Object> map = new HashMap<>();
        map.put("acrivityDemo", ActivityDemo.class);
        Map<String, Object> map1 = new HashMap<>();
        map1.put("serviceDemo", HelloService.class);
        Map<String, Object> map2 = new HashMap<>();
        map2.put("UploadImage", ImageUpload.class);

        list.add(map);
        list.add(map1);
        list.add(map2);*/

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

        list.add(entry);
        list.add(entry1);
        list.add(entry2);
        list.add(entry3);
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

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == Activity.RESULT_OK) {
            String val = data.getExtras().getString("helloworld");
            Bundle bundle = data.getExtras();

            TextView textView = (TextView) findViewById(R.id.tvDisplay);
            textView.setText("来自activityc的值" + bundle.getString("hello"));

        }
    }


   /* @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
    }*/

}
