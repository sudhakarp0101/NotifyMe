package com.example.user.notifyme;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private NotificationCompat.Builder mNotifyBuilder;
    private NotificationManager mNotifyManager;
    private static final int NOTIFICATION_ID = 0;
    private Button mNotifyButton;
    private Button mUpdateButton;
    private Button mCancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNotifyManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

    }

    public void sendNotification(View view) {
        mNotifyBuilder = new NotificationCompat.Builder(this);
        mNotifyBuilder = new NotificationCompat.Builder(this)
                .setContentTitle("You've been notified!")
                .setContentText("This is your notification text.")
                .setSmallIcon(R.drawable.ic_android);
        mNotifyManager.notify(NOTIFICATION_ID, mNotifyBuilder.build());

        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent notificationPendingIntent = PendingIntent
                .getActivity(this, NOTIFICATION_ID, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        mNotifyManager.notify(NOTIFICATION_ID, mNotifyBuilder.build());
    }

    public void updateNotification(View view) {
    }

    public void cancelNotification(View view) {
        mNotifyManager.cancel(NOTIFICATION_ID);
    }
}
