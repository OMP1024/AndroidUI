package com.example.androidui.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.example.androidui.MainApplication;

public final class SharePreUtil {

    public enum BooleanKeyValue{
        UGCProtocolIsAgree(Table.Global, "UGCProtocolIsAgree", false);

        private final Table mTable;
        private final String mKey;
        private final boolean mDefaultValue;

        BooleanKeyValue(Table table, String key, boolean defaultValue) {
            if (table == null){
                throw new IllegalArgumentException("table is null");
            }
            mTable = table;

            if (key != null){
                key = key.trim();
            }
            if (TextUtils.isEmpty(key)){
                throw new IllegalArgumentException("key is empty");
            }
            mKey = key;

            mDefaultValue = defaultValue;
        }

        public boolean get(){
            boolean value = mDefaultValue;
            synchronized (mTable){
                try {
                    value = mTable.mSharedPreferences.getBoolean(mKey,mDefaultValue);
                }catch (Exception ignore) {
                }
            }
            return value;
        }

        public void set(boolean value){
            synchronized (mTable){
                try {
                    mTable.mEditor.putBoolean(mKey,value);
                    mTable.mEditor.apply();
                }catch (Exception ignore){

                }
            }
        }
    }

    public enum LongKeyValu{
        UserSelectGenderId(Table.Global, "UserSelectGenderId", 1)
        ;
        private final Table mTable;
        private final String mKey;
        private final long mDefaultValue;

        LongKeyValu(Table table, String key, long defaultValue) {
            if (table == null){
                throw new IllegalArgumentException("table is null");
            }
            mTable = table;

            if (key != null){
                key = key.trim();
            }
            if (TextUtils.isEmpty(key)){
                throw new IllegalArgumentException("key is empty");
            }
            mKey = key;

            mDefaultValue = defaultValue;
        }

        public long get(){
            long value = mDefaultValue;
            synchronized (mTable){
                try {
                    value = mTable.mSharedPreferences.getLong(mKey, mDefaultValue);
                }catch (Exception ignore){
                }
            }
            return value;
        }

        public void set(long value){
            synchronized (mTable){
                try {
                    mTable.mEditor.putLong(mKey,value);
                }catch (Exception ignore){

                }
            }
        }
    }

    public enum StringKeyValue {
        ;

        private final Table mTable;
        private final String mKey;
        private final String mDefaultValue;

        StringKeyValue(Table table, String key, String defaultValue) {
            if (table == null){
                throw new IllegalArgumentException("table is null");
            }
            mTable = table;

            if (key != null){
                key = key.trim();
            }
            if (TextUtils.isEmpty(key)){
                throw new IllegalArgumentException("key is empty");
            }
            mKey = key;

            mDefaultValue = defaultValue;
        }

        public String get(){
            String value = mDefaultValue;
            synchronized (mTable){
                try {
                    value = mTable.mSharedPreferences.getString(mKey,mDefaultValue);
                }catch (Exception ignore){

                }
            }
            return value;
        }

        public void set(String value){
            synchronized (mTable){
                try {
                    mTable.mEditor.putString(mKey,value);
                }catch (Exception ignore){
                }
            }
        }
    }

    private enum Table {
        Global("nipfg_global"),
        AccountState("nipfg_account_state");

        private SharedPreferences mSharedPreferences;
        private SharedPreferences.Editor mEditor;

        Table(String fileName) {
            if (fileName != null){
                fileName = fileName.trim();
            }

            if (TextUtils.isEmpty(fileName)) {
                throw new IllegalArgumentException("fileName is null");
            }

            mSharedPreferences = MainApplication.getInstance().getSharedPreferences(fileName, Context.MODE_PRIVATE);
            mEditor = mSharedPreferences.edit();
        }
    }
}
