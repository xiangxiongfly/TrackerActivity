package com.example.traceactivity.act;

import android.content.Intent;
import android.view.View;

import com.example.traceactivity.R;
import com.example.traceactivity.tracker.AppStatusConstant;
import com.example.traceactivity.tracker.TrackerActivity;

public class MainActivity extends TrackerActivity {

    @Override
    protected void setUpContentView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void setUpData() {
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        int action = intent.getIntExtra(AppStatusConstant.KEY_HOME_ACTION, AppStatusConstant.ACTION_BACK_TO_HOME);
        switch (action) {
            case AppStatusConstant.ACTION_RESTART_APP:
                protectApp();
                break;
            case AppStatusConstant.ACTION_BACK_TO_HOME:
                break;
            default:
                break;
        }
    }

    @Override
    protected void protectApp() {
        /*跳转引导页，重启APP*/
        startActivity(new Intent(this, SplashActivity.class));
        finish();
    }

    public void toSecondActivity(View view) {
        startActivity(new Intent(this, SecondActivity.class));
    }
}
