package kr.ac.mjc.ict2018261031.signup.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

import kr.ac.mjc.ict2018261031.signup.activity.DownloadActivity;
import kr.ac.mjc.ict2018261031.signup.activity.RecyclerActivity;

public class BackgroundService extends Service {
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        try {
            /**
             * 여기가 문제인듯
             */
            Intent downloadService = new Intent(this, ForegroundService.class);
            downloadService.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startService(downloadService);



            Thread.sleep(5000);

            Intent intent2 = new Intent(this, DownloadActivity.class);
            intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent2);

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
