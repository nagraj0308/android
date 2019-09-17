package com.example.jsonsimple;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MyContactsActivity extends AppCompatActivity {
    Button button;
    RecyclerView rcv;
    String jsonmsg=null;
    private String TAG = MyContactsActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initAll();
    }

    void initAll() {
        button = findViewById(R.id.button);
        rcv=findViewById(R.id.rcv);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Net().execute();
            }
        });


    }


    protected class Net extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(MyContactsActivity.this, "Json Data is downloading", Toast.LENGTH_SHORT).show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
            // Making a request to url and getting response
            String url = "https://api.androidhive.info/contacts/";
            String jsonStr = sh.makeServiceCall(url);
            if (jsonStr != null) {

            jsonmsg=jsonStr;}
            else{
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG).show();
                    }
                });


            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            rcv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            rcv.setAdapter(new ContactsAdapter(jsonmsg));


        }
    }
}
