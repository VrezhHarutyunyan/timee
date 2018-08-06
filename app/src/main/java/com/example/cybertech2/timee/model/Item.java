package com.example.cybertech2.timee.model;

public class Item {

    private  String text,subText;
    private  boolean isExpandable;
    public int getSubText;

    public Item(String text, String subText, boolean isExpandable) {
        this.text = text;
        this.subText = subText;
        this.isExpandable = isExpandable;
    }
}
