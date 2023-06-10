package com.mirea.kt.serviceapplication;

import static com.mirea.kt.serviceapplication.MyCustomApp.LOG_TAG;

import android.app.KeyguardManager;
import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class LockMonitorService extends Service {
    public LockMonitorService() {
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
       return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(LOG_TAG,"MonitorService started");
        NotificationHelper notificationHelper = new NotificationHelper(this);
        Notification n = notificationHelper.createNotification("Мониторинг", "Сервис наблюдения запущен", 12345);
        startForeground(12345, n);
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.d(LOG_TAG, "MonitorService destroyed");
        super.onDestroy();
    }

    private void checkPhoneScreenLocked(){
        KeyguardManager km = (KeyguardManager)
                getApplicationContext().getSystemService(Context.KEYGUARD_SERVICE);
        if(km.isKeyguardLocked()) {
            Log.d(LOG_TAG,"Phone is locked");
        } else {
            Log.d(LOG_TAG,"Phone is not locked");
        }
    }
}