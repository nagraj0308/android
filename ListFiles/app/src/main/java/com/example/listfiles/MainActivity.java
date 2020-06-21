package com.example.listfiles;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initAll();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            Log.v(TAG,"Permission: "+permissions[0]+ " was "+grantResults[0]);
            //resume tasks needing this permission
        }
    }

    public void initAll() {
        listView = findViewById(R.id.listView1);
        ArrayList<String> list = new ArrayList<>();


        File root = new File(Environment.getRootDirectory().getParent());
        getSupportActionBar().setTitle(root.getPath());

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 101);

        try {

            File[] files = root.listFiles();
            Arrays.sort(files);
            list.clear();
            for (File file1 : files) {
                list.add(file1.getPath());
            }
        } catch (Exception e) {
            Log.e("Exception",e.getMessage());
        }

        ArrayAdapter<String> aa = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(aa);
        setupListViewListener();
    }

    private void setupListViewListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String s=(String) listView.getItemAtPosition(i);
                Toast.makeText(MainActivity.this,s+"is selected!!" , Toast.LENGTH_LONG).show();

                Intent j = new Intent(getApplicationContext(), Option.class);
                j.putExtra("option",s);
                startActivity(j);

            }
        });
    }
}
