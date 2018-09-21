package com.example.traceactivity.tracker;

import android.app.Application;

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AppStatusManager.init(this);
    }
}
