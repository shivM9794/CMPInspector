package com.cmpinspector.app.HomeSection;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.cmpinspector.app.CMPAdapters.DashboardPropertyImagesAdapter;
import com.cmpinspector.app.LoginSection.LoginActivity;
import com.cmpinspector.app.ModelResponse.LoginResponse;
import com.cmpinspector.app.ModelResponse.Logout.InspectorData;
import com.cmpinspector.app.ModelResponse.Logout.LogoutResponse;
import com.cmpinspector.app.ModelResponse.PropertyData;
import com.cmpinspector.app.R;
import com.cmpinspector.app.Retrofit.RetrofitClient;
import com.cmpinspector.app.Utility.PreferenceUtils;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import me.ibrahimsn.lib.OnItemSelectedListener;
import me.ibrahimsn.lib.SmoothBottomBar;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardActivity extends AppCompatActivity {
    RecyclerView propertyRecycler;
    RecyclerView.Adapter adapter;
    TextView cardView, carvView1;
    ArrayList<PropertyData> propertyData;
    SmoothBottomBar bottomNavigationView;
    TextView ins_name, ins_id;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ins_name = findViewById(R.id.txt_dash1);
        ins_id = findViewById(R.id.insp_id);
        imageView = findViewById(R.id.dashboard_img);
        propertyRecycler = findViewById(R.id.property_recycler);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener((OnItemSelectedListener) i -> {
            switch (i){
                case 0:
                    Intent intent = new Intent(getApplicationContext(),DashboardActivity.class);
                    startActivity(intent);
                    break;
                case 1:
                    Intent intent1 = new Intent(getApplicationContext(),ProfileActivity.class);
                    startActivity(intent1);
                    break;
                case 2:

                    AlertDialog.Builder builder = new AlertDialog.Builder(DashboardActivity.this);
                    builder.setTitle("CMP Inspector");
                    builder.setMessage("Are you sure you want to exit ?");
                    builder.setCancelable(false);
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            setLogout();
//                            finish();
                        }
                    });
                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
//                            dialog.dismiss();
//                            finish();

                        }
                    });
                    builder.create().show();

//                    setLogout();
                    break;
            }

            return true;
        });

//   Images appearing on dashboard in viewpager

        ViewPager2 locationViewPager = findViewById(R.id.property_images);
        List<DashboardPropertyImages> dashboardPropertyImages = new ArrayList<>();
        DashboardPropertyImages travelLocationDubai = new DashboardPropertyImages();
        travelLocationDubai.imageUrl="https://www.arabianbusiness.com/public/images/2020/12/08/arabianranches.jpg";
        travelLocationDubai.title= "Dubai";
        travelLocationDubai.location= "Downtown";
        dashboardPropertyImages.add(travelLocationDubai);


        DashboardPropertyImages travelLocationDubai1 = new DashboardPropertyImages();
        travelLocationDubai1.imageUrl="https://danubeproperties.ae/media/05-11-2018.jpg";
        travelLocationDubai1.title= "Dubai";
        travelLocationDubai1.location= "Downtown";
        dashboardPropertyImages.add(travelLocationDubai1);

        DashboardPropertyImages travelLocationDubai2 = new DashboardPropertyImages();
        travelLocationDubai2.imageUrl="https://www.arabianbusiness.com/public/images/2020/12/08/arabianranches.jpg";
        travelLocationDubai2.title= "Dubai";
        travelLocationDubai2.location= "Downtown";
        dashboardPropertyImages.add(travelLocationDubai2);

        DashboardPropertyImages travelLocationDubai3 = new DashboardPropertyImages();
        travelLocationDubai3.imageUrl="https://luxury-houses.net/wp-content/uploads/2020/12/Design-Concept-of-the-Most-Outstanding-Mansion-in-Dubai-1.jpg";
        travelLocationDubai3.title= "Dubai";
        travelLocationDubai3.location= "Downtown";
        dashboardPropertyImages.add(travelLocationDubai3);

        DashboardPropertyImages travelLocationDubai4 = new DashboardPropertyImages();
        travelLocationDubai4.imageUrl="https://im.proptiger.com/1/1798609/6/alvorado-elevation-24383448.jpeg";
        travelLocationDubai4.title= "Dubai";
        travelLocationDubai4.location= "Downtown";
        dashboardPropertyImages.add(travelLocationDubai4);

        DashboardPropertyImages travelLocationDubai5 = new DashboardPropertyImages();
        travelLocationDubai5.imageUrl="https://exp.cdn-hotels.com/hotels/22000000/21600000/21591800/21591754/a6d1e65d_z.jpg?impolicy=fcrop&w=500&h=333&q=medium";
        travelLocationDubai5.title= "Dubai";
        travelLocationDubai5.location= "Downtown";
        dashboardPropertyImages.add(travelLocationDubai5);

        locationViewPager.setAdapter(new DashboardPropertyImagesAdapter(dashboardPropertyImages));

        showResult();
        cardView = findViewById(R.id.txt_card1);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, PendingInspectionActivity.class);
                startActivity(intent);
            }
        });
        carvView1 = findViewById(R.id.txt_card3);
        carvView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashboardActivity.this, CompleteInspectionActivity.class);
                startActivity(i);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this,ProfileActivity.class);
                startActivity(intent);
            }
        });

    }


// Inspector Profile Information

    public void showResult() {

        //Retrofit

        RetrofitClient retrofitClient = RetrofitClient.getInstance();

        HashMap<String, String> headerMap = PreferenceUtils.getHeaderMap(this);

        HashMap<String, String> params = new HashMap<>();


        params.put("inspector_id", PreferenceUtils.getStringValue(getApplicationContext(), PreferenceUtils.inspector_id));
        params.put("inspector_token", PreferenceUtils.getStringValue(getApplicationContext(), PreferenceUtils.UserToken));
        params.put("inspector_name", PreferenceUtils.getStringValue(getApplicationContext(), PreferenceUtils.inspector_name));
        Log.e("Login", "Response: " +params.toString());

        Call<LoginResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .profile(headerMap, params);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                Log.e("Login", "Response: " + new Gson().toJson(response.body()));
                LoginResponse registerResponse = response.body();
                ins_name.setText(registerResponse.getResult().getInspectorData().getInspectorName());
                ins_id.setText("Inspector ID: "+registerResponse.getResult().getInspectorData().getInspectorSequenceId());


            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Log.e("DashboardResponse", "Error: " + t.getMessage());


            }
        });
    }

//    Logout Api

    private void setLogout() {


        RetrofitClient retrofitClient = RetrofitClient.getInstance();

        HashMap<String, String> headerMap = PreferenceUtils.getHeaderMap(this);

        HashMap<String, String> params = new HashMap<>();


        params.put("inspector_id", PreferenceUtils.getStringValue(getApplicationContext(), PreferenceUtils.inspector_id));
        params.put("inspector_token", PreferenceUtils.getStringValue(getApplicationContext(), PreferenceUtils.UserToken));

        PreferenceUtils.setBoolValue(getApplicationContext(),PreferenceUtils.isLogin,false);


        Call<LogoutResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .logout(headerMap, params);
        call.enqueue(new Callback<LogoutResponse>() {
            @Override
            public void onResponse(Call<LogoutResponse> call, Response<LogoutResponse> response) {
                Log.e("Logout", "Response: " + new Gson().toJson(response.body()));
                if (response.body()!= null){
                    LogoutResponse logoutResponse = response.body();
                    if(logoutResponse.getSuccess()==1){
                        InspectorData inspectorData = logoutResponse.getResult().getInspectorData();
                        Toast.makeText(getApplicationContext(), logoutResponse.getMessage(), Toast.LENGTH_SHORT).show();
//                        Intent intent = new Intent(DashboardActivity.this, LoginActivity.class);
//                        startActivity(intent);
                        finish();
                    }
                }

            }

            @Override
            public void onFailure(Call<LogoutResponse> call, Throwable t) {
                Log.e("LogoutResponse", "Error: " + t.getMessage());


            }
        });


    }
}