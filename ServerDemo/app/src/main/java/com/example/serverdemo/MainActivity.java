package com.example.serverdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    EditText et1;
    EditText et2;
    Button b;
    String add="",result;
    int i,j;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);
        b=findViewById(R.id.b);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i=Integer.parseInt(et1.getText().toString());
                j=Integer.parseInt(et2.getText().toString());
                add="http://www.telusko.com/addition.htm?t1="+i+"&t2="+j;
                new MultiplyTask().execute();
            }
        });
    }
    public class MultiplyTask extends AsyncTask<String,String,String>{
        @Override
        protected String doInBackground(String... params) {
            try {
                URL url=new URL(add);
                HttpURLConnection con=(HttpURLConnection)url.openConnection();
                con.setRequestMethod("GET");
                con.connect();

                BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));
                result=br.readLine();

            } catch (Exception e) {
                e.printStackTrace();
            }
            return result;
        }


        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            Toast.makeText(getApplicationContext(),result, Toast.LENGTH_LONG).show();
        }


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }




    }
}
