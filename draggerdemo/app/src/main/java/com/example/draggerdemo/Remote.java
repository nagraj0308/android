package com.example.draggerdemo;

import android.util.Log;

import javax.inject.Inject;

public class Remote {
    @Inject
    public Remote() {

    }

    public void setStarter(Car car) {
        Log.e("MSG", "Remote Car Started");
    }
}
