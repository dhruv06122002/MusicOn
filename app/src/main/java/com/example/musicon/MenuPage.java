package com.example.musicon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_page);
    }

    public void musicplayer(View view) {

        Intent i = new Intent(MenuPage.this,MainActivity.class);
        startActivity(i);

    }

    public void localmusicplayer(View view) {

        Intent i = new Intent(MenuPage.this,MusicPlayerredirect.class);
        startActivity(i);

    }

    public void cbr(View view) {
        Intent i = new Intent(MenuPage.this,chatbot.class);
        startActivity(i);
    }
}