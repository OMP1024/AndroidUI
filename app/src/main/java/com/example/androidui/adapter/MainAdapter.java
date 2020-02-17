package com.example.androidui.adapter;

import android.app.Activity;
import android.content.ClipData;
import android.util.Log;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidui.info.ItemInfo;
import com.example.androidui.viewholder.ViewHolder;

import java.util.LinkedList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter {

    private List<ItemInfo> dataList = new LinkedList<>();
    // 建议持有Activity和LayoutManager
    private Activity mActivity;
    private RecyclerView.LayoutManager mLayoutManager;

    public MainAdapter(
            Activity activity,
            RecyclerView.LayoutManager layoutManager) {
        mActivity = activity;
        mLayoutManager = layoutManager;
    }

    public void setDataList(List<ItemInfo> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return ViewHolder.createViewHolder(mActivity, parent);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder) holder).bindData(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    // ViewHolder被回收，将要放到RecyclerViewPool前
    @Override
    public void onViewRecycled(@NonNull RecyclerView.ViewHolder holder) {
        Log.i("xxxx", "onViewRecycled: ");
    }

    // 移入屏幕时的回调
    @Override
    public void onViewAttachedToWindow(@NonNull RecyclerView.ViewHolder holder) {
        Log.i("xxxx", "onViewAttachedToWindow: ");
    }

    // 移除屏幕时的回调
    @Override
    public void onViewDetachedFromWindow(@NonNull RecyclerView.ViewHolder holder) {
        Log.i("xxxx", "onViewDetachedFromWindow: ");
    }

    // 当调用setAdapter是会触发
    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        Log.i("xxxx", "onAttachedToRecyclerView: ");
    }

    @Override
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        Log.i("xxxx", "onAttachedToRecyclerView: ");
    }

    class ViewType {
        public static final int VIEW_TYPE_BANNER = 1;
        public static final int VIEW_TYPE_MENU = 2;
        public static final int VIEW_TYPE_NORMAL = 3;
    }
}
