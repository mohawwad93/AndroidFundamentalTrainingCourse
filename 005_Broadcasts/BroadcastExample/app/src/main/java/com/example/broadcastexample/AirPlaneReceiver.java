package com.example.broadcastexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AirPlaneReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        boolean isAirplaneModeOn = intent.getBooleanExtra("state", false);
        if(isAirplaneModeOn){
            Toast.makeText(context, "Airplane Mode on", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Airplane Mode off", Toast.LENGTH_SHORT).show();
        }
    }


}
