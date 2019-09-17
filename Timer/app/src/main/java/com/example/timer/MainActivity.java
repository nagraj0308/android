package com.example.timer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText et;
    TextView tv;
    Button button;
    int time, start = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = findViewById(R.id.et1);
        tv = findViewById(R.id.tv1);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (start == 0) {
                    time = Integer.parseInt(et.getText().toString());
                    Start();
                } else {
                    // Stop();
                }
            }
        });
    }

    public void Start() {
        button.setText("Stop");
        start = 1;
        timer();

    }

    public void Stop() {
        button.setText("Start");
        start = 0;
    }

    public void timer() {
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (time > 0) {
                    tv.setText(time + "");
                    time--;
                    handler.postDelayed(this, 1000);
                } else {
                    tv.setText(time + "");
                    Stop();
                }
            }
        });
    }
}
