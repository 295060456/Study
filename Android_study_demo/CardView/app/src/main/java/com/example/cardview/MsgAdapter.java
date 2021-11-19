package com.example.cardview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MsgAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflater;
    private List<Msg> mDatas;

    public MsgAdapter(Context mContext, List<Msg> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
        mInflater = LayoutInflater.from(mContext);

    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Msg getItem(int i) {
        return mDatas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder = null;

//        mContext.getSystemService

        if (view == null){
            view = mInflater.inflate(R.layout.item_msg,viewGroup,false);
            viewHolder = new ViewHolder();
            viewHolder.mIvImg = view.findViewById(R.id.id_iv_img);
            viewHolder.mTvTitle = view.findViewById(R.id.id_tv_title);
            viewHolder.mTvContent = view.findViewById(R.id.id_tv_content);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)view.getTag();
        }

        Msg msg = mDatas.get(i);
        viewHolder.mIvImg.setImageResource(msg.getImgResId());
        viewHolder.mTvTitle.setText(msg.getContent());

        return view;
    }


    public static class ViewHolder{
        ImageView mIvImg;
        TextView mTvTitle;
        TextView mTvContent;
    }
}
