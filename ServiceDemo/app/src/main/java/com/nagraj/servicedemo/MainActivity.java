package com.nagraj.servicedemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.IBinder;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;

import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class MainActivity extends AppCompatActivity {
    Intent serviceIntent;
    Switch service, binding;
    Context context;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        service = findViewById(R.id.service);
        editText = findViewById(R.id.editText);
        binding = findViewById(R.id.binding);


        serviceSection();
        bindingSection();

    }

    public void serviceSection() {
        context = getApplicationContext();
        serviceIntent = new Intent(context, MyService.class);
        service.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    startService(serviceIntent);
                } else {
                    stopService(serviceIntent);
                }

            }
        });
    }


    public void bindingSection() {
        binding.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    doBind();
                } else {
                    doUnbind();
                }

            }
        });

    }

    public void doBind() {
        String msg = editText.getText().toString();
        serviceIntent.putExtra("msgOnBind", msg);
        context.bindService(serviceIntent, mServerConn, Context.BIND_AUTO_CREATE);
    }

    public void doUnbind() {
        context.unbindService(mServerConn);
    }

    protected ServiceConnection mServerConn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder binder) {
            Log.e("LOG_TAG", "onServiceConnected");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.e("LOG_TAG", "onServiceDisconnected");
        }
    };
}
