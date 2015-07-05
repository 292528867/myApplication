package com.example.yk.myapplication.EM;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.easemob.EMCallBack;
import com.easemob.chat.EMChat;
import com.easemob.chat.EMChatManager;
import com.example.yk.myapplication.R;

/**
 * Created by yk on 15/7/5.
 */
public class LoginActivity extends Activity implements View.OnClickListener{

    private EditText username;

    private EditText password;

    private Button  loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emlogin);
        //初始化环信的sdk
        EMChat.getInstance().init(getApplicationContext());
        initView();
    }


    private void initView() {
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loginButton:
                EMChatManager.getInstance().login(username.getText().toString(),password.getText().toString(),new EMCallBack() {
                    @Override
                    public void onSuccess() {
                        Intent intent = new Intent(LoginActivity.this,EmMainActivity.class );
                        startActivity(intent);
                    }

                    @Override
                    public void onError(int i, String s) {
                        Toast.makeText(getApplicationContext(), s,
                                Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onProgress(int i, String s) {

                    }
                });
        }
    }
}
