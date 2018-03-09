package com.example.andrewclark.csci490_lab_04_clark;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by andrewclark on 3/8/18.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView jsonView= findViewById(R.id.displayJson);

        asyncTask asynctask = new asyncTask(jsonView);
        asynctask.execute("https://jsonplaceholder.typicode.com/users");


    }
}