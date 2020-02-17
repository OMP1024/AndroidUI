package com.example.androidui.activity;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.example.androidui.R;
import com.example.androidui.activity.BaseActivity;

public class ProgressBarActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("我是标题");
        progressDialog.setMessage("正在加载...");
        progressDialog.setCancelable(true);
        progressDialog.show();

        progressDialog.dismiss();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_progress_bar;
    }
}
