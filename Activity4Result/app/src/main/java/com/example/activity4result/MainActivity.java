package com.example.activity4result;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button1,button2,button3;
    int num1,num2,sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1=findViewById(R.id.num1);
        button2=findViewById(R.id.num2);
        button3=findViewById(R.id.result);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),FirstNumber.class);
                startActivityForResult(i, 3);

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),SecondNumber.class);
                startActivityForResult(i, 2);

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sum=num1+num2;
                button3.setText(sum+"");
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==3&&resultCode==RESULT_OK)
        {
            String message=data.getStringExtra("message");
            button1.setText(message);
            num1=Integer.parseInt(message);
        }
        if(requestCode==2)
        {
            String message=data.getStringExtra("message");
            button2.setText(message);
            num2=Integer.parseInt(message);
        }
    }
}
