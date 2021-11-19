package com.example.expandablelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;

import com.example.expandablelistview.adapter.ChapterAdapter;
import com.example.expandablelistview.bean.Chapter;
import com.example.expandablelistview.bean.ChapterLab;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView mExpandableListView;
    private BaseExpandableListAdapter mAdapter;
    private List<Chapter> mDatas = new ArrayList<>();
    private static final String TAG = "imooc-ex";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvents();
    }

    private void initEvents() {
        mExpandableListView.setOnChildClickListener(
                new ExpandableListView.OnChildClickListener() {
                    @Override
                    public boolean onChildClick(ExpandableListView expandableListView,
                                                View view,
                                                int i,
                                                int i1,
                                                long l) {
                        Log.d(TAG,"onChildClick" + i);
                        return false;
                    }
                }
        );

        mExpandableListView.setOnGroupClickListener(
                new ExpandableListView.OnGroupClickListener() {
                    @Override
                    public boolean onGroupClick(ExpandableListView expandableListView,
                                                View view,
                                                int i,
                                                long l) {
                        return false;
                    }
                }
        );

        mExpandableListView.setOnGroupExpandListener(
                new ExpandableListView.OnGroupExpandListener() {
                    @Override
                    public void onGroupExpand(int i) {

                    }
                }
        );

        mExpandableListView.setOnGroupCollapseListener(
                new ExpandableListView.OnGroupCollapseListener() {
                    @Override
                    public void onGroupCollapse(int i) {

                    }
                }
        );
    }

    private void initView() {
        mExpandableListView = findViewById(R.id.id_expandableListView);
        mDatas.clear();
        mDatas.addAll(ChapterLab.generateMockDatas());

        mAdapter = new ChapterAdapter(this, mDatas);
        mExpandableListView.setAdapter(mAdapter);

//        mExpandableListView.setAdapter(new BaseExpandableListAdapter() {
//            @Override
//            public int getGroupCount() {
//                return 0;
//            }
//
//            @Override
//            public int getChildrenCount(int i) {
//                return 0;
//            }
//
//            @Override
//            public Object getGroup(int i) {
//                return null;
//            }
//
//            @Override
//            public Object getChild(int i, int i1) {
//                return null;
//            }
//
//            @Override
//            public long getGroupId(int i) {
//                return 0;
//            }
//
//            @Override
//            public long getChildId(int i, int i1) {
//                return 0;
//            }
//
//            @Override
//            public boolean hasStableIds() {
//                return false;
//            }
//
//            @Override
//            public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
//                return null;
//            }
//
//            @Override
//            public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
//                return null;
//            }
//
//            @Override
//            public boolean isChildSelectable(int i, int i1) {
//                return false;
//            }
//        });
    }
}