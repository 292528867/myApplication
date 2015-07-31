package com.example.yk.myapplication.EM;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.easemob.chat.EMChatManager;
import com.easemob.chat.EMConversation;
import com.easemob.chat.EMMessage;
import com.example.yk.myapplication.EM.module.Message;
import com.example.yk.myapplication.EM.module.Result;
import com.example.yk.myapplication.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.mime.TypedByteArray;
import retrofit.mime.TypedInput;

/**
 * Created by yk on 15/7/6.
 */
public class FreeActivity extends Activity {

    private EditText message_free;
    private Button message_free_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.free_question);

        //注册群聊监听
     //   EMGroupManager.getInstance().addGroupChangeListener(new MyGroupChangeListener());


        SharedPreferences sharedPreferences = getSharedPreferences("user", Context.MODE_PRIVATE);
        final String username = sharedPreferences.getString("username", "");
        final String groupId = sharedPreferences.getString("groupId", "");

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://172.16.77.177:8080")
                .build();

      final   DoctorService doctorService = restAdapter.create(DoctorService.class);

    /*   //从数据库中加载历史纪录
       Map<String, Object> filters = new HashMap<>();
        filters.put("fromUser_equal", username);
        doctorService.findAllByUser(filters,new Callback<List<EmMessage>>() {
            @Override
            public void success(List<EmMessage> list, Response response) {
                Toast.makeText(getApplicationContext(),"success",Toast.LENGTH_LONG).show();
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(getApplicationContext(),"failure",Toast.LENGTH_LONG).show();
            }
        });*/

//        EmMessage emMessage = doctorService.findOne(130);

        message_free = (EditText) findViewById(R.id.message_free);
        message_free_send = (Button) findViewById(R.id.message_free_send);

        message_free_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                Message message = new Message();

                Message.MsgEntity msgEntity = message.new MsgEntity() ;
                msgEntity.setMsg(message_free.getText().toString());
                msgEntity.setType("text");

                message.setTarget_type("chatgroups");
                List list = new ArrayList();
                list.add(groupId);
                //聊天室名称
                message.setTarget(list);
                message.setFrom(username);
                message.setMsg(msgEntity);


              /*  Map<String,Object> msg = new HashMap();
                msg.put("msg", "11111111");
                msg.put("type", "text");

                Map<String,Object> params = new HashMap();
                params.put("target_type", "users");
                params.put("target", "[\"qiuqiu\"]");
                params.put("msg", msg);
                params.put("from", "lixuanwu");*/

                Gson json = new Gson();
                 String messageJson = json.toJson(message);
                TypedInput in = null;
                try {
                    in = new TypedByteArray("application/json", messageJson.getBytes("UTF-8"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                doctorService.sendMessage(in,new Callback<Result>() {
                    @Override
                    public void success(Result result, Response response) {
                        Toast.makeText(FreeActivity.this, "success", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Toast.makeText(FreeActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();

                    }
                });

            }
        });


    }






    //注册接收新消息的监听广播
    private  void initListter22(){
        //只有注册了广播才能接收到新消息，目前离线消息，在线消息都是走接收消息的广播（离线消息目前无法监听，在登录以后，接收消息广播会执行一次拿到所有的离线消息）
        NewMessageBroadcastReceiver msgReceiver = new NewMessageBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter(EMChatManager.getInstance().getNewMessageBroadcastAction());
        intentFilter.setPriority(3);
        registerReceiver(msgReceiver, intentFilter);

    }

    private class NewMessageBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            // 注销广播
            abortBroadcast();

            // 消息id（每条消息都会生成唯一的一个id，目前是SDK生成）
            String msgId = intent.getStringExtra("msgid");
            //发送方
            String username = intent.getStringExtra("from");
            // 收到这个广播的时候，message已经在db和内存里了，可以通过id获取mesage对象
            EMMessage message = EMChatManager.getInstance().getMessage(msgId);
            Log.e("接收的信息", message.toString());
            Toast.makeText(getApplicationContext(),message.toString(),Toast.LENGTH_LONG).show();
            EMConversation conversation = EMChatManager.getInstance().getConversation(username);
            // 如果是群聊消息，获取到group id
            if (message.getChatType() == EMMessage.ChatType.GroupChat) {
                username = message.getTo();

            }
            if (!username.equals(username)) {
                // 消息不是发给当前会话，return
                return;
            }
        }
    }

}
