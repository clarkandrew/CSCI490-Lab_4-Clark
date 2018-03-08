package com.example.andrewclark.csci490_lab_04_clark;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            String output = sendGet("https://jsonplaceholder.typicode.com/users");
            Log.i("Output: ", output);

        } catch(Exception e) {
            Log.i("Error: ", e.getMessage());
        }

    }



    public String sendGet(String iUrl)  {
        String output;
        URL getUrl;


                getUrl = new URL(iUrl);

                HttpURLConnection conn = (HttpURLConnection) getUrl.openConnection();

                InputStreamReader streamRead = new InputStreamReader((conn.getInputStream()));

                BufferedReader buffRead = new BufferedReader(streamRead);

                output = buffRead.readLine();

                buffRead.close();


        return output;
    }
}
