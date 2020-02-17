package com.example.androidui.viewholder;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidui.R;
import com.example.androidui.activity.AnimationActivity;
import com.example.androidui.activity.BroadcastActivity;
import com.example.androidui.activity.DrawLayoutActivity;
import com.example.androidui.activity.FileActivity;
import com.example.androidui.activity.FragmentActivity;
import com.example.androidui.activity.IncludeMergeViewStubActivity;
import com.example.androidui.activity.KitkatActivity;
import com.example.androidui.activity.LifeCycleActivity;
import com.example.androidui.activity.TextViewActivity;
import com.example.androidui.activity.ViewPagerActivity;
import com.example.androidui.activity.WebViewActivity;
import com.example.androidui.info.ItemInfo;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ViewHolder extends RecyclerView.ViewHolder {
    private Activity mActivity;

    @BindView(R.id.title_tv)
    TextView titleTv;
    private ItemInfo mItemInfo;

    public static ViewHolder createViewHolder(Activity activity, ViewGroup parent) {
        return new ViewHolder(activity,
                LayoutInflater.from(activity).inflate(R.layout.item_view_holder, parent, false));
    }

    private ViewHolder(Activity activity, @NonNull View itemView) {
        super(itemView);
        mActivity = activity;
        ButterKnife.bind(this, itemView);
    }

    public void bindData(ItemInfo info) {
        mItemInfo = info;
        titleTv.setText(info.getTitle());
    }

    @OnClick(R.id.title_tv)
    public void onViewClicked() {
        switch (mItemInfo.getType()) {
            case VIEW:
                break;
            case WEBVIEW:
                break;
            case ACTIVITY:
                break;
            case FRAGMENT:
                FragmentActivity.launchFragmentActivity(mActivity);
                break;
            case VIEWPAGE:
                mActivity.startActivity(new Intent(mActivity, ViewPagerActivity.class));
                break;
            case TABLAYOUT:
                break;
            case TEXT_VIEW:
                TextViewActivity.launchActivity(mActivity);
                break;
            case VIDEOVIEW:
                break;
            case BOTTOMSHEET:
                break;
            case PROGRESS_BAR:
                break;
            case RECYCLERVIEW:
                break;
            case DIALOGFRAGMENT:
                break;
            case LifeCycle:
                LifeCycleActivity.launchLifeCycleActivity(mActivity);
                break;
            case ViewAnimation:
                mActivity.startActivity(new Intent(mActivity, AnimationActivity.class));
                break;
            case KitKat:
                mActivity.startActivity(new Intent(mActivity, KitkatActivity.class));
                break;
            case WebView:
                mActivity.startActivity(new Intent(mActivity, WebViewActivity.class));
                break;
            case Intent_FIlter:
                Intent intent = new Intent();
                intent.setAction("my_action");
                intent.addCategory("my_category");
                mActivity.startActivity(intent);
                break;
            case PackageName: {
                PackageManager packageManager = mActivity.getPackageManager();
                Intent intent1 = packageManager.getLaunchIntentForPackage("com.cari.promo.diskon");
                if (intent1 != null && packageManager.resolveActivity(intent1, PackageManager.MATCH_DEFAULT_ONLY) != null) {
                    try {
                        mActivity.startActivity(intent1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            break;
            case Broadcast: {
                mActivity.startActivity(new Intent(mActivity, BroadcastActivity.class));
            }
            break;
            case FILE:
                mActivity.startActivity(new Intent(mActivity, FileActivity.class));
                break;
            case DrawLayout:
                mActivity.startActivity(new Intent(mActivity, DrawLayoutActivity.class));
                break;
            case INCLUDEMERGEVIEWSTUB:
                mActivity.startActivity(new Intent(mActivity, IncludeMergeViewStubActivity.class));
                break;
        }

    }
}