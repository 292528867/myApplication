package com.example.yk.myapplication.EM;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.yk.myapplication.R;

/**
 * Created by yk on 15/7/5.
 */
public class EmMainActivity extends Activity implements View.OnClickListener{

    private Button freeButton;

    private Button findDoctorButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.em_main);

        freeButton = (Button) findViewById(R.id.free);
        freeButton.setOnClickListener(this);
        findDoctorButton = (Button) findViewById(R.id.findDoctor);
        findDoctorButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.free:
                //跳到免费提问接口
                Intent intent1 = new Intent(EmMainActivity.this,FreeActivity.class);
                startActivity(intent1);
                break;
            case R.id.findDoctor:
                //跳到医生列表接口
                Intent intent = new Intent(EmMainActivity.this, DoctorActivity.class);
                startActivity(intent);
                break;
        }
    }
}
