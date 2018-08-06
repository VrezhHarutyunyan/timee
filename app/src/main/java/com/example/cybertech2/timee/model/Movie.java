package com.example.cybertech2.timee.model;

public class Movie {

    private String title;
    private String genre;

    // State of the item
    private boolean expanded;

    public Movie(String title, String genre) {
        this.title = title;
        this.genre = genre;

    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }



    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public boolean isExpanded() {
        return expanded;
    }
}
