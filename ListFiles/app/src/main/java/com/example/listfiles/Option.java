package com.example.listfiles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class Option extends AppCompatActivity {
    ListView listView;
    String opt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);
        listView = findViewById(R.id.listView1);
        ArrayList<String> list = new ArrayList<>();
        opt = getIntent().getStringExtra("option");


        try {
            File root = new File(opt);
            getSupportActionBar().setTitle(opt);
            File[] files = root.listFiles();
            Arrays.sort(files);
            list.clear();
            for (File file1 : files) {
                list.add(file1.getPath());
            }
        }catch (Exception e){

        }

        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(aa);
        setupListViewListener();
    }

    private void setupListViewListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String s=(String) listView.getItemAtPosition(i);
                Intent j = new Intent(getApplicationContext(), Option.class);
                j.putExtra("option",s);
                startActivity(j);

            }
        });
    }
}
