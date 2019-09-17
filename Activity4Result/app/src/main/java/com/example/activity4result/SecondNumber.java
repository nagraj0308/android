package com.example.activity4result;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondNumber extends AppCompatActivity {
    EditText editText;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_number);
        editText=findViewById(R.id.num2);
        button2=findViewById(R.id.enter2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message=editText.getText().toString();
                Intent i=new Intent();
                i.putExtra("message",message);
                setResult(2,i);
                finish();//finishing activity

            }
        });

    }
}
