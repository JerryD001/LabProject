package com.jerry.lab.broadcast;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import com.jerry.lab.Util.ActivityManager;
import com.jerry.lab.activity.LoginActivity;

public class ForceOfflineReceiver extends BroadcastReceiver {
    public ForceOfflineReceiver() {
    }

    @Override
    public void onReceive(final Context context, Intent intent) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Warning");
        builder.setMessage("You are forced to be offline. Please try to login again.");
        builder.setCancelable(false);
        builder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ActivityManager.finishAll(); // 销毁所有活动
                        Intent intent = new Intent(context, LoginActivity.class);
                        context.startActivity(intent); // 重新启动LoginActivity
                    }
                });
        builder.show();
    }
}
