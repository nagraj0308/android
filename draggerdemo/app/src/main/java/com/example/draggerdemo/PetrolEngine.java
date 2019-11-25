package com.example.draggerdemo;

import android.util.Log;

import javax.inject.Inject;

import dagger.Module;

@Module
public class PetrolEngine implements Engine {
    @Inject
    public PetrolEngine(){

    }
    @Override
    public void start() {
        Log.e("MSG","Petrol Engine Started !!");

    }
}
