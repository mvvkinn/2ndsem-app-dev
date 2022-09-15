package kr.ac.mjc.ict2018261031.a0915_service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class BackgroundService extends Service {
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Handler handler = new Handler();
        try {
            for(int i=1;i<=5;i++) {
                Thread.sleep(1000);
                final int j=i;
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(BackgroundService.this, j+"초 쉬는중", Toast.LENGTH_SHORT).show();
                    }
                });

            }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    Intent startActivityIntent = new Intent(BackgroundService.this, MainActivity.class);
                    startActivityIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(startActivityIntent);
                }
            });

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
