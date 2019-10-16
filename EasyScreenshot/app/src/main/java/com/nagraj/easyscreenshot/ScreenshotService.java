package com.nagraj.easyscreenshot;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;

import java.io.File;
import java.io.FileOutputStream;

import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import static android.app.Activity.RESULT_OK;

public class ScreenshotService extends Service {
    Context context;
    File root = new File(Environment.getRootDirectory().getParent());
    Sensor myProximitySensor;
    SensorManager mySensorManager;


    final String uri = root.getPath() + "sdcard/Screenshot/";
    View view;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"Proximity based Screenshot service is Stopped",Toast.LENGTH_LONG).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent =
                PendingIntent.getActivity(this, 0, notificationIntent, 0);

        Notification notification =
                new NotificationCompat.Builder(this, "Channel ID")
                        .setContentTitle("Started")
                        .setContentText("Proximity based Screenshot service is Started")
                        .setSmallIcon(R.drawable.screenshot)
                        .setContentIntent(pendingIntent)
                        .setTicker("Ticker Text")
                        .build();

        startForeground(2, notification);

        context=getApplicationContext();
        mySensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        myProximitySensor = mySensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        if (myProximitySensor == null) {
            Toast.makeText(this, "No proximity", Toast.LENGTH_LONG).show();
        } else {
            mySensorManager.registerListener(proximitiSensorsEventListener, myProximitySensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
        return START_STICKY;
    }

    SensorEventListener proximitiSensorsEventListener = new SensorEventListener() {
        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            // TODO Auto-generated method stub
        }

        @Override
        public void onSensorChanged(SensorEvent event) {
            // TODO Auto-generated method stub
            if (event.sensor.getType() == Sensor.TYPE_PROXIMITY) {
                if(event.values[0]==0){
                    try {




                        // view=getWindow().getDecorView().getRootView();
                        long cur=System.currentTimeMillis();
                        Toast.makeText(getApplicationContext(),cur+"",Toast.LENGTH_LONG).show();

                       Bitmap sc = getScreenShot(view);
                       savePic(sc, uri + "IMG_" + cur + ".png");
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
    };
    public static Bitmap getScreenShot(View view) {


        View screenView = view.getRootView();
        screenView.setDrawingCacheEnabled(true);
        Bitmap bitmap = Bitmap.createBitmap(screenView.getDrawingCache());
        screenView.setDrawingCacheEnabled(false);
        return bitmap;
    }
    private static void savePic(Bitmap b, String strFileName)
    {
        FileOutputStream fos = null;
        try
        {
            fos = new FileOutputStream(strFileName);
            if (null != fos)
            {
                b.compress(Bitmap.CompressFormat.PNG, 100, fos);
                fos.flush();
                fos.close();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }








}
