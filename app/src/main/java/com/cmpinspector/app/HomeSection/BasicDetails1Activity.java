package com.cmpinspector.app.HomeSection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cmpinspector.app.CMPAdapters.BasicDetails1Adapter;
import com.cmpinspector.app.CMPAdapters.SelectPropertyAdapter;
import com.cmpinspector.app.Images.EidOrPassport;
import com.cmpinspector.app.Images.TitleDeedImage;
import com.cmpinspector.app.ModelResponse.StepOneAndTwo.KindOfProperty;
import com.cmpinspector.app.ModelResponse.StepOneAndTwo.PropertyData;
import com.cmpinspector.app.ModelResponse.StepOneAndTwo.PropertyType;
import com.cmpinspector.app.ModelResponse.StepOneAndTwo.StepOneAndTwoResponse;
import com.cmpinspector.app.R;
import com.cmpinspector.app.Retrofit.RetrofitClient;
import com.cmpinspector.app.Utility.PreferenceUtils;
import com.github.ybq.android.spinkit.SpinKitView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BasicDetails1Activity extends AppCompatActivity  {
    Button button, edit_1, deed, eid;
    TextView residental, address_field, apartment, no_of_bedrooms, area_details, locationname, type_of_property;
    ImageView imageView;
    BasicDetails1Adapter basicDetails1Adapter;
    RecyclerView recyclerView, recyclerView2, recyclerView3;
    String property_id;
    String sub_catid;
    String cat_id;
    private SpinKitView spinKitView;
    String path="";
    String eid_path="",address="Test Address";
    String kind_prop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_details1);
        locationname = findViewById(R.id.location_place);
        residental = findViewById(R.id.residental);
        address_field = findViewById(R.id.address_box);
        deed = findViewById(R.id.deed_btn);
        eid = findViewById(R.id.eid_btn);
        type_of_property = findViewById(R.id.textView6);
        apartment = findViewById(R.id.apartment);
        no_of_bedrooms = findViewById(R.id.textView4);
        area_details = findViewById(R.id.txt_areadetails);
        spinKitView = findViewById(R.id.spin_kit);


        property_id = getIntent().getStringExtra("property_id");

        imageView = findViewById(R.id.basic_detail1_img);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
//                Intent intent = new Intent(BasicDetails1Activity.this, PendingInspectionActivity.class);
//                startActivity(intent);
            }
        });
        deed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendimage = new Intent(BasicDetails1Activity.this, TitleDeedImage.class);
                sendimage.putExtra("image",path);
                startActivity(sendimage);
            }
        });

        eid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendimage = new Intent(BasicDetails1Activity.this, EidOrPassport.class);
                sendimage.putExtra("image",eid_path);
                startActivity(sendimage);
            }
        });


//        recyclerView = findViewById(R.id.recycler);
//        recyclerView2 = findViewById(R.id.recycler2);
//        recyclerView3 = findViewById(R.id.recycler3);
////        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
//        recyclerView2.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
//        recyclerView3.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));


        edit_1 = findViewById(R.id.edit1);
        edit_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BasicDetails1Activity.this, BasicDetails_2_SaveActivity.class);
                i.putExtra("Address",address);
                startActivity(i);
            }
        });


        button = findViewById(R.id.details1_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BasicDetails1Activity.this, BasicDetails3Activity.class);
                startActivity(intent);
            }
        });

        step_one();

    }

    private void step_one() {

        RetrofitClient retrofitClient = RetrofitClient.getInstance();
        HashMap<String, String> headerMap = PreferenceUtils.getHeaderMap(this);
        HashMap<String, String> params = new HashMap<>();


        params.put("inspector_id", PreferenceUtils.getStringValue(getApplicationContext(), PreferenceUtils.inspector_id));
        params.put("inspector_token", PreferenceUtils.getStringValue(getApplicationContext(), PreferenceUtils.UserToken));
        params.put("property_id", PreferenceUtils.getStringValue(getApplicationContext(),PreferenceUtils.property_id));


        Call<StepOneAndTwoResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .step_one_and_two_Response(headerMap, params);
        call.enqueue(new Callback<StepOneAndTwoResponse>() {
            @Override
            public void onResponse(Call<StepOneAndTwoResponse> call, Response<StepOneAndTwoResponse> response) {
                Log.e("StepOneAndTwoResponse", "Successfully data fetched " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    StepOneAndTwoResponse stepOneAndTwoResponse = response.body();
                    if (response.body().getSuccess() == 1) {
//                        PreferenceUtils.setStringValue(getApplicationContext(), PreferenceUtils.property_id, property_id);


                        PropertyData propertyData = stepOneAndTwoResponse.getResult().getPropertyData();
                        locationname.setText(propertyData.getPropertyDetailsData().getLocationName());
//                        kind_prop=propertyData.getPropertyDetailsData().getKindOfPropertyName();
                        residental.setText(propertyData.getPropertyDetailsData().getKindOfPropertyName());
                        apartment.setText(propertyData.getPropertyDetailsData().getPropertyTypeName());
                        no_of_bedrooms.setText(String.valueOf(propertyData.getPropertyDetailsData().getNoOfBed()));
                        area_details.setText(String.valueOf(propertyData.getPropertyDetailsData().getTotalArea() + propertyData.getPropertyDetailsData().getAreaType()));
                        address_field.setText(propertyData.getPropertyDetailsData().getAddress());
                        address=propertyData.getPropertyDetailsData().getAddress();


                        path= propertyData.getPropertyDetailsData().getTitleDeed();
                        deed.setText(propertyData.getPropertyDetailsData().getTitleDeed());
                        eid_path= propertyData.getPropertyDetailsData().getEidOrPassport();
                        eid.setText(propertyData.getPropertyDetailsData().getEidOrPassport());

                        type_of_property.setText(propertyData.getPropertyDetailsData().getPropertyHolderName());

                        spinKitView.setVisibility(View.GONE);


                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Cannot fetch data", Toast.LENGTH_SHORT).show();
                        Toast.makeText(getApplicationContext(), PreferenceUtils.getStringValue(getApplicationContext(),PreferenceUtils.property_id), Toast.LENGTH_SHORT).show();
                    }
                }

            }

            @Override
            public void onFailure(Call<StepOneAndTwoResponse> call, Throwable t) {
                Log.e("StepOneAndTwoResponse", "Data not found " + new Gson().toJson(t.getMessage()));
                Toast.makeText(BasicDetails1Activity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), PreferenceUtils.getStringValue(getApplicationContext(),PreferenceUtils.property_id), Toast.LENGTH_SHORT).show();

                spinKitView.setVisibility(View.GONE);

            }
        });
    }


//    @Override
//    public void onClick(List<PropertyType> propertyType, String string) {
//
//        cat_id = string;
//
//        SelectPropertyAdapter selectPropertyAdapter = new SelectPropertyAdapter(getApplicationContext(), propertyType, BasicDetails1Activity.this);
//        recyclerView2.setAdapter(selectPropertyAdapter);
//
//    }
//
//    @Override
//    public void onClick(String string) {
//        sub_catid = string;
//    }
}
