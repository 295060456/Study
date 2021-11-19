package com.example.expandablelistview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.expandablelistview.R;
import com.example.expandablelistview.bean.Chapter;
import com.example.expandablelistview.bean.ChapterItem;

import java.util.List;

/**
 * Created By Jobs Who was an iOS Developor
 */
public class ChapterAdapter extends BaseExpandableListAdapter {

    private Context mContext;
    private List<Chapter> mDatas;
    private LayoutInflater mInflater;

    public ChapterAdapter(Context context, List<Chapter> data) {
        mContext = context;
        mDatas = data;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getGroupCount() {
        return mDatas.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return mDatas.get(i).getChildren().size();
    }

    @Override
    public Object getGroup(int i) {
        return mDatas.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return mDatas.get(i).getChildren().get(i);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i,
                             boolean b,
                             View view,
                             ViewGroup viewGroup) {

        ParentViewHolder parentViewHolder = null;

        if (view == null) {
            view = mInflater.inflate(R.layout.item_parent_chapter, viewGroup, false);
            parentViewHolder = new ParentViewHolder();
            parentViewHolder.mTvName = view.findViewById(R.id.id_tv_name);
            view.setTag(parentViewHolder);
        } else {
            parentViewHolder = (ParentViewHolder) view.getTag();
        }

        Chapter chapter = mDatas.get(i);
        parentViewHolder.mTvName.setText(chapter.getName());

        return view;
    }

    @Override
    public View getChildView(int i,
                             int i1,
                             boolean b,
                             View view,
                             ViewGroup viewGroup) {

        ChildViewHolder childViewHolder = null;

        if (view == null) {
            view = mInflater.inflate(R.layout.item_child_chapter, viewGroup, false);
            childViewHolder = new ChildViewHolder();
            childViewHolder.mTvName = view.findViewById(R.id.id_tv_name);
            view.setTag(childViewHolder);
        } else {
            childViewHolder = (ChildViewHolder) view.getTag();
        }

        ChapterItem chapterItem = mDatas.get(i).getChildren().get(i1);
        childViewHolder.mTvName.setText(chapterItem.getName());

        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }


    public static class ParentViewHolder {
        TextView mTvName;
    }

    public static class ChildViewHolder {
        TextView mTvName;
    }
}
