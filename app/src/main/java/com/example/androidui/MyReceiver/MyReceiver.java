package com.example.androidui.MyReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Set;

public class MyReceiver extends BroadcastReceiver {

    private final static String TAG = "MyReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        String value = intent.getStringExtra("extra_key");
        Log.i(TAG, "onReceive: " + value);
    }
}
