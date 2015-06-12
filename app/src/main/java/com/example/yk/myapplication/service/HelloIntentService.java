package com.example.yk.myapplication.service;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;
import android.widget.CursorTreeAdapter;

/**
 * Created by yk on 15/6/1.
 */
public class HelloIntentService extends IntentService {

    public HelloIntentService() {
        super("HelloIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        System.out.println("休息8秒");
        try {
            Thread.sleep(8000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return super.onBind(intent);
    }

    @Override
    public void onDestroy() {
        System.out.println("执行完onHandleIntent之后自动调用");
        super.onDestroy();
    }
}
