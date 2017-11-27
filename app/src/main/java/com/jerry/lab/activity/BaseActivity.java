package com.jerry.lab.activity;

import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jerry.lab.Util.ActivityManager;
import com.jerry.lab.broadcast.ForceOfflineReceiver;

public class BaseActivity extends AppCompatActivity {

    private ForceOfflineReceiver offlineReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.addActivity(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.jerry.lab.FORCE_OFFLINE");
        offlineReceiver = new ForceOfflineReceiver();
        registerReceiver(offlineReceiver, filter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (offlineReceiver != null){
            unregisterReceiver(offlineReceiver);
            offlineReceiver = null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityManager.removeActivity(this);
    }
}
