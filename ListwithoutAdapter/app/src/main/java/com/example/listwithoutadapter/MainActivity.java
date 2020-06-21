package com.example.listwithoutadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    LinearLayout ll;
    EditText et;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ll = findViewById(R.id.ll);
        et =findViewById(R.id.et1);
        b = findViewById(R.id.b);
        b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View vi) {
                perfrom();
            }
        });

    }

    public void perfrom(){
        //ll.removeAllViews();
        int n = Integer.parseInt(et.getText().toString());
       for (int i = 1; i <= n; i++) {
           TextView tv= new TextView(this);
            tv.setText(i+"");
            ll.addView(tv);
        }
    }


}
