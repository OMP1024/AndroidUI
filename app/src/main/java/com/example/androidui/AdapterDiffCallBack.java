package com.example.androidui;

import androidx.recyclerview.widget.DiffUtil;

import java.util.List;

public class AdapterDiffCallBack extends DiffUtil.Callback {
    private List<String> mOldList;
    private List<String> mNewList;

    public AdapterDiffCallBack(List<String> oldList, List<String> newList) {
        mOldList = oldList;
        mNewList = newList;
    }

    @Override
    public int getOldListSize() {
        return mOldList.size();
    }

    @Override
    public int getNewListSize() {
        return mNewList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return mOldList.get(oldItemPosition).equals(mNewList.get(newItemPosition));
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return mOldList.get(oldItemPosition).equals(mNewList.get(newItemPosition));
    }
}
