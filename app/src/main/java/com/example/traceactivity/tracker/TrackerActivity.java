package com.example.traceactivity.tracker;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.traceactivity.act.MainActivity;

public abstract class TrackerActivity extends AppCompatActivity {
    private String TAG = "TAG";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        switch (AppStatusManager.getInstance().getAppStatus()) {
            case AppStatusConstant.STATUS_FORCE_KILLED:
                Log.e(TAG, "STATUS_FORCE_KILLED");
                /*处理APP被强杀*/
                protectApp();
                break;
            case AppStatusConstant.STATUS_KICK_OUT:
                /*处理APP被退出登录*/
                Log.e(TAG, "STATUS_KICK_OUT");
                break;
            case AppStatusConstant.STATUS_NORMAL:
                /*APP正常状态*/
                Log.e(TAG, "STATUS_NORMAL");
                setUpContentView();
                setUpData();
                break;
        }
    }

    /**
     * 设置布局
     */
    protected abstract void setUpContentView();

    /**
     * 设置数据
     */
    protected abstract void setUpData();

    /**
     * 处理APP被强杀
     */
    protected void protectApp() {
        /*跳转主界面处理*/
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(AppStatusConstant.KEY_HOME_ACTION, AppStatusConstant.ACTION_RESTART_APP);
        startActivity(intent);
    }
}
