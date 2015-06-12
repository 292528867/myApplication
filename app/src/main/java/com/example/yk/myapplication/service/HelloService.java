package com.example.yk.myapplication.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by yk on 15/6/1.
 */
public class HelloService extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("启动service，休眠10秒");
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
