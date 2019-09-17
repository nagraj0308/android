package com.example.ordercoffee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    EditText et;
    TextView tv;

    public void orderNow(View v) {


        et = (EditText) findViewById(R.id.tv2);
        tv = (TextView) findViewById(R.id.tv4);
        String s = et.getText().toString();
        int i = Integer.parseInt(s);
        s = "$" + (i * 25);
        tv.setText(s);
        tv = (TextView) findViewById(R.id.tv6);
        tv.setText("Thank You Sir!!");
    }

    public void plus(View v) {


        et = (EditText) findViewById(R.id.tv2);
        String s = et.getText().toString();
        int i = Integer.parseInt(s);
        s = "" + (i + 1);
        et.setText(s);

    }

    public void minus(View v) {


        et = (EditText) findViewById(R.id.tv2);
        String s = et.getText().toString();
        int i = Integer.parseInt(s);
        s = "" + (i - 1);
        et.setText(s);

    }


}
