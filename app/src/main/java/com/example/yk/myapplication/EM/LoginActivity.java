package com.example.yk.myapplication.EM;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.easemob.EMCallBack;
import com.easemob.EMEventListener;
import com.easemob.EMNotifierEvent;
import com.easemob.chat.EMChat;
import com.easemob.chat.EMChatManager;
import com.easemob.chat.EMGroup;
import com.easemob.chat.EMGroupManager;
import com.easemob.chat.EMMessage;
import com.easemob.chat.TextMessageBody;
import com.easemob.exceptions.EaseMobException;
import com.example.yk.myapplication.R;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by yk on 15/7/5.
 */
public class LoginActivity extends Activity {

    private EditText username;

    private EditText password;

    private Button  loginButton;

    private Button loginOutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emlogin);
        //初始化环信的sdk
        EMChat.getInstance().init(getApplicationContext());

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        loginButton = (Button) findViewById(R.id.loginButton);
        loginOutButton = (Button) findViewById(R.id.loginOut);

        //点击登录
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EMChatManager.getInstance().login(username.getText().toString(),password.getText().toString(),new EMCallBack() {
                                        @Override
                                        public void onSuccess() {
                                            runOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    String groupId = "";
                                                    // 从本地数据库加载群组到内存的操作
                                                    EMGroupManager.getInstance().loadAllGroups();
                                                    //从本地数据库加载聊天记录到内存的操作(强烈建议在每次进入应用的时候调用)
                                                    EMChatManager.getInstance().loadAllConversations();

                                                         ////从本地加载群聊列表
                                                    List<EMGroup> groupList = EMGroupManager.getInstance().getAllGroups();


                                //创建一个群聊时   在app上最好注册的时创建
                                if (groupList.size() == 0) {
                                    String[] s = {};
                                    try {
                                        EMGroupManager.getInstance().createPrivateGroup(username.getText().toString() + "chartroom", "", s, false);
                                        groupId = EMGroupManager.getInstance().getAllGroups().get(0).getGroupId();
                                    } catch (EaseMobException e) {
                                        e.printStackTrace();
                                    }
                                }else {
                                    groupId = groupList.get(0).getGroupId();
                                }

                                //注册接收新消息的监听广播
                                                    initLister11();



                                //保存用户名 并跳转到首页
                                SharedPreferences sharedPreferences = getSharedPreferences("user", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putString("username", username.getText().toString());
                                editor.putString("groupId", groupId);
                                editor.commit();

                                Intent intent = new Intent(LoginActivity.this, EmMainActivity.class);
                                startActivity(intent);
                            }
                        });


                    }

                    @Override
                    public void onError(int i, String s) {
                       /* Toast.makeText(getApplicationContext(), s,
                                Toast.LENGTH_SHORT).show();*/
                        Log.e("登陆失败",s);
                    }

                    @Override
                    public void onProgress(int i, String s) {
                        Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

       //点击退出
        loginOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 EMChatManager.getInstance().logout(new EMCallBack() {
                     @Override
                     public void onSuccess() {
                         Toast.makeText(getApplicationContext(),"logout success",Toast.LENGTH_SHORT).show();
                     }

                     @Override
                     public void onError(int i, String s) {

                     }

                     @Override
                     public void onProgress(int i, String s) {

                     }
                 });
            }
        });

    }


    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(android.os.Message msg) {
            Toast.makeText(getApplicationContext(),msg.getData().getString("msg"),Toast.LENGTH_LONG).show();

            return false;
        }
    });


    public void initLister11(){
        EMChatManager.getInstance().registerEventListener(new EMEventListener() {

            @Override
            public void onEvent(EMNotifierEvent event) {

                switch (event.getEvent()) {
                    case EventNewMessage: // 接收新消息
                    {
                        EMMessage message = (EMMessage) event.getData();
                        Bundle data = new Bundle();
                        Log.e("雷心态", message.getBody().getClass().toString());
                        try {
                            data.putString("msg", new String(((TextMessageBody) message.getBody()).getMessage().getBytes(),"UTF-8"));
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                        android.os.Message msg = new android.os.Message();
                        msg.setData(data);
                        handler.sendMessage(msg);
                        break;
                    }
                    case EventDeliveryAck:{//接收已发送回执

                        break;
                    }

                    case EventNewCMDMessage:{//接收透传消息

                        break;
                    }

                    case EventReadAck:{//接收已读回执

                        break;
                    }

                    case EventOfflineMessage: {//接收离线消息
                        List<EMMessage> messages = (List<EMMessage>) event.getData();
                        break;
                    }

                    case EventConversationListChanged: {//通知会话列表通知event注册（在某些特殊情况，SDK去删除会话的时候会收到回调监听）

                        break;
                    }

                    default:
                        break;
                }
            }
        });

    }



}
