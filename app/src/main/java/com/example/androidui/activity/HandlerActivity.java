package com.example.androidui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidui.R;

import java.lang.ref.WeakReference;

public class HandlerActivity extends AppCompatActivity {
    private TextView mTextView;

    private static final int UI_MESSAGE_WHAT = 100;
    // 2.实例化当前主线程的静态内部类
    private Handler mHandler = new MyHandler(this);

    // 1. 创建静态内部类
    static class MyHandler extends Handler {
        private WeakReference<HandlerActivity> mWeakReference;

        public MyHandler(HandlerActivity appCompatActivity) {
            super();
            mWeakReference = new WeakReference<HandlerActivity>(appCompatActivity);
        }

        // 3. 处理消息
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            HandlerActivity appCompatActivity = mWeakReference.get();
            if (appCompatActivity != null){
                appCompatActivity.update((String) msg.obj);
            }
        }
    }

    public void update(String text){
        // 更新UI
        mTextView.setText(text);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        mTextView = findViewById(R.id.textView);

        //  4. 在子线程中创建消息，并发送消息
        new Thread(() -> {
            Message message = Message.obtain();
            message.what = UI_MESSAGE_WHAT;
            message.obj = 10;
            mHandler.sendMessage(message);
        }).start();

        Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                handler.post(() -> {
                    // 指定操作UI内容
                    mTextView.setText("执行线程中的UI操作");
                });
            }
        }).start();
    }
}
