package com.example.musicon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;

public class MainActivity<musicPlayer> extends AppCompatActivity {

    ImageButton pauseBtn, stopBtn , previousBtn , NextBtn ;
    ImageButton audiobtn;
    TextView urltxt;
    MediaPlayer mediaPlayer;
    String audiourlplay = "https://firebasestorage.googleapis.com/v0/b/musicon-bc088.appspot.com/o/Namo%20Namo%20-%20Lyrical%20_%20Kedarnath%20_%20Sushant%20Rajput%20_%20Sara%20Ali%20Khan%20_%20Amit%20Trivedi%20_%20Amitabh%20B.mp3?alt=media&token=ad1d1ec7-bf68-4c99-8fc1-2b19c7045f86";
    String audiourlnext = "https://firebasestorage.googleapis.com/v0/b/musicon-bc088.appspot.com/o/Param%20Sundari%20-Official%20Video%20_%20Mimi%20_%20Kriti%20Sanon%2C%20Pankaj%20Tripathi%20_%20%40A.%20R.%20Rahman_%20Shreya%20_Amitabh.mp3?alt=media&token=8327bc26-7c76-485f-8e76-9860b4fbd79c";
    String audiourlprev = "https://firebasestorage.googleapis.com/v0/b/musicon-bc088.appspot.com/o/Ajab%20Si.mp3?alt=media&token=7c72973b-d0fa-47c0-a37c-6acde045ee60";
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    private DatabaseReference child = databaseReference.child("url");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        audiobtn = findViewById(R.id.playBtn);
        urltxt = findViewById(R.id.audiourl);
        pauseBtn = findViewById(R.id.pauseBtn);
        //stopBtn = findViewById(R.id.stopBtn);
        NextBtn = findViewById(R.id.NextBtn);
        previousBtn = findViewById(R.id.previousBtn);

        //MediaPlayer music = MediaPlayer.create(this, Uri.parse("https://firebasestorage.googleapis.com/v0/b/musicon-bc088.appspot.com/o/Aasman%20Ko%20Chukar%20%20Return%20Of%20Hanuman.mp3?alt=media&token=4c7e944c-e097-4af0-9ebf-0e74dda2dc25"));

    }

    @Override
    protected void onStart() {
        super.onStart();
        child.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                audiourlplay=snapshot.getValue(String.class);
                urltxt.setText(audiourlplay);
                //Toast.makeText(MainActivity.this,"Url in text"+audiourlplay,Toast.LENGTH_LONG).show();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                //Toast.makeText(MainActivity.this,"Process Canceled!",Toast.LENGTH_LONG).show();
            }
        });
    }

    /*public void musicplay(View v) throws IOException {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected()) {
            Toast.makeText(MainActivity.this,"Playing...",Toast.LENGTH_LONG).show();
            music.start();
        } else {
            Toast.makeText(MainActivity.this,"Check Your Internet Connection",Toast.LENGTH_LONG).show();
        }
        Toast.makeText(MainActivity.this,"Play button",Toast.LENGTH_LONG).show();
    }*/

    public void audioplay(View view)
    {
        audiobtn.setEnabled(false);
        pauseBtn.setEnabled(true);
        mediaPlayer=new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try{
            mediaPlayer.setDataSource(audiourlplay);
            mediaPlayer.prepare();
            mediaPlayer.start();
            Toast.makeText(MainActivity.this,"Playing audio",Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            //e.printStackTrace();
            //Toast.makeText(MainActivity.this,"ErrorOccurs"+e,Toast.LENGTH_LONG).show();
        }
    }

    public void musicpause(View v)
    {
        //music.pause();
        audiobtn.setEnabled(true);
        pauseBtn.setEnabled(false);
        mediaPlayer.pause();
        //Toast.makeText(MainActivity.this,"Pause button",Toast.LENGTH_LONG).show();
    }

    public void musicstop(View v)
    {
        //music.stop();
        //music = MediaPlayer.create(this, Uri.parse("https://firebasestorage.googleapis.com/v0/b/musicon-bc088.appspot.com/o/Aasman%20Ko%20Chukar%20%20Return%20Of%20Hanuman.mp3?alt=media&token=4c7e944c-e097-4af0-9ebf-0e74dda2dc25"));
        //Toast.makeText(MainActivity.this,"stop button",Toast.LENGTH_LONG).show();
        mediaPlayer.stop();
    }

    public void Musicprevious(View v)
    {
        //music.stop();
        //music = MediaPlayer.create(this, Uri.parse("https://firebasestorage.googleapis.com/v0/b/musicon-bc088.appspot.com/o/Aasman%20Ko%20Chukar%20%20Return%20Of%20Hanuman.mp3?alt=media&token=4c7e944c-e097-4af0-9ebf-0e74dda2dc25"));
        //Toast.makeText(MainActivity.this,"previous button",Toast.LENGTH_LONG).show();
        audiobtn.setEnabled(true);
        pauseBtn.setEnabled(true);
        //mediaPlayer.stop();
        mediaPlayer=new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try{
            mediaPlayer.setDataSource(audiourlprev);
            mediaPlayer.prepare();
            mediaPlayer.start();
            //Toast.makeText(MainActivity.this,"Playing audio",Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            //e.printStackTrace();
            //Toast.makeText(MainActivity.this,"ErrorOccurs"+e,Toast.LENGTH_LONG).show();
        }
    }

    public void musicnext(View v)
    {
        //music.stop();
        //music = MediaPlayer.create(this, Uri.parse("https://firebasestorage.googleapis.com/v0/b/musicon-bc088.appspot.com/o/Aasman%20Ko%20Chukar%20%20Return%20Of%20Hanuman.mp3?alt=media&token=4c7e944c-e097-4af0-9ebf-0e74dda2dc25"));
        //Toast.makeText(MainActivity.this,"next button",Toast.LENGTH_LONG).show();
        audiobtn.setEnabled(true);
        pauseBtn.setEnabled(true);
        //mediaPlayer.stop();
        mediaPlayer=new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try{
            mediaPlayer.setDataSource(audiourlnext);
            mediaPlayer.prepare();
            mediaPlayer.start();
            //Toast.makeText(MainActivity.this,"Playing audio",Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            //e.printStackTrace();
            //Toast.makeText(MainActivity.this,"ErrorOccurs"+e,Toast.LENGTH_LONG).show();
        }
    }
}