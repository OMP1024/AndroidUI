package com.example.androidui.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.example.androidui.BuildConfig;
import com.example.androidui.MyReceiver.MyReceiver;
import com.example.androidui.R;
import com.google.android.material.chip.ChipGroup;

import butterknife.OnClick;

public class BroadcastActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        registerReceiver();
        regiterLocalBroad();

    }

    private void regiterLocalBroad() {
        // 本地广播注册
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("localbroadcat_action");
        localBroadcastManager.registerReceiver(mMyReceiver, intentFilter);
    }

    private void registerReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("dynamic_register_broadcast");
        registerReceiver(mMyReceiver, intentFilter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_broadcast;
    }

    @OnClick({R.id.button8, R.id.button9, R.id.button10})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button8: {
                Intent intent = new Intent();
                intent.setAction("my_broadcast");
                intent.setComponent(new ComponentName(BuildConfig.APPLICATION_ID, BuildConfig.APPLICATION_ID + ".MyReceiver.MyReceiver"));
                intent.putExtra("extra_key", "extra_value");
                sendBroadcast(intent);
            }
            break;

            case R.id.button9: {
                Intent intent1 = new Intent();
                intent1.setAction("dynamic_register_broadcast");
                intent1.putExtra("extra_key", "extra_value");
                sendBroadcast(intent1);
            }
            break;
            case R.id.button10: {
                LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);
                Intent intent = new Intent();
                intent.setAction("localbroadcat_action");
                intent.putExtra("extra_key", "extra_value");
                localBroadcastManager.sendBroadcast(intent);
            }

        }
    }


    private MyReceiver mMyReceiver = new MyReceiver();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mMyReceiver);
    }
}
