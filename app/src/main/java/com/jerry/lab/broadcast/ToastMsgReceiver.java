package com.jerry.lab.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ToastMsgReceiver extends BroadcastReceiver {
    public ToastMsgReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        Toast.makeText(context,"ToastMsgReceiver收到了其他页面发来的广播",Toast.LENGTH_SHORT).show();
    }
}
