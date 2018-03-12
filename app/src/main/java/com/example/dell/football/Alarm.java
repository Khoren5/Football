package com.example.dell.football;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Vibrator;


public class Alarm extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

String id=intent.getStringExtra("a");
String a=intent.getStringExtra(id);
        Notification.BigTextStyle builderr= new Notification.BigTextStyle();
        builderr.setBigContentTitle("Start Football");
        builderr.bigText(a);
        builderr.setSummaryText("   ");
        Notification.Builder builder=new Notification.Builder(context);
        builder.setContentTitle("Start Football").setSmallIcon(R.mipmap.logostartf_round).setStyle(builderr)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(),R.mipmap.logostartf));
                NotificationManager notificationManager=(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(Integer.parseInt(id),builder.build());
        Vibrator v=(Vibrator)context.getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(1000);
    }
}
