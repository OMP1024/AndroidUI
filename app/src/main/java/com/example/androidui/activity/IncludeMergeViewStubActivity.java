package com.example.androidui.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.androidui.R;

import butterknife.BindView;
import butterknife.OnClick;

public class IncludeMergeViewStubActivity extends BaseActivity {


    @BindView(R.id.back_btn)
    Button backBtn;
    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.detail_btn)
    Button detailBtn;
    @BindView(R.id.navigation_header_container)
    ViewGroup mViewGroup;
//    @BindView(R.id.navigation_header_container)
//    ConstraintLayout navigationHeaderContainer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewGroup.setBackgroundResource(R.color.colorAccent);

//        LayoutInflater.from(this).inflate()
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_include_merge_view_stub;
    }

    @OnClick({R.id.back_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_btn:
                finish();
                break;
        }
    }
}
