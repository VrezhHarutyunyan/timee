package com.example.cybertech2.timee;

import android.widget.ImageView;

public class MovieNotifications {

    private String title;
    private String subTitle;
    private String date;
    //private int imageView;
    private boolean expanded;

    public MovieNotifications(String title, String subTitle, String date) {
        this.title = title;
        this.subTitle = subTitle;
        this.date = date;
       // this.imageView = imageView;
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }


    public String getDate() {
        return date;
    }

//    public int getImageView() {
//        return imageView;
//    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public boolean isExpanded() {
        return expanded;
    }
}
