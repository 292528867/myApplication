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

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class SharePreferenceDemo extends Activity {

    @InjectView(R.id.name_edit)
    EditText nameEdit;

    @InjectView(R.id.age_edit)
    EditText ageEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_preference_demo);

        ButterKnife.inject(this);

    }


    @OnClick(R.id.saveParam)
    protected void saveParam() {
        SharedPreferences sharedPreferences = getSharedPreferences("test", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name", nameEdit.getText().toString());
        editor.putInt("age", Integer.parseInt(ageEdit.getText().toString()));
        editor.commit();
        Toast.makeText(SharePreferenceDemo.this, "保存成功", Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.resumeParam)
    protected void resumeParam() {
        SharedPreferences sharedPreferences = getSharedPreferences("test", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("name", "");
        int age = sharedPreferences.getInt("age", 20);
        nameEdit.setText(name);
        ageEdit.setText(String.valueOf(age));
    }

}
