package com.example.xuwanjin.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by xuwanjin on 7/11/17.
 */

public class BindService extends Service {

    public MyBinder myBinder = new MyBinder();

    public void getMethod(){

        Toast.makeText(getApplicationContext(), "Bind Service", Toast.LENGTH_SHORT).show();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Toast.makeText(getApplicationContext(), "Unbind Service", Toast.LENGTH_SHORT).show();
        return super.onUnbind(intent);
    }

    class MyBinder extends Binder{
        public BindService getService(){

            return BindService.this;
        }
    }
}
