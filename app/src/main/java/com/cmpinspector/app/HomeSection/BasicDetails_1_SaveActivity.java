package com.cmpinspector.app.HomeSection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.cmpinspector.app.R;

public class BasicDetails_1_SaveActivity extends AppCompatActivity {
    ImageView imageView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_details1_save);
        button = findViewById(R.id.btn_save1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BasicDetails_1_SaveActivity.this,BasicDetails_2_SaveActivity.class);
                startActivity(i);
            }
        });
        imageView = findViewById(R.id.basic_detail1_img1);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BasicDetails_1_SaveActivity.this,BasicDetails1Activity.class);
                startActivity(intent);
            }
        });
    }
}