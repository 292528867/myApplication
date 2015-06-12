package com.example.yk.myapplication.sharePreferences;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yk.myapplication.R;

public class SharePreferenceDemo extends Activity {

    EditText nameEdit =null;
    EditText ageEdit = null;
    Button saveButton = null;
    Button resumeButton = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_preference_demo);

         nameEdit = (EditText) findViewById(R.id.name_edit);
         ageEdit = (EditText) findViewById(R.id.age_edit);
         saveButton = (Button) findViewById(R.id.saveParam);
         resumeButton = (Button) findViewById(R.id.resumeParam);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("test", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name", nameEdit.getText().toString());
                editor.putInt("age", Integer.parseInt(ageEdit.getText().toString()));
                editor.commit();
                Toast.makeText(SharePreferenceDemo.this, "保存成功", Toast.LENGTH_LONG).show();
            }
        });

        resumeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("test", Context.MODE_PRIVATE);
                String name = sharedPreferences.getString("name", "");
                int age = sharedPreferences.getInt("age", 20);
                nameEdit.setText(name);
                ageEdit.setText(String.valueOf(age));
            }
        });
    }



}
