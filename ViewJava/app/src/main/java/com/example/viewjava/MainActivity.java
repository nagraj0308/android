package com.example.viewjava;


import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv=findViewById(R.id.listView1);
        ArrayList<String> as=new ArrayList<>();
        as.add("A");
        as.add("B");
        as.add("C");
        as.add("D");
        as.add("E");
        as.add("F");
        as.add("G");
        as.add("H");
        as.add("I");
        as.add("J");
        as.add("K");
        as.add("L");
        as.add("M");
        ArrayAdapter<String>  aa=new ArrayAdapter<String>( this ,android.R.layout.simple_spinner_dropdown_item,as);
        lv.setAdapter(aa);
    }
}
