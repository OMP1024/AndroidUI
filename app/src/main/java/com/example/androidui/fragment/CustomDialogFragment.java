package com.example.androidui.fragment;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.androidui.R;

import butterknife.ButterKnife;

public class CustomDialogFragment extends DialogFragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_FRAME, R.style.comment_dialog_style);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getDialog() != null) {
            Window window = getDialog().getWindow();
            if (window != null) {
                window.getDecorView().setPadding(0, 0, 0, 0);
                WindowManager.LayoutParams layoutParams = window.getAttributes();
                layoutParams.gravity = Gravity.BOTTOM;
                layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
                window.setAttributes(layoutParams);
            }
        }

        View view = inflater.inflate(R.layout.dialog_fragment_custom, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
}
