package com.example.androidui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.androidui.adapter.MainAdapter;
import com.example.androidui.info.ItemInfo;

import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    private MainAdapter mAdapter;
    private LinearLayoutManager mLinearLayoutManager;
    private List<ItemInfo> dataList = new LinkedList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initUI();
        getData();

//        Handler handler;
//        Looper looper;
//        MessageQueue messageQueue;
//        Thread thread;
//        ThreadLocal threadLocal;
//        Message message;

        mAdapter.setDataList(dataList);
        mAdapter.notifyDataSetChanged();
    }

    private void initUI() {
        // 1.创建LayoutManager
        mLinearLayoutManager = new LinearLayoutManager(this);

        // 2. 创建Adapter
        mAdapter = new MainAdapter(this, mLinearLayoutManager);

        // 3. 注入LayoutManager
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        // 4. 注入Adapter
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, RecyclerView.VERTICAL));
        mRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                return false;
            }

            @Override
            public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });
//        // 5. 当itemView是固定高度时，可以设置这个属性，notifyItemxx刷新界面时，RecyclerView的onMeasure(),onLayout()就不会调用了，而是直接调用LayoutManager的onMeasure()，能提高一点性能
//        mRecyclerView.setHasFixedSize(true);
//        // 6.添加滚动监听
//        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            // 滑动状态变化的监听
//            @Override
//            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
//                super.onScrollStateChanged(recyclerView, newState);
//                switch (newState) {
//                    // 停止滑动时的状态
//                    case RecyclerView.SCROLL_STATE_IDLE:
//                        break;
//                    // 手指拖动时的状态
//                    case RecyclerView.SCROLL_STATE_DRAGGING:
//                        break;
//                    // 惯性滑动时候状态
//                    case RecyclerView.SCROLL_STATE_SETTLING:
//                        break;
//                }
//            }
//
//            // 滑动时每一帧的回调
//            @Override
//            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
//            }
//        });
//
//        // 7. 根据情况决定拦截触摸事件的分发
//        mRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
//            @Override
//            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
//                return false;
//            }
//
//            @Override
//            public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
//                // 查找触摸位置所在的View
//                View view = mRecyclerView.findChildViewUnder(e.getX(), e.getY());
//                if (view != null) {
//
//                    // 根据View查找ViewHolder
//                    RecyclerView.ViewHolder viewHolder = mRecyclerView.findContainingViewHolder(view);
//                    if (viewHolder != null) {
//
//                        // 根据ViewHolder查找 position
//                        Log.i("xxxxxx", "onTouchEvent - position =" + viewHolder.getAdapterPosition());
//                    }
//                }
//            }
//
//            @Override
//            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
//
//            }
//        });
//
//        // 8. 禁止滚动，禁止更新
//        mRecyclerView.suppressLayout(true);
//
//        // 9. 查找在LayoutManager布局第0个位置的ViewHolder
//        mRecyclerView.findViewHolderForLayoutPosition(0);
//
//        // 10. 查找在数据源第0个位置的ViewHolder
//        mRecyclerView.findViewHolderForAdapterPosition(0);
//
//        // 11. 具体itemID的viewholder
//        mRecyclerView.findViewHolderForItemId(0);
//
//        // 12. 滚动到指定的位置
//        mRecyclerView.scrollToPosition(0);

    }

    private void getData() {
        for (ItemInfo.Type type: ItemInfo.Type.values()){
            dataList.add(new ItemInfo(type.name(),type));
        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i("xxx", "onActivityResult: resultCode = "+resultCode);
        if (data != null){
            Log.i("xxx", "onActivityResult: "+data.getStringExtra("key"));
        }
    }
}
