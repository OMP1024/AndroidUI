package com.example.androidui.activity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;

@SuppressLint("Registered")
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initWindow();
    }

    private void initWindow() {
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
// Translucent status bar
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
// 解决 4.4-5.0 版本之间，页面包含 EditText 无法适配的问题
//    {
// create our manager instance after the content view is set
//        mTintManager = new SystemBarTintManager(this); // enable status bar tint mTintManager.setStatusBarTintEnabled(true);
// enable navigation bar tint mTintManager.setNavigationBarTintEnabled(true);
// 自定义状态栏的颜色
//        mTintManager.setStatusBarTintColor(getResources().getColor(R.color.colorPrimary));
//    }
// 解决[5.0-5.1.1]版本状态栏没有全透明的系统适配问题
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//// 解决部分 5.x 系统使用状态栏透明属性后状态栏变黑色，不使用这句代码，在 6.0 设备上又出现半 透明状态栏
//// 需要特殊处理 window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            window.setStatusBarColor(Color.TRANSPARENT);
//        }
// 把状态栏标记为浅色，然后状态栏的字体颜色自动转换为深色。
// if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
// getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
// }
    }


    protected abstract int getLayoutId();

}
