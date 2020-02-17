package com.example.androidui;

import android.app.Application;

public class MainApplication extends Application {
    private static volatile MainApplication sInstance = null;

    public MainApplication() {
        sInstance = this;
    }

    public static MainApplication getInstance(){
        return sInstance;
    }
}
