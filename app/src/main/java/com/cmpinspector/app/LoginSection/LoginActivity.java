package com.cmpinspector.app.LoginSection;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cmpinspector.app.HomeSection.DashboardActivity;
import com.cmpinspector.app.HomeSection.ProfileActivity;
import com.cmpinspector.app.ModelResponse.LoginResponse;
import com.cmpinspector.app.R;
import com.cmpinspector.app.Retrofit.RetrofitClient;
import com.cmpinspector.app.Utility.PreferenceUtils;
import com.github.ybq.android.spinkit.SpinKitView;
import com.google.gson.Gson;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    Button button;
    EditText email, password;
    private SpinKitView spinKitView;
    private static final int PERMISSION_READ_STATE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if ( ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(this,Manifest.permission.READ_EXTERNAL_STORAGE) !=PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(this,Manifest.permission.READ_PHONE_STATE) !=PackageManager.PERMISSION_GRANTED) {
            requestPermission();
        }
        button = findViewById(R.id.login_btn);
        email = findViewById(R.id.insp_email);
        password = findViewById(R.id.insp_pass);
        spinKitView = findViewById(R.id.spin_kit);




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();



            }
        });

    }

    private void registerUser() {

        spinKitView.setVisibility(View.VISIBLE);


        String inspector_email = email.getText().toString();
        String inspector_password = password.getText().toString();

        if (inspector_email.isEmpty()) {
            email.requestFocus();
            email.setError("Please enter your email");
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(inspector_email).matches()) {
            email.requestFocus();
            email.setError("Please enter your email");
            return;
        }
        if (inspector_password.isEmpty()) {
            password.requestFocus();
            password.setError("Please enter your password");
            return;
        }

        RetrofitClient retrofitClient = RetrofitClient.getInstance();

        HashMap<String, String> headerMap = PreferenceUtils.getHeaderMap(getApplicationContext());
        HashMap<String, String> params = new HashMap<>();

        params.put("inspector_email", inspector_email);
        params.put("inspector_password", inspector_password);
        Log.e("Login", "Response: " + params.toString());


        Call<LoginResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .login(headerMap, params);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                Log.e("Login", "Response: " + new Gson().toJson(response.body()));
                LoginResponse registerResponse = response.body();
                if (response.body() != null) {
                    if (response.body().getSuccess() == 1) {
                        String token = response.body().getResult().getInspectorData().getInspectorToken();
                        PreferenceUtils.setStringValue(LoginActivity.this, PreferenceUtils.UserToken, token);

                        String inspceptor_id = String.valueOf(response.body().getResult().getInspectorData().getInspectorId());
                        PreferenceUtils.setStringValue(LoginActivity.this, PreferenceUtils.inspector_id, inspceptor_id);

                        String inspector_name = response.body().getResult().getInspectorData().getInspectorName();
                        PreferenceUtils.setStringValue(LoginActivity.this, PreferenceUtils.inspector_name, inspector_name);

                        String inspector_email = response.body().getResult().getInspectorData().getInspectorEmail();
                        PreferenceUtils.setStringValue(LoginActivity.this, PreferenceUtils.inspector_email, inspector_email);

                        String inspector_mobile = response.body().getResult().getInspectorData().getInspectorMobile();
                        PreferenceUtils.setStringValue(LoginActivity.this, PreferenceUtils.inspector_mobile, inspector_mobile);

                        PreferenceUtils.setBoolValue(getApplicationContext(), PreferenceUtils.isLogin, true);


                        spinKitView.setVisibility(View.GONE);


                        Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        finish();

                    }
                    Toast.makeText(LoginActivity.this, registerResponse.getMessage(), Toast.LENGTH_SHORT).show();

                    spinKitView.setVisibility(View.GONE);
                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Log.e("Login", "Response: " + new Gson().toJson(t.getMessage()));
                Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

                spinKitView.setVisibility(View.GONE);

            }
        });
    }
    private void requestPermission() {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.READ_PHONE_STATE,Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION}, PERMISSION_READ_STATE);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISSION_READ_STATE: {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED && grantResults[2] == PackageManager.PERMISSION_GRANTED && grantResults[3] == PackageManager.PERMISSION_GRANTED &&
                        grantResults[4]==PackageManager.PERMISSION_GRANTED) {

                } else {

//                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this, R.style.MyAlertDialogStyle);
//                    builder.setTitle("Permission Denied");
//                    builder.setMessage("Are you sure you want to deny this permission?");
//                    builder.setNegativeButton("RETRY", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            dialog.dismiss();
////                            requestPermission();
//                        }
//                    });
//                    builder.setCancelable(false);
//                    builder.show();


                }
            }
            break;
        }

    }





//    private void registerUser() {

//        spinKitView.setVisibility(View.VISIBLE);
//
//
//        String inspector_email = email.getText().toString();
//        String inspector_password = password.getText().toString();
//
//        if (inspector_email.isEmpty()){
//            email.requestFocus();
//            email.setError("Please enter your email");
//            return;
//        }
//        if (!Patterns.EMAIL_ADDRESS.matcher(inspector_email).matches()){
//            email.requestFocus();
//            email.setError("Please enter your email");
//            return;
//        }
//        if (inspector_password.isEmpty()){
//            password.requestFocus();
//            password.setError("Please enter your password");
//            return;
//        }
//
//        RetrofitClient retrofitClient = RetrofitClient.getInstance();
//
//        HashMap<String, String> headerMap = PreferenceUtils.getHeaderMap(getApplicationContext());
//        HashMap<String, String> params = new HashMap<>();
//
//        params.put("inspector_email",inspector_email);
//        params.put("inspector_password", inspector_password);
//        Log.e("Login","Response: "+params.toString());
//
//
//        Call<LoginResponse> call = RetrofitClient
//                .getInstance()
//                .getApi()
//                .login(headerMap,params);
//
//        call.enqueue(new Callback<LoginResponse>() {
//            @Override
//            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
//                Log.e("Login","Response: "+new Gson().toJson(response.body()));
//                LoginResponse registerResponse = response.body();
//                if (response.body() != null) {
//                    if (response.body().getSuccess()==1) {
//                        String token = response.body().getResult().getInspectorData().getInspectorToken();
//                        PreferenceUtils.setStringValue(LoginActivity.this, PreferenceUtils.UserToken, token);
//
//                        String inspceptor_id = String.valueOf(response.body().getResult().getInspectorData().getInspectorId());
//                        PreferenceUtils.setStringValue(LoginActivity.this, PreferenceUtils.inspector_id, inspceptor_id);
//
//                        String inspector_name = response.body().getResult().getInspectorData().getInspectorName();
//                        PreferenceUtils.setStringValue(LoginActivity.this, PreferenceUtils.inspector_name, inspector_name);
//
//                        String inspector_email = response.body().getResult().getInspectorData().getInspectorEmail();
//                        PreferenceUtils.setStringValue(LoginActivity.this, PreferenceUtils.inspector_email, inspector_email);
//
//                        String inspector_mobile = response.body().getResult().getInspectorData().getInspectorMobile();
//                        PreferenceUtils.setStringValue(LoginActivity.this, PreferenceUtils.inspector_mobile, inspector_mobile);
//
//                        PreferenceUtils.setBoolValue(getApplicationContext(),PreferenceUtils.isLogin,true);
//
//
//                        spinKitView.setVisibility(View.GONE);
//
//
//
//
//                        Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
//                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                        startActivity(intent);
//                        finish();
//
//                    }
//                    Toast.makeText(LoginActivity.this, registerResponse.getMessage(), Toast.LENGTH_SHORT).show();
//
//                    spinKitView.setVisibility(View.GONE);
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<LoginResponse> call, Throwable t) {
//                Log.e("Login","Response: "+new Gson().toJson(t.getMessage()));
//                Toast.makeText(LoginActivity.this,t.getMessage(),Toast.LENGTH_SHORT).show();
//
//                spinKitView.setVisibility(View.GONE);
//
//            }
//        });
//    }


        }

