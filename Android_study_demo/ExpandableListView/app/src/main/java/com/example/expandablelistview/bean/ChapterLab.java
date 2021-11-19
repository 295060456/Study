package com.example.expandablelistview.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Jobs Who was an iOS Developor
 */
public class ChapterLab {

    public static List<Chapter> generateMockDatas() {
        List<Chapter> datas = new ArrayList<>();

        Chapter root1 = new Chapter(1, "Android");
        Chapter root2 = new Chapter(2, "iOS");
        Chapter root3 = new Chapter(3, "unity 3D");
        Chapter root4 = new Chapter(4, "Coco2d-x");

        root1.addChild(1, "PullToRefresh");
        root1.addChild(2, "Android 8.0 通知栏解决方案");
        root1.addChild(4, "Android 与 webView的js 交互");
        root1.addChild(8, "Android Ui Auto 2.0入门实践");
        root1.addChild(10, "移动端音频视频入门");

        root2.addChild(11, "PullToRefresh");
        root2.addChild(12, "Android 8.0 通知栏解决方案");
        root2.addChild(13, "Android 与 webView的js 交互");
        root2.addChild(14, "Android Ui Auto 2.0入门实践");
        root2.addChild(15, "移动端音频视频入门");

        root3.addChild(16, "PullToRefresh");
        root3.addChild(17, "Android 8.0 通知栏解决方案");
        root3.addChild(18, "Android 与 webView的js 交互");
        root3.addChild(19, "Android Ui Auto 2.0入门实践");
        root3.addChild(20, "移动端音频视频入门");

        root4.addChild(21, "PullToRefresh");
        root4.addChild(22, "Android 8.0 通知栏解决方案");
        root4.addChild(23, "Android 与 webView的js 交互");
        root4.addChild(24, "Android Ui Auto 2.0入门实践");
        root4.addChild(25, "移动端音频视频入门");

        datas.add(root1);
        datas.add(root2);
        datas.add(root3);
        datas.add(root4);

        return datas;
    }
}
