package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button;
    RecyclerView rcv;
    String[] str={"Nagendra","asdsd"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcv=findViewById(R.id.rcv);
        button=findViewById(R.id.button);
        button.setOnClickListener(this);
        rcv.setLayoutManager(new LinearLayoutManager(this));
    }
    @Override
        public void onClick(View v) {
        rcv.setAdapter(new Recycle(str));

    }
}
