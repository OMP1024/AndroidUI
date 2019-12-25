package com.example.androidui.view;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;

import com.example.androidui.R;

import butterknife.ButterKnife;

public class CustomDialog extends Dialog {

    public static CustomDialog newInstance(Context context) {
        return new CustomDialog(context);
    }

    private CustomDialog(@NonNull Context context) {
        super(context);
        // 去掉title
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        // 设置宽度和边距,没道理经验
        Window window = getWindow();
        if (window != null) {
            window.getDecorView().setPadding(
                    window.getDecorView().getPaddingLeft(),
                    window.getDecorView().getPaddingTop(),
                    window.getDecorView().getPaddingRight(),
                    window.getDecorView().getPaddingBottom());
            WindowManager.LayoutParams layoutParams = window.getAttributes();
            layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
            window.setAttributes(layoutParams);
        }

        View view = LayoutInflater.from(context).inflate(R.layout.dialog_custom, null);
        ButterKnife.bind(this, view);
        // 设置内容
        setContentView(view);
    }

}
