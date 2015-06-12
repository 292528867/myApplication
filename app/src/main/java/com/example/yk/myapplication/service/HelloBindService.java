package com.example.yk.myapplication.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

/**
 * Created by yk on 15/6/1.
 */
public class HelloBindService extends Service {

    private final IBinder mBinder = new LocalBinder();
    private String BOOKNAME = "开发入门";

    private int i = 1000;

    public class LocalBinder extends Binder {
        HelloBindService getService() {
            return HelloBindService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        System.out.println("成功绑定服务");
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        System.out.println(" 成功取消绑定服务");
        return super.onUnbind(intent);
    }

    public  String getName() {
        return BOOKNAME;
    }
}
