package com.cmpinspector.app.HomeSection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.cmpinspector.app.ModelResponse.StepFourSubmit.PropertyData;
import com.cmpinspector.app.ModelResponse.StepFourSubmit.StepFourResponse;
import com.cmpinspector.app.R;
import com.cmpinspector.app.Retrofit.RetrofitClient;
import com.cmpinspector.app.Utility.PreferenceUtils;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DeclarationActivity extends AppCompatActivity {
    ImageView imageView;
    Button reject_btn, approve_btn;
    Button submit_btn;
    PopupWindow popupWindow;
    ConstraintLayout constraintLayout;
    EditText desc_box;
    TextInputEditText dewa_no1, gas_no1, expected_price1, des1;
    CheckBox cb_basic_detail, cb_property_detail, cb_property_image;
    String expected_price = "";
    String inspector_description = "";
    String basic_details_verify = "Y";
    String property_details_verify = "Y";
    String property_image_verify = "Y";
    String dewa_no = "";
    String gas_no = "";
    String status="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_declaration);
        imageView = findViewById(R.id.declaration_back_icon);

//        Hooks for text_input_edit_text

        dewa_no1 = findViewById(R.id.declaration_field_dewa);
        gas_no1 = findViewById(R.id.declaration_gas_no);
        expected_price1 = findViewById(R.id.excepted_price_no);
        des1 = findViewById(R.id.declaration_comment_box);


//        Hooks for checkbox

        cb_basic_detail = findViewById(R.id.cb_basic_details);
        cb_property_detail = findViewById(R.id.cb_property_details);
        cb_property_image = findViewById(R.id.cb_property_img);


        constraintLayout = findViewById(R.id.declaration_page);

//        Hook for buttons

        reject_btn = findViewById(R.id.btn_reject);
        approve_btn = findViewById(R.id.button);
        approve_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                status = "IV";
                inspector_description = des1.getText().toString();

                step_four();
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DeclarationActivity.this, DashboardActivity.class);
                startActivity(intent);
            }
        });

        cb_basic_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cb_basic_detail.isChecked()) {
                    cb_basic_detail.setTextColor(getResources().getColor(R.color.btn_bg));
                } else {
                    cb_basic_detail.setTextColor(getResources().getColor(R.color.black));
                }

            }
        });

        cb_property_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cb_property_detail.isChecked()) {
                    cb_property_detail.setTextColor(getResources().getColor(R.color.btn_bg));
                } else {
                    cb_property_detail.setTextColor(getResources().getColor(R.color.black));
                }

            }
        });

        cb_property_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cb_property_image.isChecked()) {
                    cb_property_image.setTextColor(getResources().getColor(R.color.btn_bg));
                } else {
                    cb_property_image.setTextColor(getResources().getColor(R.color.black));
                }

            }
        });

        reject_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater layoutInflater = (LayoutInflater) DeclarationActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View customView = layoutInflater.inflate(R.layout.activity_popup, null);



                desc_box=customView.findViewById(R.id.desc_box);
                submit_btn = customView.findViewById(R.id.submit_button);

                popupWindow = new PopupWindow(customView, ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);


                popupWindow.showAtLocation(constraintLayout, Gravity.CENTER, 0, 0);
                popupWindow.setFocusable(true);
                popupWindow.update();


                submit_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        status = "IR";
                        inspector_description = desc_box.getText().toString();
                        step_four();

                        popupWindow.dismiss();

                    }
                });
            }
        });
    }


    private void step_four() {

        expected_price = expected_price1.getText().toString();
        dewa_no = dewa_no1.getText().toString();
        gas_no = gas_no1.getText().toString();
//        inspector_description = des1.getText().toString();
////        inspector_description= textInputEditText.getText().toString();

        RetrofitClient retrofitClient = RetrofitClient.getInstance();
        HashMap<String, String> headerMap = PreferenceUtils.getHeaderMap(this);
        HashMap<String, String> params = new HashMap<>();


        params.put("inspector_id", PreferenceUtils.getStringValue(getApplicationContext(), PreferenceUtils.inspector_id));
        params.put("inspector_token", PreferenceUtils.getStringValue(getApplicationContext(), PreferenceUtils.UserToken));
        params.put("property_id", PreferenceUtils.getStringValue(getApplicationContext(), PreferenceUtils.property_id));
        params.put("expected_price", expected_price);
        params.put("inspector_description", inspector_description);
        params.put("basic_details_verify", basic_details_verify);
        params.put("property_details_verify", property_details_verify);
        params.put("property_image_verify", property_image_verify);
        params.put("dewa_no", dewa_no);
        params.put("gas_no", gas_no);
        params.put("property_verified",status);
        Log.e("StepFourResponse",params.toString() );

        Call<StepFourResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .step_four_sub(headerMap, params);
        call.enqueue(new Callback<StepFourResponse>() {
            @Override
            public void onResponse(Call<StepFourResponse> call, Response<StepFourResponse> response) {
                Log.e("StepFourResponse", "Successfully data fetched " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    StepFourResponse stepFourResponse = response.body();
                    if (response.body().getSuccess() == 1) {
                        PropertyData propertyData = stepFourResponse.getResult().getPropertyData();
                        Toast.makeText(getApplicationContext(), "Successfully Status Changed", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(DeclarationActivity.this, DashboardActivity.class);
                        startActivity(intent);

                    } else {
                        Toast.makeText(getApplicationContext(), PreferenceUtils.getStringValue(getApplicationContext(), PreferenceUtils.property_id), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<StepFourResponse> call, Throwable t) {
                Log.e("StepFourResponse", "Data not found " + new Gson().toJson(t.getMessage()));
                Toast.makeText(DeclarationActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();


            }
        });


    }


}