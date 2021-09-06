package com.cmpinspector.app.Utility;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.HashMap;

public class PreferenceUtils {

    public static final String FCMTOKEN = "Cash_My_Prop_FCM_TOKEN";
    public static final String UserToken = "Cash_My_Prop_User_Token";
    public static final String UserName = "Cash_My_Prop_User_Name";
    public static final String UserEmail = "Cash_My_Prop_User_Email";
    public static final String UserMobile = "Cash_My_Prop_User_Mobile";
    public static final String UserType = "Cash_My_Prop_User_Type";
    public static final String PropertyID= "Cash_My_Prop_Property_ID";

    public static final String inspector_id = "inspector_id";
    public static final String isLogin = "isLogin";
    public static final String inspector_name = "inspector_name";
    public static final String inspector_mobile = "inspector_mobile";
    public static final String inspector_email = "inspector_email";
    public static final String property_id = "property_id";
    public static final String ReraId="Cash_My_Prop_rera_id";


    public static boolean getBoolValue(Context context, String key) {
        int mode = Activity.MODE_PRIVATE;
        SharedPreferences sp = context.getSharedPreferences(key, mode);
        return sp.getBoolean(key, false);
    }

    public static void setBoolValue( Context context, String key, Boolean ip) {
        int mode = Activity.MODE_PRIVATE;
        SharedPreferences sp = context.getSharedPreferences(key, mode);
        SharedPreferences.Editor e = sp.edit();
        e.putBoolean(key, ip);
        e.apply();
    }

    public static String getStringValue(Context context, String key) {
        int mode = Activity.MODE_PRIVATE;
        SharedPreferences sp = context.getSharedPreferences(key, mode);
        return sp.getString(key, "0");
    }

    public static void setStringValue(Context context, String key, String ip) {
        int mode = Activity.MODE_PRIVATE;
        SharedPreferences sp = context.getSharedPreferences(key, mode);
        SharedPreferences.Editor e = sp.edit();
        e.putString(key, ip);
        e.apply();
    }

    public static HashMap<String, String> getHeaderMap(Context context) {
        HashMap<String, String> header = new HashMap<>();
        header.put("Apikey", "27e062300cf47085bdb0eae8c4fce567");
        header.put("Apidate", "2021-06-22");
        header.put("Apilanguage", "en");
        header.put("Apitimezone", "Asia/Dubai");
        header.put("Apidevicetype", "Android");
        header.put("Apidevicelat", "");
        header.put("Apidevicelong", "");
        header.put("Apideviceid", getStringValue(context, FCMTOKEN));
        header.put("Apicurrdate", KeyGenerationClass.getDate());
        header.put("Apicurrtime", "1602745108");
        header.put("Apicurrency", "AED");
        header.put("Apicurrencyvalue", "1.0000");

        Log.e("Apikey", KeyGenerationClass.getEncryptedKey());
        Log.e("Apidate", KeyGenerationClass.getDate());
        Log.e("Apilanguage", "en");
        Log.e("Apitimezone", "Asia/Dubai");
        Log.e("Apidevicetype", "Android");
        Log.e("Apidevicelat", "");
        Log.e("Apidevicelong", "");
        Log.e("Apideviceid", getStringValue(context, FCMTOKEN));
        Log.e("Apicurrdate", KeyGenerationClass.getDate());
        Log.e("Apicurrtime", "1602745108");
        Log.e("Apicurrency" ,"AED");
        Log.e("Apicurrencyvalue" ,"1.0000");

        return header;
    }

}
