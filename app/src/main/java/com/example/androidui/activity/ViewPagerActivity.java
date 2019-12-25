package com.example.androidui.activity;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.androidui.R;
import com.example.androidui.fragment.TestFragment;

import butterknife.BindView;

public class ViewPagerActivity extends BaseActivity {
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    private static final String TAG = "ViewPagerActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewPager.setAdapter(mFragmentStatePagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.i(TAG, "onPageScrolled: " + "positionOffset = " + positionOffset + "positionOffsetPixels = " + positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                Log.i(TAG, "onPageSelected: " + position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                switch (state) {
                    case ViewPager.SCROLL_STATE_IDLE:
                        Log.i(TAG, "onPageScrollStateChanged: 停止滚动");
                        break;
                    case ViewPager.SCROLL_STATE_SETTLING:
                        Log.i(TAG, "onPageScrollStateChanged: 快要停止了");
                        break;
                    case ViewPager.SCROLL_STATE_DRAGGING:
                        Log.i(TAG, "onPageScrollStateChanged: 停止了");
                        break;
                }
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_view_pager;
    }

    private FragmentPagerAdapter mFragmentPagerAdapter = new FragmentPagerAdapter(
            getSupportFragmentManager(),
            FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return TestFragment.newInstance("位置 = " + position);
        }

        @Override
        public int getCount() {
            return 5;
        }
    };

    private FragmentStatePagerAdapter mFragmentStatePagerAdapter = new FragmentStatePagerAdapter(
            getSupportFragmentManager(),
            FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
        @NonNull
        @Override
        public Fragment getItem(int position) {
            return TestFragment.newInstance("位置 = " + position);
        }

        @Override
        public int getCount() {
            return 10;
        }
    };
}
