package com.example.imoocrecyclerview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Jobs Who was an iOS Developor
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {

    private RecyclerView mRV;
    private Context mContext;
    private List<String> dataSource;

    public MyRecyclerViewAdapter(Context context, RecyclerView recyclerView) {
        this.mContext = context;
        this.dataSource = new ArrayList<>();
        mRV = recyclerView;
    }

    public MyRecyclerViewAdapter(Context context) {
        this.mContext = context;
        this.dataSource = new ArrayList<>();
    }

    public void setDataSource(List<String> dataSource) {
        this.dataSource = dataSource;
        notifyDataSetChanged();// 通知刷新
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.item_layout, parent, false));
    }

    // 和泛型相关联
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mIV.setImageResource(getIcon(position));
        holder.mTV.setText(dataSource.get(position));
        /*只在瀑布流布局中使用随机高度*/
        if (mRV.getLayoutManager().getClass() == StaggeredGridLayoutManager.class){
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,getRandomHeight());
            holder.mTV.setLayoutParams(params);
        }else{
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
            holder.mTV.setLayoutParams(params);
        }
    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }

    private int getIcon(int position) {
        switch (position % 5) {
            case 0:
                return R.mipmap.a;
            case 1:
                return R.mipmap.b;
            case 2:
                return R.mipmap.c;
            case 3:
                return R.mipmap.d;
            case 4:
                return R.mipmap.e;
        }
        return 0;
    }

    private int getRandomHeight() {
        return (int) Math.random() * 1000;
    }

    // 类似于iOS TableViewCell
    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView mIV;
        TextView mTV;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            mIV = itemView.findViewById(R.id.iv);
            mTV = itemView.findViewById(R.id.tv);

            Log.d("12","12");
        }
    }
}
