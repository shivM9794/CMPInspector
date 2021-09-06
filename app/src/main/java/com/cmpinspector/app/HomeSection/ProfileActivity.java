package com.cmpinspector.app.HomeSection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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

import static com.cmpinspector.app.Utility.PreferenceUtils.UserToken;
import static com.cmpinspector.app.Utility.PreferenceUtils.inspector_email;
import static com.cmpinspector.app.Utility.PreferenceUtils.inspector_id;
import static com.cmpinspector.app.Utility.PreferenceUtils.inspector_mobile;
import static com.cmpinspector.app.Utility.PreferenceUtils.inspector_name;

public class ProfileActivity extends AppCompatActivity {
    TextView textView1, textView2, textView3, textView4, textView5, textView6, textView7, textView8;
    ImageView imageView;
    private SpinKitView spinKitView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        imageView = findViewById(R.id.ins_back_icon);
        textView1 = findViewById(R.id.inspector_name_title);
        textView2 = findViewById(R.id.inspector_name);
        textView3 = findViewById(R.id.inspector_id_title);
        textView4 = findViewById(R.id.inspector_id_no);
        textView5 = findViewById(R.id.inspector_mobile);
        textView6 = findViewById(R.id.inspector_mobile_no);
        textView7 = findViewById(R.id.inspector_email);
        textView8 = findViewById(R.id.inspector_email_id);
        spinKitView = findViewById(R.id.spin_kit);

        inspectorProfile();

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this,DashboardActivity.class);
                startActivity(intent);
            }
        });

    }

    private void inspectorProfile() {

//        String inspector_email = textView7.getText().toString();
//        String inspector_password = password.getText().toString();

        RetrofitClient retrofitClient = RetrofitClient.getInstance();

        HashMap<String, String> headerMap = PreferenceUtils.getHeaderMap(getApplicationContext());

        HashMap<String, String> params = new HashMap<>();


        params.put("inspector_token",PreferenceUtils.getStringValue(getApplicationContext(),UserToken));
        params.put("inspector_id", PreferenceUtils.getStringValue(getApplicationContext(),inspector_id));


        Call<LoginResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .profile(headerMap, params);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                Log.e("Login","Response: "+new Gson().toJson(response.body()));
                LoginResponse registerResponse = response.body();
                textView2.setText(registerResponse.getResult().getInspectorData().getInspectorName());
                textView6.setText(registerResponse.getResult().getInspectorData().getInspectorMobile());
                textView8.setText(registerResponse.getResult().getInspectorData().getInspectorEmail());
                textView4.setText(registerResponse.getResult().getInspectorData().getInspectorSequenceId());

                spinKitView.setVisibility(View.GONE);

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

                spinKitView.setVisibility(View.GONE);

            }
        });
    }
}



