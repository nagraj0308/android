package com.nagraj.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Messenger;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyService extends Service {
    boolean allowRebind=true;


    private final IBinder mBinder = new MyBinder();

    @Nullable
    @Override
    public IBinder onBind(Intent arg0) {

        Toast.makeText(this,"onBind is Called",Toast.LENGTH_LONG).show();
        Bundle extras = arg0.getExtras();

        if (extras != null) {

            Toast.makeText(getApplicationContext(),extras.getString("msgOnBind"),Toast.LENGTH_LONG).show();
        }
        return mBinder;
    }

    public class MyBinder extends Binder {
        MyService getService() {
            return MyService.this;
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"Service is Destroyed",Toast.LENGTH_LONG).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this,"Service is Started",Toast.LENGTH_LONG).show();

       // stopSelf();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Toast.makeText(this,"Service is Unbind",Toast.LENGTH_LONG).show();
        return allowRebind;
    }
    @Override
    public void onRebind(Intent intent) {
        // A client is binding to the service with bindService(),
        // after onUnbind() has already been called
       // Toast.makeText(this,"Service is Rebind",Toast.LENGTH_LONG).show();
        Bundle extras = intent.getExtras();

        if (extras != null) {

            Toast.makeText(getApplicationContext(),extras.getString("msgOnRebind"),Toast.LENGTH_LONG).show();
        }

    }
}
