package com.example.draggerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    TextView tvStart,tvDrive;
   @Inject Car car;
    CarComponent carComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvStart=findViewById(R.id.tv_start);
        tvDrive=findViewById(R.id.tv_drive);

        carComponent=DaggerCarComponent.create();
        carComponent.inject(this);

        car.startCar(tvStart);
        car.driveCar(tvDrive);


    }
}
