package com.example.traceactivity.tracker;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

public class AppStatusManager implements Application.ActivityLifecycleCallbacks {

    public int mAppStatus = AppStatusConstant.STATUS_FORCE_KILLED;
    public static AppStatusManager mAppStatusManager;
    private Application application;
    private boolean isForground;//是否前台
    private int activeCount;//Activity运行个数


    private AppStatusManager(Application application) {
        this.application = application;
        application.registerActivityLifecycleCallbacks(this);
    }

    public static void init(Application application) {
        if (mAppStatusManager == null) {
            mAppStatusManager = new AppStatusManager(application);
        }
    }

    public static AppStatusManager getInstance() {
        return mAppStatusManager;
    }

    /**
     * 获取APP状态
     */
    public int getAppStatus() {
        return mAppStatus;
    }

    /**
     * 设置APP状态
     */
    public void setAppStatus(int appStatus) {
        this.mAppStatus = appStatus;
    }

    /**
     * 是否前台显示
     */
    public boolean isForground() {
        return isForground;
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
    }

    @Override
    public void onActivityStarted(Activity activity) {
        activeCount++;
    }

    @Override
    public void onActivityResumed(Activity activity) {
        isForground = true;
    }

    @Override
    public void onActivityPaused(Activity activity) {
    }

    @Override
    public void onActivityStopped(Activity activity) {
        activeCount--;
        if (activeCount == 0) {
            isForground = false;
        }
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
    }
}
