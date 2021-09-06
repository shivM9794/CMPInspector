package com.cmpinspector.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.cmpinspector.app.HomeSection.DashboardActivity;
import com.cmpinspector.app.LoginSection.LoginActivity;
import com.cmpinspector.app.Utility.PreferenceUtils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler = new Handler();
        setFCMToken();


        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
//                This 'if' condition is used to start the app without logging every time
                if (PreferenceUtils.getBoolValue(getApplicationContext(), PreferenceUtils.isLogin)) {

                    Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
                    startActivity(intent);

                } else {
                    Intent intent1 = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent1);


                }
            }
        }, 3000);
    }

    private void setFCMToken() {

        try {
            FirebaseMessaging.getInstance().getToken()
                    .addOnCompleteListener(new OnCompleteListener<String>() {
                        @Override
                        public void onComplete(@NonNull Task<String> task) {
                            if (!task.isSuccessful()) {
                                Log.w("Firebase", "Fetching FCM registration token failed", task.getException());
                                return;
                            }

                            String token = task.getResult();
                            if (token != null && !token.isEmpty()) {

                            }
                            Log.e("Firebase-Token", token);
                        }


                    });

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}