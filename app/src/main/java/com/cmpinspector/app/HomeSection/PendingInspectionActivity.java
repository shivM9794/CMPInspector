package com.cmpinspector.app.HomeSection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cmpinspector.app.CMPAdapters.PendingListAdapter;
import com.cmpinspector.app.CMPAdapters.PendingListHelperClass;
import com.cmpinspector.app.ModelResponse.CompleteInspectionData.PendInspectedpropertyDatum;
import com.cmpinspector.app.ModelResponse.DashboardResponse;
import com.cmpinspector.app.ModelResponse.LoginResponse;
import com.cmpinspector.app.ModelResponse.PropertyData;
import com.cmpinspector.app.R;
import com.cmpinspector.app.Retrofit.RetrofitClient;
import com.cmpinspector.app.Utility.PreferenceUtils;

import com.github.ybq.android.spinkit.SpinKitView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import me.ibrahimsn.lib.OnItemSelectedListener;
import me.ibrahimsn.lib.SmoothBottomBar;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PendingInspectionActivity extends AppCompatActivity {
    RecyclerView pendingRecycler;
    RecyclerView.Adapter adapter;
    ImageView imageView;
    SmoothBottomBar bottomNavigationView;
    TextView textView;
    List<PendInspectedpropertyDatum> pendInspectedpropertyData;
    private SpinKitView spinKitView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pending_inspection);

        spinKitView = findViewById(R.id.spin_kit);

        imageView = findViewById(R.id.back_icon_pending);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PendingInspectionActivity.this,DashboardActivity.class);
                startActivity(intent);
            }
        });
        pendingRecycler = findViewById(R.id.property_pending_recycler);
        pendingRecycler();
        textView = findViewById(R.id.txt_card1);

        pendingInspection();
        pendingDetails();


        bottomNavigationView = findViewById(R.id.bottom_navigation);


    }


    private void pendingRecycler() {
        pendingRecycler.setHasFixedSize(true);
        pendingRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        ArrayList<PendingListHelperClass> pendingLocations = new ArrayList<>();
        pendingLocations.add(new PendingListHelperClass(R.drawable.dashboard_cmp));
        pendingLocations.add(new PendingListHelperClass(R.drawable.dashboard_cmp));
        pendingLocations.add(new PendingListHelperClass(R.drawable.dashboard_cmp));
        pendingLocations.add(new PendingListHelperClass(R.drawable.dashboard_cmp));
        pendingLocations.add(new PendingListHelperClass(R.drawable.dashboard_cmp));
        pendingLocations.add(new PendingListHelperClass(R.drawable.dashboard_cmp));

//        adapter = new PendingListAdapter(pendingLocations, this);
//        pendingRecycler.setAdapter(adapter);

    }

    private void pendingDetails() {


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
                Log.e("Login", "Response: " + new Gson().toJson(response.body()));
                LoginResponse registerResponse = response.body();
//                inspector_name.setText("Hi!! " +registerResponse.getResult().getInspectorData().getInspector_name());
//                inspector_id.setText("Inspector ID: "+registerResponse.getResult().getInspectorData().getInspector_id());


            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Log.e("DashboardResponse", "Error: " + t.getMessage());


            }
        });
    }

    private void pendingInspection() {

        RetrofitClient retrofitClient = RetrofitClient.getInstance();

        HashMap<String, String> headerMap = PreferenceUtils.getHeaderMap(this);

        HashMap<String, String> params = new HashMap<>();


        params.put("inspector_id", PreferenceUtils.getStringValue(getApplicationContext(), PreferenceUtils.inspector_id));
        params.put("inspector_token", PreferenceUtils.getStringValue(getApplicationContext(), PreferenceUtils.UserToken));

        Call<DashboardResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .dashboard(headerMap, params);
        call.enqueue(new Callback<DashboardResponse>() {
            @Override
            public void onResponse(Call<DashboardResponse> call, Response<DashboardResponse> response) {
                Log.e("DashboardResponse", "Response: " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    if (response.body().getSuccess().equals("1")) {
                        ArrayList<String> images = new ArrayList<>();
                        pendInspectedpropertyData = response.body().getResult().getPendInspectedpropertyData();
                        for (int i = 0; i < pendInspectedpropertyData.size(); i++) {
                            for (int j = 0; j < pendInspectedpropertyData.get(i).getImages().size(); j++) {
                                images.add(pendInspectedpropertyData.get(i).getImages().get(j).getPropertyImage());
                            }


                        }
                        adapter = new PendingListAdapter(pendInspectedpropertyData, getApplicationContext());
//                        adapter = new PendingListAdapter(images,getApplicationContext());
                        pendingRecycler.setAdapter(adapter);

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





