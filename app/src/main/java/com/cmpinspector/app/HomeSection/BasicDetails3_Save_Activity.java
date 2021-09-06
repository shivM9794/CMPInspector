package com.cmpinspector.app.HomeSection;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.cmpinspector.app.ModelResponse.StepThree.PropertyData3;
import com.cmpinspector.app.ModelResponse.StepThree.StepThreeResponse;
import com.cmpinspector.app.ModelResponse.StepThreeAddPropertyImages.FilePath;
import com.cmpinspector.app.ModelResponse.StepThreeAddPropertyImages.PropertyData;
import com.cmpinspector.app.ModelResponse.StepThreeAddPropertyImages.StepThreeAddImagesResponse;
import com.cmpinspector.app.ModelResponse.StepThreeSubmit.StepThreeSubmitResponse;
import com.cmpinspector.app.R;
import com.cmpinspector.app.Retrofit.RetrofitClient;
import com.cmpinspector.app.Utility.PreferenceUtils;
import com.google.gson.Gson;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class BasicDetails3_Save_Activity extends AppCompatActivity {
    Button button1;
    ImageView imageView, add_img1, add_img2, add_img3, add_img4, add_img5, add_img6;
    CardView cardView1, cardView2, cardView3, cardView4, cardView5, cardView6;
    int select_image = 0;
    private static final int PERMISSION_READ_STATE = 1;
    String imagePath = "";
    ImageView imageView1, imageView2, imageView3, imageView4, imageView5, imageView6;
    TextView textView1, textView2, textView3, textView4, textView5, textView6;
    ImageView iv1,iv2,iv3,iv4;
    TextView description_box_save;
    String BASE_URL = "https://apkconnectlab.com/cmpdtest/";
    String description="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_details3_save);
        images();
        button1 = findViewById(R.id.edit3_save);
        description_box_save  = (TextView) findViewById(R.id.desc_box_save);
        imageView = findViewById(R.id.basic_detail3_img);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(BasicDetails3_Save_Activity.this, DeclarationActivity.class);
                startActivity(intent);

                submit_step_three();
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BasicDetails3_Save_Activity.this, BasicDetails3Activity.class);
                startActivity(intent);
            }
        });

        //  Hooks for the add icon
        add_img1 = findViewById(R.id.img_icon1);
        add_img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select_image = 1;

                add_img1.setVisibility(View.GONE);
                textView1.setVisibility(View.GONE);

                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    requestPermission();
                }

                Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent, 0);

            }

        });

        add_img2 = findViewById(R.id.img_icon2);
        add_img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select_image = 2;

                add_img2.setVisibility(View.GONE);
                textView2.setVisibility(View.GONE);

                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    requestPermission();
                }

                Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent, 0);

            }

        });

        add_img3 = findViewById(R.id.img_icon3);
        add_img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select_image = 3;

                add_img3.setVisibility(View.GONE);
                textView3.setVisibility(View.GONE);

                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    requestPermission();
                }

                Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent, 0);
            }
        });
        add_img4 = findViewById(R.id.img_icon4);
        add_img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select_image = 4;

                add_img4.setVisibility(View.GONE);
                textView4.setVisibility(View.GONE);

                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    requestPermission();
                }

                Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent, 0);
            }
        });
        add_img5 = findViewById(R.id.img_icon5);
        add_img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select_image = 5;

                add_img5.setVisibility(View.GONE);
                textView5.setVisibility(View.GONE);

                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    requestPermission();
                }

                Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent, 0);
            }
        });
        add_img6 = findViewById(R.id.img_icon6);
        add_img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select_image = 6;

                add_img6.setVisibility(View.GONE);
                textView6.setVisibility(View.GONE);

                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    requestPermission();
                }

                Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent, 0);
            }
        });

        iv1 = findViewById(R.id.step3_img1_save);
        iv2 = findViewById(R.id.step3_img2_save);
        iv3 = findViewById(R.id.step3_img3_save);
        iv4 = findViewById(R.id.step3_img4_save);

//        Hooks for images inside cardview

        imageView1 = findViewById(R.id.img1);
        imageView2 = findViewById(R.id.img2);
        imageView3 = findViewById(R.id.img3);
        imageView4 = findViewById(R.id.img4);
        imageView5 = findViewById(R.id.img5);
        imageView6 = findViewById(R.id.img6);

//        Hooks for the cardview

        cardView1 = findViewById(R.id.img1_inspector);
        cardView2 = findViewById(R.id.img2_inspector);
        cardView3 = findViewById(R.id.img3_inspector);
        cardView4 = findViewById(R.id.img4_inspector);
        cardView5 = findViewById(R.id.img5_inspector);
        cardView6 = findViewById(R.id.img6_inspector);

//        Hooks for the textview which is inside the cardview

        textView1 = findViewById(R.id.txt_img1);
        textView2 = findViewById(R.id.txt_img2);
        textView3 = findViewById(R.id.txt_img3);
        textView4 = findViewById(R.id.txt_img4);
        textView5 = findViewById(R.id.txt_img5);
        textView6 = findViewById(R.id.txt_img6);




    }

    private void submit_step_three() {

        RetrofitClient retrofitClient = RetrofitClient.getInstance();
        HashMap<String, String> headerMap = PreferenceUtils.getHeaderMap(this);
        HashMap<String, String> params = new HashMap<>();

        params.put("inspector_id", PreferenceUtils.getStringValue(getApplicationContext(), PreferenceUtils.inspector_id));
        params.put("inspector_token", PreferenceUtils.getStringValue(getApplicationContext(), PreferenceUtils.UserToken));
        params.put("property_id", PreferenceUtils.getStringValue(getApplicationContext(), PreferenceUtils.property_id));
        params.put("description",description);


        Call<StepThreeSubmitResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .step_three_sub(headerMap,params);
        call.enqueue(new Callback<StepThreeSubmitResponse>() {
            @Override
            public void onResponse(Call<StepThreeSubmitResponse> call, Response<StepThreeSubmitResponse> response) {
                Log.e("StepThreeSubmitResponse", "Successfully data fetched " + new Gson().toJson(response.body()));
                if (response.body()!= null){
                    StepThreeSubmitResponse stepThreeSubmitResponse = response.body();
                    if (response.body().getSuccess()==1){

                        com.cmpinspector.app.ModelResponse.StepThreeSubmit.PropertyData propertyData = stepThreeSubmitResponse.getResult().getPropertyData();

                        Toast.makeText(getApplicationContext(), "Successfully Inserted Images", Toast.LENGTH_SHORT).show();

//                        Intent intent = new Intent(BasicDetails3_Save_Activity.this, DeclarationActivity.class);
//                        startActivity(intent);

                    }
//                    else {
//                        Toast.makeText(BasicDetails3_Save_Activity.this,"No data found", Toast.LENGTH_SHORT).show();
//                    }


                }
            }

            @Override
            public void onFailure(Call<StepThreeSubmitResponse> call, Throwable t) {
                Log.e("StepThreeSubmitResponse", "Data not found " + new Gson().toJson(t.getMessage()));
                Toast.makeText(BasicDetails3_Save_Activity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void images() {


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
                    description_box_save.setText(propertyData3.getPropertyDetailsData().getDescription());
                    if (response.body().getSuccess() == 1) {

                        if (stepThreeResponse.getResult()
                                .getPropertyData().getPropertyDetailsData().getImages().isEmpty()){
                            return;
                        }

                        Glide.with(getApplicationContext()).load(BASE_URL + stepThreeResponse.getResult()
                                .getPropertyData().getPropertyDetailsData().getImages().get(0).getPropertyImage()).into(iv1);

                        if (stepThreeResponse.getResult()
                                .getPropertyData().getPropertyDetailsData().getImages().size()>1){
                            Glide.with(getApplicationContext()).load(BASE_URL + stepThreeResponse.getResult()
                                    .getPropertyData().getPropertyDetailsData().getImages().get(1).getPropertyImage()).into(iv2);

                        }
                        if (stepThreeResponse.getResult()
                                .getPropertyData().getPropertyDetailsData().getImages().size()>2){
                            Glide.with(getApplicationContext()).load(BASE_URL + stepThreeResponse.getResult()
                                    .getPropertyData().getPropertyDetailsData().getImages().get(2).getPropertyImage()).into(iv3);

                        }

                        if (stepThreeResponse.getResult()
                                .getPropertyData().getPropertyDetailsData().getImages().size()>3){
                            Glide.with(getApplicationContext()).load(BASE_URL + stepThreeResponse.getResult()
                                    .getPropertyData().getPropertyDetailsData().getImages().get(2).getPropertyImage()).into(iv4);
                        }




//                        if (stepThreeResponse.getResult()
//                                .getPropertyData().getPropertyDetailsData().getImages().size()>4){
//                            Glide.with(getApplicationContext()).load(BASE_URL + stepThreeResponse.getResult()
//                                    .getPropertyData().getPropertyDetailsData().getImages().get(3).getPropertyImage()).into(imageView4);
//                        }


                    } else {
                        Toast.makeText(getApplicationContext(), "No Data", Toast.LENGTH_SHORT).show();
                    }
                }


            }


            @Override
            public void onFailure(Call<StepThreeResponse> call, Throwable t) {
                Log.e("StepThreeResponse", "Data not found " + new Gson().toJson(t.getMessage()));
                Toast.makeText(BasicDetails3_Save_Activity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_READ_STATE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISSION_READ_STATE: {
                if (grantResults.length > 0 && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    TelephonyManager telephonyManager = (TelephonyManager) getApplicationContext().getSystemService(Context.TELEPHONY_SERVICE);
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext(), R.style.MyAlertDialogStyle);
                    builder.setTitle("Permission Denied");
                    builder.setMessage("Without this permission the app is unable to upload photo. Do you want to deny this permission?");
                    builder.setNegativeButton("RE-TRY", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            requestPermission();
                        }
                    });
                    builder.show();

                }
            }
            break;

        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {

            if (requestCode == 0 && resultCode == RESULT_OK && null != data) {
                // Get the Image from data
                final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/*; charset=utf-8");
                List<MultipartBody.Part> files = new ArrayList<>();

                Uri selectedImage = data.getData();
                String selectedFilePath = FilePath.getPath(getApplicationContext(), selectedImage);
                String[] filePathColumn = {MediaStore.Images.Media.DATA};
                Cursor cursor = getApplicationContext().getContentResolver().query(selectedImage, filePathColumn, null, null, null);
                assert cursor != null;
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                imagePath = cursor.getString(columnIndex);
                if (imagePath != null && !imagePath.isEmpty()) {
                    File panFile = new File(imagePath);
                    files.add(MultipartBody.Part.createFormData("property_image",
                            panFile.getName(),
                            RequestBody.create(MEDIA_TYPE_PNG, panFile)));

                    if (select_image == 1)
                        imageView1.setImageBitmap(BitmapFactory.decodeFile(selectedFilePath));
                    else if (select_image == 2)
                        imageView2.setImageBitmap(BitmapFactory.decodeFile(selectedFilePath));
                    else if (select_image == 3)
                        imageView3.setImageBitmap(BitmapFactory.decodeFile(selectedFilePath));
                    else if (select_image == 4)
                        imageView4.setImageBitmap(BitmapFactory.decodeFile(selectedFilePath));
                    else if (select_image == 5)
                        imageView5.setImageBitmap(BitmapFactory.decodeFile(selectedFilePath));
                    else if (select_image == 6)
                        imageView6.setImageBitmap(BitmapFactory.decodeFile(selectedFilePath));

//                    else {
//                        Toast.makeText(getActivity(), "No Image found", Toast.LENGTH_LONG).show();
//                    }

                    cursor.close();
                    uploadImage(files);
                } else {
                    //RequestBody requestBody = RequestBody.create(MediaType.parse("*/*");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void uploadImage(List<MultipartBody.Part> files) {

        RetrofitClient retrofitClient = RetrofitClient.getInstance();
        HashMap<String, String> headerMap = PreferenceUtils.getHeaderMap(this);
        HashMap<String, String> params = new HashMap<>();

        params.put("inspector_id", PreferenceUtils.getStringValue(getApplicationContext(), PreferenceUtils.inspector_id));
        params.put("inspector_token", PreferenceUtils.getStringValue(getApplicationContext(), PreferenceUtils.UserToken));
        params.put("property_id", PreferenceUtils.getStringValue(getApplicationContext(), PreferenceUtils.property_id));

        Call<StepThreeAddImagesResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .add_property(headerMap, params, files);
        call.enqueue(new Callback<StepThreeAddImagesResponse>() {
            @Override
            public void onResponse(Call<StepThreeAddImagesResponse> call, Response<StepThreeAddImagesResponse> response) {
                Log.e("StepThreeAddImagesResponse", "Successfully data fetched " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    StepThreeAddImagesResponse stepThreeResponse = response.body();
                    if (response.body().getSuccess() == 1) {

                        PropertyData propertyData = stepThreeResponse.getResult().getPropertyData();
                        Toast.makeText(getApplicationContext(), "Insert Successfully", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<StepThreeAddImagesResponse> call, Throwable t) {
                Log.e("StepThreeAddImagesResponse", "Data not found " + new Gson().toJson(t.getMessage()));
                Toast.makeText(BasicDetails3_Save_Activity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}




