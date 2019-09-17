package com.example.chooseshare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText web,place,text,phone;
    Button webB,placeB,textB,phoneB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phone=findViewById(R.id.phone);
        web=findViewById(R.id.web);
        place=findViewById(R.id.place);
        text=findViewById(R.id.text);

        webB=findViewById(R.id.webB);
        phoneB=findViewById(R.id.phoneB);
        placeB=findViewById(R.id.placeB);
        textB=findViewById(R.id.textB);
        phoneB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = phone.getText().toString();
                Uri number = Uri.parse("tel:"+url);
                Intent intent = new Intent(Intent.ACTION_DIAL, number);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    Log.d("ImplicitIntents", "Can't handle this intent!");
                }

            }
        });
        webB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = web.getText().toString();
                Uri webpage = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    Log.d("ImplicitIntents", "Can't handle this intent!");
                }

            }
        });
        placeB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String loc = place.getText().toString();
                Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
                Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    Log.d("ImplicitIntents", "Can't handle this intent!");
                }

            }
        });
        textB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt = text.getText().toString();
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT,txt);
                intent.setType("text/plain");

                 if(intent.resolveActivity(getPackageManager()) != null) {
                     startActivity(Intent.createChooser(intent, getResources().getText(R.string.choser)));

                }

            }
        });
    }
}
