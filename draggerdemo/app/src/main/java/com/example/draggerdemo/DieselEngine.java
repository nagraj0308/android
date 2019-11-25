package com.example.draggerdemo;

import android.util.Log;

import javax.inject.Inject;

import dagger.Module;

@Module
public class DieselEngine implements Engine {
    @Inject
    public DieselEngine(){

    }
    @Override
    public void start() {
        Log.e("MSG","Diesel Engine Started !!");
    }
}
