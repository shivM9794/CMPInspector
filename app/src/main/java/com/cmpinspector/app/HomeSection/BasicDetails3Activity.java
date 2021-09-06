package com.cmpinspector.app.HomeSection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.cmpinspector.app.ModelResponse.PropertyData;

import com.cmpinspector.app.ModelResponse.StepThree.Image;
import com.cmpinspector.app.ModelResponse.StepThree.PropertyData3;
import com.cmpinspector.app.ModelResponse.StepThree.StepThreeResponse;
import com.cmpinspector.app.R;
import com.cmpinspector.app.Retrofit.RetrofitClient;
import com.cmpinspector.app.Utility.PreferenceUtils;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BasicDetails3Activity extends AppCompatActivity {
    Button edit_3, next_btn;
    ImageView imageView, imageView1, imageView2, imageView3, imageView4;
    String property_id;
    TextView desc_box;
    String BASE_URL = "https://apkconnectlab.com/cmpdtest/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_details3);
        edit_3 = findViewById(R.id.edit3);
        desc_box = findViewById(R.id.txt_descp_box);
        imageView = findViewById(R.id.basic_detail3_img);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BasicDetails3Activity.this, BasicDetails1Activity.class);
                startActivity(intent);
            }
        });
        next_btn = findViewById(R.id.detail3_next_btn);
        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BasicDetails3Activity.this, DeclarationActivity.class);
                startActivity(i);
            }
        });
        edit_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(BasicDetails3Activity.this, BasicDetails3_Save_Activity.class);
                startActivity(i1);
            }
        });
        imageView1 = findViewById(R.id.step3_img1);
        imageView2 = findViewById(R.id.step3_img2);
        imageView3 = findViewById(R.id.step3_img3);
        imageView4 = findViewById(R.id.step3_img4);

        step_three();
    }

    private void step_three() {

        RetrofitClient retrofitClient = RetrofitClient.getInstance();
        HashMap<String, String> headerMap = PreferenceUtils.getHeaderMap(this);
        HashMap<String, String> params = new HashMap<>();


        params.put("inspector_id", PreferenceUtils.getStringValue(getApplicationContext(), PreferenceUtils.inspector_id));
        params.put("inspector_token", PreferenceUtils.getStringValue(getApplicationContext(), PreferenceUtils.UserToken));
        params.put("property_id", PreferenceUtils.getStringValue(getApplicationContext(), PreferenceUtils.property_id));


        Call<StepThreeResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .step_threeResponse(headerMap, params);
        call.enqueue(new Callback<StepThreeResponse>() {
            @Override
            public void onResponse(Call<StepThreeResponse> call, Response<StepThreeResponse> response) {
                Log.e("StepThreeResponse", "Successfully data fetched " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    StepThreeResponse stepThreeResponse = response.body();
                    PropertyData3 propertyData3 = stepThreeResponse.getResult().getPropertyData();
                    desc_box.setText(propertyData3.getPropertyDetailsData().getDescription());
                    if (response.body().getSuccess() == 1) {
                        if (stepThreeResponse.getResult()
                                .getPropertyData().getPropertyDetailsData().getImages().isEmpty()){
                            return;
                        }

                        Glide.with(getApplicationContext()).load(BASE_URL + stepThreeResponse.getResult()
                                .getPropertyData().getPropertyDetailsData().getImages().get(0).getPropertyImage()).into(imageView1);

                        if (stepThreeResponse.getResult()
                                .getPropertyData().getPropertyDetailsData().getImages().size()>1){
                            Glide.with(getApplicationContext()).load(BASE_URL + stepThreeResponse.getResult()
                                    .getPropertyData().getPropertyDetailsData().getImages().get(1).getPropertyImage()).into(imageView2);

                        }
                        if (stepThreeResponse.getResult()
                                .getPropertyData().getPropertyDetailsData().getImages().size()>2){
                            Glide.with(getApplicationContext()).load(BASE_URL + stepThreeResponse.getResult()
                                    .getPropertyData().getPropertyDetailsData().getImages().get(2).getPropertyImage()).into(imageView3);

                        }

                        if (stepThreeResponse.getResult()
                                .getPropertyData().getPropertyDetailsData().getImages().size()>3){
                            Glide.with(getApplicationContext()).load(BASE_URL + stepThreeResponse.getResult()
                                    .getPropertyData().getPropertyDetailsData().getImages().get(2).getPropertyImage()).into(imageView3);
                        }

                        if (stepThreeResponse.getResult()
                                .getPropertyData().getPropertyDetailsData().getImages().size()>4){
                            Glide.with(getApplicationContext()).load(BASE_URL + stepThreeResponse.getResult()
                                    .getPropertyData().getPropertyDetailsData().getImages().get(3).getPropertyImage()).into(imageView4);
                        }


                        Toast.makeText(getApplicationContext(), stepThreeResponse.getMessage(), Toast.LENGTH_SHORT).show();


                    } else {
                        Toast.makeText(getApplicationContext(), "No Data Fetched", Toast.LENGTH_SHORT).show();
                    }
                }


            }


            @Override
            public void onFailure(Call<StepThreeResponse> call, Throwable t) {
                Log.e("StepThreeResponse", "Data not found " + new Gson().toJson(t.getMessage()));
                Toast.makeText(BasicDetails3Activity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }
}