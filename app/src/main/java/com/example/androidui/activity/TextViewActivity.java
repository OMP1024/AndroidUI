package com.example.androidui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.androidui.R;

public class TextViewActivity extends BaseActivity {

    public static void launchActivity(Context context ) {
        Intent intent = new Intent(context, TextViewActivity.class);
        if (!(context instanceof Activity)){
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_text_view;
    }
}
