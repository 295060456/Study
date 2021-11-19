package com.example.expandablelistview.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Jobs Who was an iOS Developor
 */
public class Chapter {

    private int id;
    private String name;
    private List<ChapterItem> children = new ArrayList<>();

    public Chapter() {

    }

    public Chapter(int id, String name) {
        this.id = id;
        this.name = name;
    }

    void addChild(ChapterItem chapterItem) {
        chapterItem.setPid(getId());
        chapterItem.JobsTest = "sd";
        children.add(chapterItem);
    }

    void addChild(int cid, String cname) {
        ChapterItem chapterItem = new ChapterItem(cid, cname);
        chapterItem.JobsTest = "sd";
        chapterItem.setPid(getId());
        children.add(chapterItem);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ChapterItem> getChildren() {
        return children;
    }

    public void setChildren(List<ChapterItem> children) {
        this.children = children;
    }
}
