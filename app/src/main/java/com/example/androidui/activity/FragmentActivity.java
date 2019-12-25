package com.example.androidui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.FragmentTransaction;

import com.example.androidui.R;
import com.example.androidui.fragment.CustomDialogFragment;
import com.example.androidui.fragment.DialogInFragment;
import com.example.androidui.view.CustomDialog;

import butterknife.OnClick;

public class FragmentActivity extends BaseActivity {

    public static void launchFragmentActivity(Activity activity) {
        Intent intent = new Intent(activity, FragmentActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_fragment;
    }

    @OnClick({R.id.onCraeateView, R.id.onCreateDialog, R.id.bottomSheetDialog, R.id.bottomSheetDialogFragment, R.id.dialog, R.id.activity})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.onCraeateView:
                CustomDialogFragment dialogFragment = new CustomDialogFragment();
                dialogFragment.show(getSupportFragmentManager(), "xxxxx");
                break;
            case R.id.onCreateDialog:
                DialogInFragment dialogInFragment = new DialogInFragment();
                dialogInFragment.show(getSupportFragmentManager(), "xxx");
                break;
            case R.id.bottomSheetDialog:
                CustomDialogFragment dialogFragment1 = new CustomDialogFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                transaction.add(android.R.id.content, dialogFragment1).addToBackStack(null).commit();
                break;
            case R.id.bottomSheetDialogFragment:
                break;
            case R.id.dialog:
                CustomDialog.newInstance(this).show();
                break;
            case R.id.activity:
                Intent intent = new Intent(this, DialogActivity.class);
                startActivity(intent);
        }
    }
}
