package com.example.serviceexample;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

public class ToastService extends Service {
    private static final String TAG = ToastService.class.getSimpleName();
    private static final String CHANNEL_ID = "normal";
    private NotificationManager mNotificationManager;

    public ToastService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notification = createNotification();

        startForeground(100, notification);

        Log.i(TAG, "onStartCommand");
        new CountDownTimer(1000*60, 3000){
            @Override
            public void onTick(long millisUntilFinished) {
                Toast.makeText(getApplicationContext(), "Hi", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFinish() {
                Toast.makeText(getApplicationContext(), "Goodbye", Toast.LENGTH_SHORT).show();
            }
        }.start();

        //stopForeground(true);

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.i(TAG, "onDestroy");
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private Notification createNotification(){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel =
                    new NotificationChannel(CHANNEL_ID, "Normal Notifications",
                            NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);
            notificationChannel.setDescription("Notification from normal category");
            mNotificationManager.createNotificationChannel(notificationChannel);
        }

        Intent i = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 111, i, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, CHANNEL_ID);
        Notification notification = mBuilder.setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("This is notification title")
                .setContentText("This is notification body")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .build();
        return notification;
    }
}
