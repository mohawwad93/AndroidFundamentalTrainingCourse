package com.example.backgroundprocessingsample;

import androidx.appcompat.app.AppCompatActivity;


import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {

    private static final String URL = "https://www.w3.org/TR/PNG/iso_8859-1.txt";

    private TextView textView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textview);
        progressBar = findViewById(R.id.progressBar);

        //versionOne();
        //versionTwo();

        getLoaderManager().initLoader(0, null, this);
    }

    @Override
    public Loader<String> onCreateLoader(int id, Bundle args) {

        progressBar.setVisibility(View.VISIBLE);
        textView.setText("");

        return new StringLoader(this, URL);
    }

    @Override
    public void onLoadFinished(Loader<String> loader, String data) {

        progressBar.setVisibility(View.GONE);
        textView.setText(data);
    }

    @Override
    public void onLoaderReset(Loader<String> loader) {
        textView.setText("");
    }


    class DownloadFileTask extends AsyncTask<String, Integer, String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressBar.setVisibility(View.VISIBLE);
            textView.setText("");
        }

        @Override
        protected String doInBackground(String... strings) {

            final String text = InternetUtils.downloadFile(strings[0]);
            return text;
        }

        @Override
        protected void onPostExecute(String text) {
            super.onPostExecute(text);

            progressBar.setVisibility(View.GONE);
            textView.setText(text);
        }
    }

    private void versionOne(){
        Thread worker = new Thread(new Runnable() {
            @Override
            public void run() {

                final String text = InternetUtils.downloadFile(URL);
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setVisibility(View.GONE);
                        textView.setText(text);
                    }
                });
            }
        });
        progressBar.setVisibility(View.VISIBLE);
        textView.setText("");
        worker.start();
    }

    private void versionTwo(){
        new DownloadFileTask().execute(URL);
    }
    
}
