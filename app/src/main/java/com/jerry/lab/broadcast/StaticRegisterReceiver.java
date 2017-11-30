package com.jerry.lab.broadcast;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import com.jerry.lab.R;
import com.jerry.lab.activity.MainActivity;

import static android.content.Context.NOTIFICATION_SERVICE;

public class StaticRegisterReceiver extends BroadcastReceiver {
    public StaticRegisterReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        Toast.makeText(context, "StaticRegisterReceiver收到了其他页面发来的广播\n目的是去弹出一条通知", Toast.LENGTH_SHORT).show();
        buildNotification(context);
    }

    private void buildNotification(Context context) {
        Intent i = new Intent(context, MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(context, 0, i, 0);

        NotificationManager manager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        Notification notification = new NotificationCompat.Builder(context)
                .setContentText("年轻人应当如何去奋斗")
                .setContentText("广播发送的通知：年轻时如果不能有所建树，那么最应当做的事是锻炼好身体！")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher))
                .setAutoCancel(true)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setStyle(new NotificationCompat.BigTextStyle().bigText("年轻时如果不能有所建树，那么最应当做的事是锻炼好身体！"))
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .setContentIntent(pi)
                .build();
        manager.notify(1, notification);
    }
}
