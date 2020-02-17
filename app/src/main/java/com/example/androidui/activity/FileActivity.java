package com.example.androidui.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.androidui.R;
import com.example.androidui.info.ItemInfo;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import butterknife.BindView;
import butterknife.OnClick;

public class FileActivity extends BaseActivity {

    private String TAG = "FileActivity";
    @BindView(R.id.editText)
    EditText mEditText;
    @BindView(R.id.textView5)
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_file;
    }

    @OnClick({R.id.File, R.id.SharePr, R.id.SQ, R.id.readbtn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.File: {
//                FileOutputStream outputStream = null;
//                BufferedWriter writer = null;
//                try {
//                    Gson gson = new Gson();
//                    ItemInfo itemInfo = new ItemInfo("文件存储", ItemInfo.Type.ACTIVITY);
//
//                    outputStream = openFileOutput("data", Context.MODE_PRIVATE);
//                    writer = new BufferedWriter(new OutputStreamWriter(outputStream));
//                    writer.write(gson.toJson(itemInfo));
//                } catch (IOException e) {
//                    e.printStackTrace();
//                } finally {
//                    try {
//                        if (writer != null) {
//                            writer.close();
//                        }
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }

                File file1 = Environment.getDataDirectory();
                File file2 = Environment.getRootDirectory();
                File file3 = Environment.getDownloadCacheDirectory();
                Log.i(TAG, "onViewClicked: file1 "+file1.getPath()+"file2 = "+file2.getPath()+"file3 = "+file3.getPath());
            }
            break;
            case R.id.SharePr:
            {

                SharedPreferences sharedPreferences = this.getSharedPreferences("data",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("key","value");
                editor.apply();


                sharedPreferences.getString("key","default_value");

//                SharedPreferences sharedPreferences = this.getPreferences(MODE_PRIVATE);
//                SharedPreferences.Editor editor = sharedPreferences.edit();
//                editor.putString("key","value");
//                editor.apply();
            }
                break;
            case R.id.SQ:
                break;
            case R.id.readbtn: {
                FileInputStream inputStream = null;
                BufferedReader reader = null;
                StringBuilder content = new StringBuilder();
                try {
                    inputStream = openFileInput("data");
                    reader = new BufferedReader(new InputStreamReader(inputStream));
                    String line = "";
                    while ((line = reader.readLine()) != null) {
                        content.append(line);
                    }
                    Log.i(TAG, "onViewClicked: " + content);
                    ItemInfo itemInfo = new Gson().fromJson(content.toString(), ItemInfo.class);
                    Log.i(TAG, "onViewClicked: "+itemInfo.toString());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
            break;
        }
    }
}
