package com.example.draggerdemo;

import android.widget.TextView;

import javax.inject.Inject;

class Car {
    Engine engine;
    Wheel wheel;

    @Inject
    Car(Engine engine, Wheel wheel) {
        this.engine = engine;
        this.wheel = wheel;
    }
    void driveCar(TextView textView){
        textView.setText("Car is driving....");
    }
    void startCar(TextView textView){
        textView.setText("Car is starting....");
    }
    @Inject public void enableRemote(Remote remote){
        remote.setStarter(this);
    }
}
