package com.example.logintest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;

import android.content.Intent;
import android.os.Bundle;

public class Dummy_test extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dummy_test);
    }

    @Override
    public void onBackPressed() {

        Intent i = new Intent(Dummy_test.this,UserNewsFeed.class);
        startActivity(i);

    }
}
