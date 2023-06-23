package com.example.benchmarktype0;


import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.TextView;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends Activity {

    private MessageDigest messageDigest;
    private Tasker task;
    private TextView view1;
    private PostsDatabaseHelper postsDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view1 = (TextView) findViewById(R.id.view1);

        //for AsyncChecker
        task = new Tasker(view1);
        task.execute("");

        //for DroidTEC
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.prepareAsync();

        //for VALA
        postsDatabaseHelper = new PostsDatabaseHelper(getApplicationContext());
        postsDatabaseHelper.close();

        //for CrySL
        try {
            messageDigest = MessageDigest.getInstance("SHA1");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        messageDigest.digest();
    }

    private final SensorEventListener mSensorEventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            //if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            if (event.sensor.getType() == Sensor.TYPE_LINEAR_ACCELERATION) {
                // Do work
            } else if (event.sensor.getType() == Sensor.TYPE_GYROSCOPE) {
                // Do work
            } else if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
                // Do work
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {
        }
    };
}