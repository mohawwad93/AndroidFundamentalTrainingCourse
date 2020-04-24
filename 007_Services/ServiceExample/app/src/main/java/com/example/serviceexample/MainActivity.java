package com.example.serviceexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(new Intent(this, ToastService.class));
        }else{
            startService(new Intent(this, ToastService.class));
        }

//        new CountDownTimer(1000*60, 3000){
//            @Override
//            public void onTick(long millisUntilFinished) {
//                Toast.makeText(MainActivity.this, "Hi", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFinish() {
//                Toast.makeText(MainActivity.this, "Goodbye", Toast.LENGTH_SHORT).show();
//            }
//        }.start();

    }
}
