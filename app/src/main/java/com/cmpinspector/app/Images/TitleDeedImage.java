package com.cmpinspector.app.Images;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.cmpinspector.app.HomeSection.BasicDetails1Activity;
import com.cmpinspector.app.ModelResponse.StepOneAndTwo.Image;
import com.cmpinspector.app.R;

public class TitleDeedImage extends AppCompatActivity {

    ImageView imageView,imageView1;
    String BASE_URL = "https://apkconnectlab.com/cmpdtest/";
    private ScaleGestureDetector scaleGestureDetector;
    private float mScaleFactor = 1.0f;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_deed_image);
        String url=getIntent().getStringExtra("image");

        scaleGestureDetector = new ScaleGestureDetector(this, new ScaleListener());

        imageView=findViewById(R.id.titledeed_img);
        imageView1= findViewById(R.id.deed_back_icon);
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TitleDeedImage.this, BasicDetails1Activity.class);
                startActivity(intent);
            }
        });

//
        Glide.with(getApplicationContext()).load(BASE_URL+url).into(imageView);


    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        scaleGestureDetector.onTouchEvent(motionEvent);
        return true;
    }
    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            mScaleFactor *= scaleGestureDetector.getScaleFactor();
            mScaleFactor = Math.max(0.1f, Math.min(mScaleFactor, 10.0f));
            imageView.setScaleX(mScaleFactor);
            imageView.setScaleY(mScaleFactor);
            return true;
        }
    }
}