package com.saber;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;


/**
 * Created by lct on 2017/10/27.
 */

public class BackManager extends ReactContextBaseJavaModule {
    public BackManager(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "BackManager";
    }

    @ReactMethod
    public void popLastViewController() {
        Log.d("saber", "called back");
        ((AppCompatActivity)getCurrentActivity()).finish();
    }
}
