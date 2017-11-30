package com.jerry.lab.activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

import com.jerry.lab.R;

public class NotificationActivity extends BaseActivity {

    private Button btn_sendNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        btn_sendNotification = (Button) findViewById(R.id.btn_sendNotification);
        btn_sendNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildNotification();
            }
        });
    }

    private void buildNotification() {
        Intent i = new Intent(this,MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this,0,i,0);

        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification = new NotificationCompat.Builder(this)
                .setContentText("年轻人应当如何去奋斗")
                .setContentText("活动发送的通知：年轻时如果不能有所建树，那么最应当做的事是锻炼好身体！")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                .setAutoCancel(true)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setStyle(new NotificationCompat.BigTextStyle().bigText("年轻时如果不能有所建树，那么最应当做的事是锻炼好身体！"))
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .setContentIntent(pi)
                .build();
        manager.notify(1, notification);
    }
}
