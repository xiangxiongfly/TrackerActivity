package com.example.traceactivity.act;

import android.content.Intent;
import android.view.View;

import com.example.traceactivity.R;
import com.example.traceactivity.tracker.TrackerActivity;

public class SecondActivity extends TrackerActivity {

    @Override
    protected void setUpContentView() {
        setContentView(R.layout.activity_second);
    }

    @Override
    protected void setUpData() {
    }

    public void toThirdActivity(View view) {
        startActivity(new Intent(this, ThirdActivity.class));
    }
}
