package com.example.internetconnectionsample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import javax.net.ssl.HttpsURLConnection;

public class InternetUtils {

    public static String downloadFile(String urlString){

        try {

            URL url = new URL(urlString);

            HttpsURLConnection httpsURLConnection  = (HttpsURLConnection)url.openConnection();
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setConnectTimeout(10000);
            httpsURLConnection.setReadTimeout(5000);
            httpsURLConnection.setRequestMethod("GET");
            httpsURLConnection.connect();
            int responseCode = httpsURLConnection.getResponseCode();
            if(responseCode == HttpsURLConnection.HTTP_OK){
                String responseData = convertStreamToString(httpsURLConnection.getInputStream());
                return responseData;
            }
            return null;

        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String convertStreamToString(InputStream in) {
        BufferedReader bufferedReader = null;
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(in, "UTF-8");
            bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder stringBuilder = new StringBuilder();
            String line = bufferedReader.readLine();
            while(line != null){
                stringBuilder.append(line);
                line = bufferedReader.readLine();
            }
            return stringBuilder.toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
