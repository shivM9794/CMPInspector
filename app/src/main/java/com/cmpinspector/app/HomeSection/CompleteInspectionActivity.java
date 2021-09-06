package com.cmpinspector.app.HomeSection;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cmpinspector.app.ModelResponse.CompleteInspectionData.ComInspectedpropertyDatum;
import com.cmpinspector.app.ModelResponse.DashboardResponse;
import com.cmpinspector.app.ModelResponse.LoginResponse;
import com.cmpinspector.app.R;
import com.cmpinspector.app.Retrofit.RetrofitClient;
import com.cmpinspector.app.Utility.PreferenceUtils;
import com.github.ybq.android.spinkit.SpinKitView;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;

import me.ibrahimsn.lib.SmoothBottomBar;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CompleteInspectionActivity extends AppCompatActivity {

    RecyclerView propertyRecycler;
    RecyclerView.Adapter adapter;
    TextView cardView;
    ImageView imageView;
    SmoothBottomBar bottomNavigationView;
    List<ComInspectedpropertyDatum> comInspectedpropertyData;
    TextView ins_comp_name,ins_comp_id;
    private SpinKitView spinKitView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_inspection);

        spinKitView = findViewById(R.id.spin_kit);
        imageView = findViewById(R.id.back_icon);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CompleteInspectionActivity.this,DashboardActivity.class);
                startActivity(intent);
            }
        });
//        ins_comp_name = findViewById(R.id.ins_name_comp);
//        ins_comp_id = findViewById(R.id.ins_id_comp);
//        imageView2 = findViewById(R.id.dashboard_complete_img);
        completeResult();
        propertyRecycler = findViewById(R.id.property_recycler);
        propertyRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        cardView = findViewById(R.id.txt_card3);


        showResult();
    }


// For displaying name & id

    private void completeResult() {

        //Retrofit

        RetrofitClient retrofitClient = RetrofitClient.getInstance();

        HashMap<String, String> headerMap = PreferenceUtils.getHeaderMap(this);

        HashMap<String, String> params = new HashMap<>();


        params.put("inspector_id", PreferenceUtils.getStringValue(getApplicationContext(), PreferenceUtils.inspector_id));
        params.put("inspector_token", PreferenceUtils.getStringValue(getApplicationContext(), PreferenceUtils.UserToken));
        params.put("inspector_name", PreferenceUtils.getStringValue(getApplicationContext(), PreferenceUtils.inspector_name));


        Call<LoginResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .profile(headerMap, params);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                Log.e("Login","Response: "+new Gson().toJson(response.body()));
                LoginResponse registerResponse = response.body();
//                ins_comp_name.setText("Hi!! "+registerResponse.getResult().getInspectorData().getInspector_name());
//                ins_comp_id.setText("Inspector ID: "+registerResponse.getResult().getInspectorData().getInspector_id());


            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Log.e("DashboardResponse", "Error: " + t.getMessage());


            }
        });

        propertyRecycler = findViewById(R.id.property_recycler);
//        bottomNavigationView = findViewById(R.id.bottom_navigation);
//
//        bottomNavigationView.setOnItemSelectedListener((OnItemSelectedListener) i -> {
//            switch (i){
//                case 0:
//                    Intent intent = new Intent(getApplicationContext(),DashboardActivity.class);
//                    startActivity(intent);
//                    break;
//                case 1:
//                    Intent intent1 = new Intent(getApplicationContext(),ProfileActivity.class);
//                    startActivity(intent1);
//                    break;
//
//
//            }
//
//
//            return true;
//        });

    }


//  For showing the recyclerview card design

    public void showResult() {

        //Retrofit

        RetrofitClient retrofitClient = RetrofitClient.getInstance();
        HashMap<String, String> headerMap = PreferenceUtils.getHeaderMap(this);
        HashMap<String, String> params = new HashMap<>();


        params.put("inspector_id", PreferenceUtils.getStringValue(getApplicationContext(), PreferenceUtils.inspector_id));
        params.put("inspector_token", PreferenceUtils.getStringValue(getApplicationContext(), PreferenceUtils.UserToken));


        Call<DashboardResponse> call = RetrofitClient.getInstance().getApi().dashboard(headerMap, params);
        call.enqueue(new Callback<DashboardResponse>() {
            @Override
            public void onResponse(Call<DashboardResponse> call, Response<DashboardResponse> response) {
                Log.e("DashboardResponse", "Response: " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    if (response.body().getSuccess().equals("1")) {
                        comInspectedpropertyData = response.body().getResult().getComInspectedpropertyData();
                        adapter = new PropertyAdapter(comInspectedpropertyData, getApplicationContext());
                        propertyRecycler.setAdapter(adapter);

                        spinKitView.setVisibility(View.GONE);
                    }
                }

            }

            @Override
            public void onFailure(Call<DashboardResponse> call, Throwable t) {
                Log.e("DashboardResponse", "Error: " + t.getMessage());

                spinKitView.setVisibility(View.GONE);


            }
        });
    }
}