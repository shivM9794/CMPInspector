package com.cmpinspector.app.Utility;

import android.util.Log;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class KeyGenerationClass {

    public static String getEncryptedKey() {

        return getMd5Hash("CMPInspectorApp".concat(getDate()));
    }

    public static String getTime()
    {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
        String currentTime = sdf.format(c.getTime());
        Log.e("MD5-Time",""+ currentTime);
        return currentTime;
    }
    public static String getDate()
    {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = simpleDateFormat.format(date);
        Log.e("MD5-Date", strDate);
        return strDate;
    }

    public static String getMd5Hash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String md5 = number.toString(16);

            while (md5.length() < 32)
                md5 = "0" + md5;
            Log.e("MD5", md5);
            return md5;
        } catch (NoSuchAlgorithmException e) {
            Log.e("MD5", e.getLocalizedMessage());
            return null;
        }
    }
}
