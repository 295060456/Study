package com.example.expandablelistview.bean;

/**
 * Created By Jobs Who was an iOS Developor
 */
public class ChapterItem {

    private int id;
    private String name;
    private int pid;

    public String JobsTest;

    public ChapterItem(int id,
                       String name,
                       int pid) {
        this.id = id;
        this.name = name;
        this.pid = pid;
    }

    public ChapterItem(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }
}
