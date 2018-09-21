package com.example.traceactivity.act;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.example.traceactivity.R;
import com.example.traceactivity.tracker.AppStatusConstant;
import com.example.traceactivity.tracker.AppStatusManager;
import com.example.traceactivity.tracker.TrackerActivity;

import java.lang.ref.WeakReference;

public class SplashActivity extends TrackerActivity {
    private MyHandler mHandler = new MyHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //设置默认状态
        AppStatusManager.getInstance().setAppStatus(AppStatusConstant.STATUS_NORMAL);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void setUpContentView() {
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void setUpData() {
        if (mHandler != null) {
            mHandler.sendEmptyMessageDelayed(0, 2000);
        }
    }

    private static class MyHandler extends Handler {
        private WeakReference<Context> reference;

        public MyHandler(Context context) {
            reference = new WeakReference<>(context);
        }

        @Override
        public void handleMessage(Message msg) {
            SplashActivity activity = (SplashActivity) reference.get();
            if (activity != null) {
                activity.startActivity(new Intent(activity, MainActivity.class));
                activity.finish();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mHandler != null) {
            mHandler.removeCallbacksAndMessages(null);
            mHandler = null;
        }
    }
}
