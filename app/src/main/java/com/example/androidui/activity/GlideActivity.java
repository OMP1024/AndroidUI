package com.example.androidui.activity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.androidui.R;

import butterknife.BindView;

public class GlideActivity extends BaseActivity {

    @BindView(R.id.content_iv)
    ImageView contentIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Glide.with(this).load("https://static.runoob.com/images/demo/demo2.jpg").into(contentIv);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_glide;
    }
}
