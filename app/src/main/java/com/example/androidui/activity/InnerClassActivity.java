package com.example.androidui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.androidui.MainActivity;
import com.example.androidui.R;
import com.example.androidui.info.ItemInfo;

public class InnerClassActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inner_class);

        String test = new String("测试");
        Log.i("测试", "onCreate: " + test.hashCode());

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("测试", "修改: " + test.hashCode());
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(InnerClassActivity.this, MainActivity.class));
            }
        });

        // 地址是相同的，看来不是复制
    }
}
