package com.example.xuwanjin.servicedemo;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button startServiceBtn;
    Button bindServiceBtn;
    Button unbindServiceBtn;
    ServiceConnection mServiceConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startServiceBtn = findViewById(R.id.start_service);
        startServiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startServiceIntent = new Intent();
                startServiceIntent.setClass(getApplicationContext(), StartService.class);
                startService(startServiceIntent);
            }
        });

        bindServiceBtn = findViewById(R.id.bind_service);
        bindServiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ServiceConnection serviceConnection = new ServiceConnection() {
                    @Override
                    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

                        BindService.MyBinder myBinder = (BindService.MyBinder) iBinder;
                        BindService bindService = myBinder.getService();
                        bindService.getMethod();
                    }

                    @Override
                    public void onServiceDisconnected(ComponentName componentName) {

                    }
                };
                mServiceConnection = serviceConnection;

                Intent bindServiceIntent = new Intent();
                bindServiceIntent.setClass(getApplicationContext(), BindService.class);
                bindService(bindServiceIntent, serviceConnection, Context.BIND_AUTO_CREATE);
            }

        });


        unbindServiceBtn = findViewById(R.id.unbind_service);
        unbindServiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mServiceConnection != null) {
                    unbindService(mServiceConnection);
                }
            }
        });
    }
}
