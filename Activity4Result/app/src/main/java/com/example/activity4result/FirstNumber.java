package com.example.activity4result;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FirstNumber extends AppCompatActivity {
    EditText editText;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_number);
        editText=findViewById(R.id.num1);
        button1=findViewById(R.id.enter1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message=editText.getText().toString();
                Intent i=new Intent();
                i.putExtra("message",message);
                setResult(RESULT_OK,i);
                finish();//finishing activity

            }
        });

    }

}
