package com.muneiah.example.mynotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
NotificationManager nm;
NotificationCompat.Builder builder;
PendingIntent pi;
Intent myintent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myintent=new Intent(this,MainActivity.class);
        pi=PendingIntent.getActivity(this,2323,myintent,PendingIntent.FLAG_UPDATE_CURRENT);
        nm= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        createChannel();
    }

    private void createChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel nc=new NotificationChannel("My_id","Muni",NotificationManager.IMPORTANCE_HIGH);
            nc.setLightColor(Color.BLUE);
            nm.createNotificationChannel(nc);
        }
    }

    public void showNotification(View view) {
        builder=new NotificationCompat.Builder(this,"My_id");
        builder.setContentTitle("This is My Notification");
        builder.setContentText("Hello there this is my own notification copy rightshave only for me..!");
        builder.setSmallIcon(R.drawable.ic_baseline_notifications_24);
        builder.setDefaults(Notification.DEFAULT_ALL);
        builder.setContentIntent(pi);
        nm.notify(1234,builder.build());

    }
}