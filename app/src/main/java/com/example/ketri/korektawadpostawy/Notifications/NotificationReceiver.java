package com.example.ketri.korektawadpostawy.Notifications;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.example.ketri.korektawadpostawy.MainActivity;
import com.example.ketri.korektawadpostawy.R;

import static android.app.NotificationManager.IMPORTANCE_DEFAULT;

/**
 * Created by ketri on 17.11.2018.
 */

public class NotificationReceiver extends BroadcastReceiver{

   private static final String CHANNEL_ID = "com.ketri.korektawadpostawy.channelId";
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent notificationIntent = new Intent(context, MainActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(notificationIntent);
        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        Notification.Builder builder = new Notification.Builder(context);
        Notification notification = builder.setContentTitle(context.getResources().getString(R.string.notification))
                .setContentText(context.getResources().getString(R.string.notificationDesc))
                .setTicker(context.getResources().getString(R.string.alert))
                .setSmallIcon(R.mipmap.ic_logo)
                .setContentIntent(pendingIntent).build();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            builder.setChannelId(CHANNEL_ID);
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    "NotificationDemo",
                    IMPORTANCE_DEFAULT
            );
                       notificationManager.createNotificationChannel(channel);
        }
        notificationManager.notify(0, notification);
    }
}
