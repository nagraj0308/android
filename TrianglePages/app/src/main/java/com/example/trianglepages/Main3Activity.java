package com.example.trianglepages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }
    public void gotoActivity1(View view){
        startActivity(new Intent(this,MainActivity.class));
    }
    public void gotoActivity2(View view){
        startActivity(new Intent(this,Main2Activity.class));
    }

}
