package com.example.draggerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    Car car;
    CarComponent carComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.tv);
        carComponent=DaggerCarComponent.create();
        car=carComponent.getCar();
        car.driveCar(tv);

    }
}
