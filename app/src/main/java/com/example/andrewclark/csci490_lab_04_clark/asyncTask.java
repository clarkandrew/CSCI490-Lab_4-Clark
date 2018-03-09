package com.example.andrewclark.csci490_lab_04_clark;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.stream.Collectors;

/**
 * Created by andrewclark on 3/8/18.
 */

public class asyncTask extends AsyncTask<String, Void, String> {

    public asyncTask(TextView textview) {
        this.textview = textview;
    }

    private TextView textview;

    protected String getJson(String inputURL)  throws IOException {

        URL getURL= new URL(inputURL);
        URLConnection getConnect = getURL.openConnection();

        InputStreamReader streamRead = new InputStreamReader((getConnect.getInputStream()));
        BufferedReader buffRead = new BufferedReader(streamRead);

        String jsonString = buffRead.lines().collect(Collectors.joining());
        return jsonString;
    }

    @Override
    protected String doInBackground (String... jsonString){
        String stringBuild = "";
        try {
            stringBuild = getJson(jsonString[0]);
        } catch (Exception e) {
            Log.i("bckError", e.getMessage());
        }
        return stringBuild;
    }

    @Override
    protected void onPostExecute(String myString) {
//        textview.setText(myString);
        textview.setText(myString.substring(10, 23));

    }
}