package com.example.nplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button play ,pause,stop;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play=findViewById(R.id.play);
        pause=findViewById(R.id.pause);
        stop=findViewById(R.id.stop);
        mp=MediaPlayer.create(getApplicationContext(),R.raw.perfect);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    mp.start();
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.pause();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.stop();
            }
        });
    }
}
