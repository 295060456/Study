package com.example.expandablelistview.biz;

import android.content.Context;
import android.os.AsyncTask;

import com.example.expandablelistview.bean.Chapter;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.callback.Callback;

/**
 * Created By Jobs Who was an iOS Developor
 */
public class ChapterBiz {

    public void loadDatas(Context context,
                          Callback callBack,
                          boolean useCache) {

        AsyncTask<Boolean, Void, List<Chapter>> asyncTask = new AsyncTask<Boolean, Void, List<Chapter>>() {
            @Override
            protected List<Chapter> doInBackground(Boolean... booleans) {

                boolean isUseCache = booleans[0];
                List<Chapter> chapterList = new ArrayList<>();
                if (isUseCache) {
//                    chapterList.addAll()
                }
                if (chapterList.isEmpty()){
List<Chapter> chapterListFromNew
                }

                return chapterList;
            }
        };

        asyncTask.execute(useCache);

    }

    public static interface CallBack {
        void OnSuccess(List<Chapter> chapterList);

        void onFailed(Exception e)
    }

}
