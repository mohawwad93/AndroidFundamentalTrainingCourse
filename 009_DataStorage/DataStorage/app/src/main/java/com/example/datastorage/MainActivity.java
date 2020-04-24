package com.example.datastorage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    TextView colorTextView;
    private static final int WRITE_EXTERNAL_STORAGE_REQUEST_CODE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colorTextView = findViewById(R.id.colorTextView);
//        SharedPreferences sharedPreferences = getSharedPreferences("color_pref", MODE_PRIVATE);
//        SharedPreferences.Editor edit = sharedPreferences.edit();
//        edit.putString("color", "White");
//        edit.apply();

//        getSharedPreferences("color_pref", MODE_PRIVATE).edit().clear().apply();
//        getSharedPreferences("color_pref", MODE_PRIVATE).registerOnSharedPreferenceChangeListener(this);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    WRITE_EXTERNAL_STORAGE_REQUEST_CODE);

        }else{
            createWelcomeFileSharedStorage();
        }



    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String[] permissions, int[] grantResults) {
        switch (requestCode) {

            case WRITE_EXTERNAL_STORAGE_REQUEST_CODE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    createWelcomeFileSharedStorage();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request.
        }
    }


    private void createWelcomeFileSharedStorage(){
        String helloworld = "HelloWorld";
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_ALARMS), "welcome.txt");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(helloworld.getBytes());
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void createHelloWorldAppSpecific(){
        String helloworld = "HelloWorld";
        File file = new File(getExternalFilesDir(null), "welcome.txt");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(helloworld.getBytes());
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
     //   getSharedPreferences("color_pref", MODE_PRIVATE).unregisterOnSharedPreferenceChangeListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();

//        String color = getSharedPreferences("color_pref", MODE_PRIVATE).getString("color", "Red");
//        colorTextView.setText(color);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
 //       sharedPreferences.getString(key, "Red");
    }
}
