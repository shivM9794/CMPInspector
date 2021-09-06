package com.cmpinspector.app.HomeSection;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.provider.MediaStore;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.cmpinspector.app.CMPAdapters.BasicDetails1Adapter;
import com.cmpinspector.app.CMPAdapters.SelectPropertyAdapter;
import com.cmpinspector.app.CMPAdapters.TypePropertyAdapter;
import com.cmpinspector.app.CMPAdapters.onClick;
import com.cmpinspector.app.ModelResponse.DashboardResponse;
import com.cmpinspector.app.ModelResponse.PropertyData;
import com.cmpinspector.app.ModelResponse.StepOneAndTwo.KindOfProperty;
import com.cmpinspector.app.ModelResponse.StepOneAndTwo.LocationDatum;
import com.cmpinspector.app.ModelResponse.StepOneAndTwo.PropertyHolder;
import com.cmpinspector.app.ModelResponse.StepOneAndTwo.PropertyType;
import com.cmpinspector.app.ModelResponse.StepOneAndTwo.StepOneAndTwoResponse;
import com.cmpinspector.app.ModelResponse.StepOneAndTwoSave.StepOneAndTwoSaveResponse;
import com.cmpinspector.app.ModelResponse.StepThreeAddPropertyImages.FilePath;
import com.cmpinspector.app.R;
import com.cmpinspector.app.Retrofit.RetrofitClient;
import com.cmpinspector.app.Utility.PreferenceUtils;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BasicDetails_2_SaveActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, BasicDetails1Adapter.OnclickListener, SelectPropertyAdapter.OnclickListener, TypePropertyAdapter.OnclickListener, onClick {
    ImageView imageView;
    TextInputEditText textInputEditText1, textInputEditText2,txt_areadetails;
    Button btn_location, btn1;
    TextView titledeedimg, eid_passport_btn;
    Spinner spinner;
    BasicDetails1Adapter basicDetails1Adapter;
    RecyclerView recyclerView, recyclerView2, recyclerView3;
    String property_id;
    ArrayList<PropertyData> propertyData;
    ArrayList<PropertyHolder> propertyHolders;
    private static final int PERMISSION_READ_STATE = 1;
    String no_of_bed = "", area_type = "sq.m", areadetails = "", prop_holder = "100000000000001", current_loc = "", buffer = "",location_id="",bed_no="",address="Test Address";
    String sub_catid;
    String cat_id;
    String imagePath = "";
    String title_deed = "./assets/propertyImage/1630393387997823.png",
            eid_or_passport = "./assets/propertyImage/1630393387997823.png",
            power_of_attorney = "./assets/propertyImage/1630393387997823.png",
            trade_license = "./assets/propertyImage/1630393387997823.png",
            eidd = "./assets/propertyImage/1630393387997823.png";
    LocationRequest locationRequest;
    TextView edit_deed, edit_eid, edit_tradelicense, eid, poa;
    ImageView plus_button_deed, eid_plus_button, license_plus_button, eid_button, poa_button;
    TextView eid_passimg,tra_lic_img,eid_com_img,poa_img;
    AutoCompleteTextView location_place_save,text_bed_no;
    ArrayList<String> locationData;
    List<LocationDatum> data;
    String title_deeds="",eids="",trade_licenses="",poas="",passport="";
    List<MultipartBody.Part> files,files1,files2,files3,files4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_details2_save);

        textInputEditText1 = findViewById(R.id.location_field1);
        textInputEditText2 = findViewById(R.id.no_of_bedrooms);
        btn_location = findViewById(R.id.use_location_2);
        txt_areadetails= findViewById(R.id.txt_areadetails);
        location_place_save = findViewById(R.id.location_place_save);
        text_bed_no = findViewById(R.id.text_bed_no);
        address= getIntent().getStringExtra("Address");
        titledeedimg=findViewById(R.id.titledeedimg);
        eid_passimg=findViewById(R.id.eid_passimg);
        tra_lic_img=findViewById(R.id.tra_lic_img);
        eid_com_img=findViewById(R.id.eid_com_img);
        poa_img=findViewById(R.id.poa_img);
        plus_button_deed = findViewById(R.id.plus_button_deed);
        eid_plus_button = findViewById(R.id.eid_plus_button);
        license_plus_button = findViewById(R.id.license_plus_button);
        eid_button = findViewById(R.id.eid_button);
        poa_button = findViewById(R.id.poa_button);
        edit_deed = findViewById(R.id.edit_deed);
        edit_eid = findViewById(R.id.edit_eid);
        edit_tradelicense = findViewById(R.id.edit_tradelicense);
        eid = findViewById(R.id.eid);
        poa = findViewById(R.id.poa);
        titledeedimg = findViewById(R.id.titledeedimg);
        eid_passport_btn = findViewById(R.id.eid_btn);
        recyclerView = findViewById(R.id.recycler);
        recyclerView2 = findViewById(R.id.recycler2);
        recyclerView3 = findViewById(R.id.recycler3);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        recyclerView2.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        recyclerView3.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        step_one_save();
        step_one_two_submit();
        get_bedno();
        getCurrentLocation();



        titledeedimg.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int DRAWABLE_LEFT = 0;
                final int DRAWABLE_TOP = 1;
                final int DRAWABLE_RIGHT = 2;
                final int DRAWABLE_BOTTOM = 3;

                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    if(event.getRawX() >= (titledeedimg.getRight() - titledeedimg.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        titledeedimg.setText(null);

                        return true;
                    }
                }
                return false;
            }
        });

        eid_passimg.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int DRAWABLE_LEFT = 0;
                final int DRAWABLE_TOP = 1;
                final int DRAWABLE_RIGHT = 2;
                final int DRAWABLE_BOTTOM = 3;

                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    if(event.getRawX() >= (eid_passimg.getRight() - eid_passimg.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        eid_passimg.setText(null);

                        return true;
                    }
                }
                return false;
            }
        });

        tra_lic_img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int DRAWABLE_LEFT = 0;
                final int DRAWABLE_TOP = 1;
                final int DRAWABLE_RIGHT = 2;
                final int DRAWABLE_BOTTOM = 3;

                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    if(event.getRawX() >= (tra_lic_img.getRight() - tra_lic_img.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        tra_lic_img.setText(null);

                        return true;
                    }
                }
                return false;
            }
        });

        poa_img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int DRAWABLE_LEFT = 0;
                final int DRAWABLE_TOP = 1;
                final int DRAWABLE_RIGHT = 2;
                final int DRAWABLE_BOTTOM = 3;

                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    if(event.getRawX() >= (poa_img.getRight() - poa_img.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        poa_img.setText(null);

                        return true;
                    }
                }
                return false;
            }
        });

        eid_com_img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int DRAWABLE_LEFT = 0;
                final int DRAWABLE_TOP = 1;
                final int DRAWABLE_RIGHT = 2;
                final int DRAWABLE_BOTTOM = 3;

                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    if(event.getRawX() >= (eid_com_img.getRight() - eid_com_img.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        eid_com_img.setText(null);

                        return true;
                    }
                }
                return false;
            }
        });



        btn_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isGPSEnabled()) {



                } else {

                    turnOnGPS();
                }

               /* getLocation();

               ActivityCompat.requestPermissions( getActivity(),
                        new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);

                        locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
                        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                            OnGPS();
                        } else {
                            getLocation();
                        }*/
            }



        });


        imageView = findViewById(R.id.basic_detail2_img2);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BasicDetails_2_SaveActivity.this, BasicDetails1Activity.class);
                startActivity(intent);

            }
        });
        btn1 = findViewById(R.id.save2_btn);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                step_one_two_submit();
                Intent i = new Intent(BasicDetails_2_SaveActivity.this, BasicDetails3_Save_Activity.class);
                startActivity(i);
            }
        });

        spinner = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.units, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        titledeedimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    requestPermission();
                }

                Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent, 0);


            }
        });
        eid_passimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    requestPermission();
                }

                Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent, 1);

            }
        });

        tra_lic_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    requestPermission();
                }

                Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent, 2);

            }
        });

        poa_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    requestPermission();
                }

                Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent, 3);

            }
        });

        eid_com_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    requestPermission();
                }

                Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent, 4);

            }
        });
    }


    private void getCurrentLocation() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

                if (isGPSEnabled()) {


                    LocationServices.getFusedLocationProviderClient(getApplicationContext())
                            .requestLocationUpdates(locationRequest, new LocationCallback() {
                                @Override
                                public void onLocationResult(@NonNull LocationResult locationResult) {
                                    super.onLocationResult(locationResult);

                                    LocationServices.getFusedLocationProviderClient(getApplicationContext())
                                            .removeLocationUpdates(this);

                                    if (locationResult != null && locationResult.getLocations().size() > 0) {

                                        int index = locationResult.getLocations().size() - 1;
                                        double latitude = locationResult.getLocations().get(index).getLatitude();
                                        double longitude = locationResult.getLocations().get(index).getLongitude();

                                        buffer = new StringBuilder().append(latitude).append(longitude).toString();
                                        Toast.makeText(getApplicationContext(), "Location get successfully", Toast.LENGTH_LONG).show();

                                    }
                                }
                            }, Looper.getMainLooper());

                } else {
                    turnOnGPS();
                }

            } else {
                requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            }
        }

    }

    private void turnOnGPS() {
    }


    private boolean isGPSEnabled() {

        LocationManager locationManager = null;
        boolean isEnabled = false;

        if (locationManager == null) {
            locationManager = (LocationManager) getApplicationContext().getSystemService(Context.LOCATION_SERVICE);
        }

        isEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        return isEnabled;

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
                 files = new ArrayList<>();

                Uri selectedImage = data.getData();
                String selectedFilePath = FilePath.getPath(getApplicationContext(), selectedImage);
                String[] filePathColumn = {MediaStore.Images.Media.DATA};
                Cursor cursor = getApplicationContext().getContentResolver().query(selectedImage, filePathColumn, null, null, null);
                assert cursor != null;
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                title_deeds = cursor.getString(columnIndex);
                if (title_deeds != null && !title_deeds.isEmpty()) {
                    File panFile = new File(title_deeds);
                    files.add(MultipartBody.Part.createFormData("title_deed",
                            panFile.getName(),
                            RequestBody.create(MEDIA_TYPE_PNG, panFile)));
                    titledeedimg.setText(title_deeds);

                    cursor.close();
                }
            }
            if (requestCode == 1 && resultCode == RESULT_OK && null != data) {
                // Get the Image from data
                final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/*; charset=utf-8");
                 files1 = new ArrayList<>();

                Uri selectedImage = data.getData();
                String selectedFilePath = FilePath.getPath(getApplicationContext(), selectedImage);
                String[] filePathColumn = {MediaStore.Images.Media.DATA};
                Cursor cursor = getApplicationContext().getContentResolver().query(selectedImage, filePathColumn, null, null, null);
                assert cursor != null;
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                passport = cursor.getString(columnIndex);
                if (passport != null && !passport.isEmpty()) {
                    File panFile = new File(passport);
                    files.add(MultipartBody.Part.createFormData("eid_or_passport",
                            panFile.getName(),
                            RequestBody.create(MEDIA_TYPE_PNG, panFile)));
                    eid_passimg.setText(passport);

                    cursor.close();
                }
            }

            if (requestCode == 2 && resultCode == RESULT_OK && null != data) {
                // Get the Image from data
                final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/*; charset=utf-8");
                 files2 = new ArrayList<>();

                Uri selectedImage = data.getData();
                String selectedFilePath = FilePath.getPath(getApplicationContext(), selectedImage);
                String[] filePathColumn = {MediaStore.Images.Media.DATA};
                Cursor cursor = getApplicationContext().getContentResolver().query(selectedImage, filePathColumn, null, null, null);
                assert cursor != null;
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                trade_licenses = cursor.getString(columnIndex);
                if (trade_licenses != null && !trade_licenses.isEmpty()) {
                    File panFile = new File(trade_licenses);
                    files.add(MultipartBody.Part.createFormData("teade_license",
                            panFile.getName(),
                            RequestBody.create(MEDIA_TYPE_PNG, panFile)));
                    tra_lic_img.setText(trade_licenses);

                    cursor.close();
                }
            }

            if (requestCode == 3 && resultCode == RESULT_OK && null != data) {
                // Get the Image from data
                final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/*; charset=utf-8");
                 files3 = new ArrayList<>();

                Uri selectedImage = data.getData();
                String selectedFilePath = FilePath.getPath(getApplicationContext(), selectedImage);
                String[] filePathColumn = {MediaStore.Images.Media.DATA};
                Cursor cursor = getApplicationContext().getContentResolver().query(selectedImage, filePathColumn, null, null, null);
                assert cursor != null;
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                poas = cursor.getString(columnIndex);
                if (poas != null && !poas.isEmpty()) {
                    File panFile = new File(poas);
                    files.add(MultipartBody.Part.createFormData("power_of_attorney",
                            panFile.getName(),
                            RequestBody.create(MEDIA_TYPE_PNG, panFile)));
                    poa_img.setText(poas);

                    cursor.close();
                }
            }

            if (requestCode == 4 && resultCode == RESULT_OK && null != data) {
                // Get the Image from data
                final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/*; charset=utf-8");
                files4 = new ArrayList<>();

                Uri selectedImage = data.getData();
                String selectedFilePath = FilePath.getPath(getApplicationContext(), selectedImage);
                String[] filePathColumn = {MediaStore.Images.Media.DATA};
                Cursor cursor = getApplicationContext().getContentResolver().query(selectedImage, filePathColumn, null, null, null);
                assert cursor != null;
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                eids = cursor.getString(columnIndex);
                if (eids  != null && !eids .isEmpty()) {
                    File panFile = new File(imagePath);
                    files.add(MultipartBody.Part.createFormData("eid",
                            panFile.getName(),
                            RequestBody.create(MEDIA_TYPE_PNG, panFile)));
                    eid_com_img.setText(eids );

                    cursor.close();
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void step_one_two_submit() {
        bed_no=text_bed_no.getText().toString();
        areadetails =txt_areadetails.getText().toString();

        RetrofitClient retrofitClient = RetrofitClient.getInstance();
        HashMap<String, String> headerMap = PreferenceUtils.getHeaderMap(this);
        HashMap<String, String> params = new HashMap<>();

        params.put("inspector_id", PreferenceUtils.getStringValue(getApplicationContext(), PreferenceUtils.inspector_id));
        params.put("inspector_token", PreferenceUtils.getStringValue(getApplicationContext(), PreferenceUtils.UserToken));
        params.put("property_id", PreferenceUtils.getStringValue(getApplicationContext(), PreferenceUtils.property_id));
        params.put("no_of_bed", bed_no);
        params.put("total_area", areadetails);
        params.put("area_type", area_type);
        params.put("property_holder", prop_holder);
        params.put("current_location", "30.2744952,77.9794627");
        params.put("location", "100000000000006");
        params.put("title_deed", title_deed);
        params.put("eid_or_passport", eid_or_passport);
        params.put("trade_license", trade_license);
        params.put("power_of_attorney", power_of_attorney);
        params.put("eid", eidd);
        params.put("kind_of_property", cat_id);
        params.put("property_type", sub_catid);
        params.put("address",address);
        Log.e("StepOneAndTwoSaveResponse",params.toString());


        Call<StepOneAndTwoSaveResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .step_one_two_save(headerMap, params,files,files1,files2,files3,files4);
        call.enqueue(new Callback<StepOneAndTwoSaveResponse>() {
            @Override
            public void onResponse(Call<StepOneAndTwoSaveResponse> call, Response<StepOneAndTwoSaveResponse> response) {
                Log.e("StepOneAndTwoSaveResponse", "Successfully data fetched " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    StepOneAndTwoSaveResponse stepOneAndTwoSaveResponse = response.body();
                    if (response.body().getSuccess() == 1) {
                        com.cmpinspector.app.ModelResponse.StepOneAndTwoSave.PropertyData propertyData = stepOneAndTwoSaveResponse.getResult().getPropertyData();
                        Toast.makeText(getApplicationContext(), stepOneAndTwoSaveResponse.getMessage(), Toast.LENGTH_SHORT).show();

//                        Intent i = new Intent(BasicDetails_2_SaveActivity.this, BasicDetails3_Save_Activity.class);
//                        startActivity(i);
                    }
                }

            }

            @Override
            public void onFailure(Call<StepOneAndTwoSaveResponse> call, Throwable t) {
                Log.e("StepOneAndTwoSaveResponse", "Data not found " + new Gson().toJson(t.getMessage()));
                Toast.makeText(BasicDetails_2_SaveActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }


    private void step_one_save() {

        RetrofitClient retrofitClient = RetrofitClient.getInstance();
        HashMap<String, String> headerMap = PreferenceUtils.getHeaderMap(this);
        HashMap<String, String> params = new HashMap<>();


        params.put("inspector_id", PreferenceUtils.getStringValue(getApplicationContext(), PreferenceUtils.inspector_id));
        params.put("inspector_token", PreferenceUtils.getStringValue(getApplicationContext(), PreferenceUtils.UserToken));
        params.put("property_id", PreferenceUtils.getStringValue(getApplicationContext(), PreferenceUtils.property_id));

        Call<StepOneAndTwoResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .step_one_and_two_Response(headerMap, params);
        call.enqueue(new Callback<StepOneAndTwoResponse>() {
            @Override
            public void onResponse(Call<StepOneAndTwoResponse> call, Response<StepOneAndTwoResponse> response) {
                Log.e("StepOneResponse", "Successfully data fetched " + new Gson().toJson(response.body()));
                if (response.body() != null) {
                    StepOneAndTwoResponse stepOneAndTwoResponse = response.body();
                    if (response.body().getSuccess() == 1) {
//                        PreferenceUtils.setStringValue(getApplicationContext(), PreferenceUtils.property_id, property_id);

                        List<KindOfProperty> kindOfProperties = stepOneAndTwoResponse.getResult().getKindOfProperty();
                        basicDetails1Adapter = new BasicDetails1Adapter(getApplicationContext(), kindOfProperties, BasicDetails_2_SaveActivity.this);
                        recyclerView.setAdapter(basicDetails1Adapter);

                        List<PropertyHolder> propertyHolders = stepOneAndTwoResponse.getResult().getPropertyHolder();

                        TypePropertyAdapter typePropertyAdapter = new TypePropertyAdapter(getApplicationContext(), propertyHolders, BasicDetails_2_SaveActivity.this,BasicDetails_2_SaveActivity.this);
                        recyclerView3.setAdapter(typePropertyAdapter);

                        Toast.makeText(getApplicationContext(), stepOneAndTwoResponse.getMessage(), Toast.LENGTH_SHORT).show();

                        data = stepOneAndTwoResponse.getResult().getLocationData();
                        locationData = new ArrayList<>();
                        for (LocationDatum datum : data) {
                            locationData.add(datum.getLocationName());
                        }
                        get_location();
                    }
                }
            }
            @Override
            public void onFailure(Call<StepOneAndTwoResponse> call, Throwable t) {
                Log.e("StepOneResponse", "Data not found " + new Gson().toJson(t.getMessage()));
                Toast.makeText(BasicDetails_2_SaveActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void get_location() {

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_list_item, locationData);
        location_place_save.setAdapter(adapter);
        location_place_save.setText(adapter.getItem(0), false);

        location_id = String.valueOf(data.get(0).getLocationId());
        location_place_save.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object item = parent.getItemAtPosition(position);
                location_id = String.valueOf(data.get(position).getLocationId());
            }
        });
    }

    private void get_bedno() {
        int i;
        ArrayList<String> bedno = new ArrayList<>();

        for (i = 1; i <= 20; i++) {
            bedno.add(String.valueOf(i));
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_list_item, bedno);
        text_bed_no.setAdapter(adapter);
        text_bed_no.setText(adapter.getItem(0), false);

        bed_no = bedno.get(0);
        text_bed_no.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object item = parent.getItemAtPosition(position);
                bed_no = bedno.get(position);
            }
        });

    }




    @Override
    public void onClick(List<PropertyType> propertyType, String string) {

        cat_id = string;

        SelectPropertyAdapter selectPropertyAdapter = new SelectPropertyAdapter(getApplicationContext(), propertyType, BasicDetails_2_SaveActivity.this);
        recyclerView2.setAdapter(selectPropertyAdapter);

    }

    @Override
    public void onClick(String string) {
        sub_catid = string;
    }

    @Override
    public void click(List<PropertyHolder> propertyHolders, String string,String name) {

//        cat_id = string;

        prop_holder=string;
        String holder_name = name;


        if(holder_name.equalsIgnoreCase("Individual")){
            titledeedimg.setVisibility(View.VISIBLE);
            plus_button_deed.setVisibility(View.VISIBLE);
            eid_plus_button.setVisibility(View.VISIBLE);
            eid_passimg.setVisibility(View.VISIBLE);
            edit_tradelicense.setVisibility(View.GONE);
            eid.setVisibility(View.GONE);
            poa.setVisibility(View.GONE);
            license_plus_button.setVisibility(View.GONE);
            eid_button.setVisibility(View.GONE);
            poa_button.setVisibility(View.GONE);
            tra_lic_img.setVisibility(View.GONE);
            eid_com_img.setVisibility(View.GONE);
            poa_img.setVisibility(View.GONE);
        }
        else{
            titledeedimg.setVisibility(View.GONE);
            plus_button_deed.setVisibility(View.GONE);
            eid_plus_button.setVisibility(View.GONE);
            eid_passimg.setVisibility(View.GONE);
            edit_tradelicense.setVisibility(View.VISIBLE);
            eid.setVisibility(View.VISIBLE);
            poa.setVisibility(View.VISIBLE);
            license_plus_button.setVisibility(View.VISIBLE);
            eid_button.setVisibility(View.VISIBLE);
            poa_button.setVisibility(View.VISIBLE);
            titledeedimg.setVisibility(View.GONE);
            eid_passimg.setVisibility(View.GONE);
            tra_lic_img.setVisibility(View.VISIBLE);
            eid_com_img.setVisibility(View.VISIBLE);
            poa_img.setVisibility(View.VISIBLE);
        }

        TypePropertyAdapter typePropertyAdapter = new TypePropertyAdapter(getApplicationContext(), propertyHolders, BasicDetails_2_SaveActivity.this,BasicDetails_2_SaveActivity.this);
        recyclerView3.setAdapter(typePropertyAdapter);
    }
}






