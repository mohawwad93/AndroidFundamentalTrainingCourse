package com.example.broadcastexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    AirPlaneReceiver airPlaneReceiver;
    LocalReceiver localReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        airPlaneReceiver = new AirPlaneReceiver();
        registerReceiver(airPlaneReceiver, intentFilter);

        localReceiver = new LocalReceiver();

        registerReceiver(localReceiver, new IntentFilter("com.example.broadcastexample.action.xyz"));

        sendBroadcast(new Intent("com.example.broadcastexample.action.xyz"));




    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this)
                .unregisterReceiver(localReceiver);
        unregisterReceiver(airPlaneReceiver);

    }
}
