package com.example.musicon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class StartupPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup_page);

        getSupportActionBar().hide();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Intent i = new Intent(StartupPage.this,MainActivity.class);
                Intent i = new Intent(StartupPage.this,MenuPage.class);
                startActivity(i);
            }
        },3000);
    }
}