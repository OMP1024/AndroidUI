package com.example.androidui.util;

import android.app.Activity;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

public class ViewUtil {
    public static boolean checkActivityIsValid(Activity activity) {
        if (activity == null) return false;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            return !(activity.isFinishing() || activity.isDestroyed());
        } else {
            return !activity.isFinishing();
        }
    }

    public static boolean checkFragmentIsValid(Fragment fragment) {
        if (fragment.getActivity() == null) return false;
        return checkActivityIsValid(fragment.getActivity());
    }
}
