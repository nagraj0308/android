package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    WebView wv;
    EditText et;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wv=findViewById(R.id.wv);
        et=findViewById(R.id.et);
        b=findViewById(R.id.b);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadUrl("https://www.google.com");



        b.setOnClickListener(this);
    }
    @Override
    public void onClick(View view){
        wv.loadUrl(et.getText().toString());
    }

}
