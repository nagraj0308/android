package com.nagraj.parcelabledemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button gotoDetail;
    public static final String HOUSE_KEY = "house";

    private House house1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gotoDetail=findViewById(R.id.gotoDetail);
        gotoDetail.setOnClickListener(this);


        ArrayList<String> previousOwnersArray = new ArrayList<>();
        previousOwnersArray.add("Noris");
        previousOwnersArray.add("Erick");

        house1  = new House(100000, "Los Angeles", true, previousOwnersArray);

    }


    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(HOUSE_KEY, house1);
        startActivity(intent);
    }


}
