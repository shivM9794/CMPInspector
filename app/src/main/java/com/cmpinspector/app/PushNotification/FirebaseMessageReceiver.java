package com.cmpinspector.app.PushNotification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import com.cmpinspector.app.LoginSection.LoginActivity;
import com.cmpinspector.app.MainActivity;
import com.cmpinspector.app.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Random;

public class FirebaseMessageReceiver extends FirebaseMessagingService {

    private final String ADMIN_CHANNEL_ID = "cmpinspectorapp";

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {

        Log.e("Notification", remoteMessage.toString());


        if(remoteMessage.getData().size()>0){
            showNotification(remoteMessage.getData().get("title"),
                    remoteMessage.getData().get("message"));
            return;
        }

        if(remoteMessage.getNotification()!=null){
            showNotification(remoteMessage.getNotification().getTitle(),
                    remoteMessage.getNotification().getBody());
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void setupChannels(NotificationManager notificationManager) {

        String adminChannelName = "CMP Inspector App";
        String adminChannelDescription = "Device to device notification";

        NotificationChannel adminChannel = new NotificationChannel(ADMIN_CHANNEL_ID, adminChannelName, NotificationManager.IMPORTANCE_HIGH);

        adminChannel.setDescription(adminChannelDescription);
        adminChannel.enableLights(true);
        adminChannel.setLightColor(Color.RED);
        adminChannel.enableVibration(true);
        notificationManager.createNotificationChannel(adminChannel);

    }

//    private RemoteViews getCustomDesign(String title, String message){
//            RemoteViews remoteViews = new RemoteViews(getApplicationContext().getPackageName(),
//                    R.layout.notification);
//
//            remoteViews.setTextViewText(R.id.title, title);
//            remoteViews.setTextViewText(R.id.message, message);
//            remoteViews.setImageViewResource(R.id.icon, R.drawable.logo);
//
//            return remoteViews;
//
//    }

    private void showNotification(String title, String message){

        Intent intent = new Intent(this, LoginActivity.class);
        intent.putExtra("title", title);
        intent.putExtra("message", message);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        int notificationID = new Random().nextInt(3000);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String adminChannelName = "CMP Inspector ";
            String adminChannelDescription = "Device to device notification";

            NotificationChannel adminChannel = new NotificationChannel(ADMIN_CHANNEL_ID, adminChannelName, NotificationManager.IMPORTANCE_HIGH);

            adminChannel.setDescription(adminChannelDescription);
            adminChannel.enableLights(true);
            adminChannel.setLightColor(Color.RED);
            adminChannel.enableVibration(true);
            notificationManager.createNotificationChannel(adminChannel);
        }

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(
                this, 0, intent,
                PendingIntent.FLAG_ONE_SHOT
        );

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        Uri notificationSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        int i = android.graphics.Color.argb(255, 0, 163, 255);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(),
                ADMIN_CHANNEL_ID)
                .setSmallIcon(R.drawable.inpector)
                .setAutoCancel(true)
                .setVibrate(new long[]{1000,1000,1000,1000,1000})
                .setOnlyAlertOnce(true)
                .setContentIntent(pendingIntent)
                .setSound(notificationSoundUri)
                .setColor(i)
                .setColorized(true)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.inpector))
                .setContentTitle(title)
                .setContentText(message);


//        if (Build.VERSION.SDK_INT
//                >= Build.VERSION_CODES.JELLY_BEAN) {
//            builder = builder.setContent(
//                    getCustomDesign(title, message));
//        }else{
//            builder = builder
//                    .setSmallIcon(R.drawable.logo);
//        }

        notificationManager.notify(notificationID, builder.build());


    }

    @Override
    public void onNewToken(String token) {
        Log.d("FireBase", "Refreshed token: " + token);

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // FCM registration token to your app server.
//        PreferenceUtil.setStringValue(PreferenceUtil.FCMTOKEN, this, token);
//        PreferenceUtil.setBoolean(PreferenceUtil.FCMTOKENChanged, this, true);
    }
}
