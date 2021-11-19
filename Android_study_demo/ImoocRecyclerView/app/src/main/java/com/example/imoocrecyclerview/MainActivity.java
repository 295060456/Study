package com.example.imoocrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private MyRecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recycler_view);
        // 线性布局
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);//决定横着滚、还是竖着滚
        linearLayoutManager.setReverseLayout(true);//数据反向展示

        mRecyclerView.setLayoutManager(linearLayoutManager);

        mAdapter = new MyRecyclerViewAdapter(this,mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);
    }

    // 添加数据
    public void onAddDataClick(View v) {
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            String s = "第" + i + "条数据";
            data.add(s);
        }
        mAdapter.setDataSource(data);
    }

    // 切换布局
    public void onChangeLayoutClick(View view) {
        // 从线性布局 切换为 网格布局
        if (mRecyclerView.getLayoutManager().getClass() == LinearLayoutManager.class) {
            // 网格布局
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
            mRecyclerView.setLayoutManager(gridLayoutManager);
        } else if (mRecyclerView.getLayoutManager().getClass() == GridLayoutManager.class){
            // 瀑布流布局
            StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
            mRecyclerView.setLayoutManager(staggeredGridLayoutManager);
        } else {
            // 线性布局
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            mRecyclerView.setLayoutManager(linearLayoutManager);
        }
    }
}