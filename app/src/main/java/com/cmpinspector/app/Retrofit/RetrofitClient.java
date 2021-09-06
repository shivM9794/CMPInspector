package com.cmpinspector.app.Retrofit;

import com.cmpinspector.app.Api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static String BASE_URL="https://apkconnectlab.com/cmpdtest/api/";
    private static RetrofitClient retrofitClient;
    private static Retrofit retrofit;


    OkHttpClient okHttpClient = UnsafeHttpClient.getUnsafeOkHttpClient();

    OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(80, TimeUnit.SECONDS)
            .readTimeout(80, TimeUnit.SECONDS)
            .writeTimeout(80, TimeUnit.SECONDS)
            .build();


    private RetrofitClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized RetrofitClient getInstance(){

        if (retrofitClient==null){
            retrofitClient = new RetrofitClient();
        }
        return retrofitClient;
    }


    public Api getApi(){
        return retrofit.create(Api.class);
    }
}
