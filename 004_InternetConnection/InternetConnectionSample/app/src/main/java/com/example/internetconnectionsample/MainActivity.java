package com.example.internetconnectionsample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String>{

    private static final String URL = "https://www.w3.org/TR/PNG/iso_8859-1.txt";

    private TextView textView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView = findViewById(R.id.textview);
        progressBar = findViewById(R.id.progressBar);
        getLoaderManager().initLoader(0, null, this);
        volleyConnection();
    }

    private void volleyConnection(){


        // https://www.googleapis.com/books/v1/volumes?q=pride+prejudice&maxResults=5&printType=books

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String BASE_URL = "https://www.googleapis.com/books/v1/volumes?";

        // Parameter for the search string
        final String QUERY_PARAM = "q";
        // Parameter to limit search results.
        final String MAX_RESULTS = "maxResults";
        // Parameter to filter by print type
        final String PRINT_TYPE = "printType";

        String book = "java";
        int number = 5;

        Uri builtURI = Uri.parse(BASE_URL).buildUpon()
                .appendQueryParameter(QUERY_PARAM, book)
                .appendQueryParameter(MAX_RESULTS, String.valueOf(number))
                .appendQueryParameter(PRINT_TYPE, "books")
                .build();



        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, builtURI.toString(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        //                            JSONObject root = new JSONObject(response);
//                            JSONArray items = root.getJSONArray("items");
//                            JSONObject book = items.getJSONObject(0);
//                            JSONObject volumeInfo = book.getJSONObject("volumeInfo");
//                            String description = volumeInfo.getString("description");
                        Book books = new GsonBuilder().create().fromJson(response, Book.class);
                        String description = books.getItems().get(1).getVolumeInfo().getTitle();
                        progressBar.setVisibility(View.GONE);
                        textView.setText(description);


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        // Add the request to the RequestQueue.
       if(isNetworkConnected()){
           queue.add(stringRequest);
       }else{
           progressBar.setVisibility(View.GONE);
           Toast.makeText(this, "No Network Connected :(", Toast.LENGTH_SHORT).show();
       }


    }


    private boolean isNetworkConnected(){

        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

        boolean isWifiConn = networkInfo.isConnected();
        networkInfo = connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        boolean isMobileConn = networkInfo.isConnected();

        return isWifiConn || isMobileConn;
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

}
