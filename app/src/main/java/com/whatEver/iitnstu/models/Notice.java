package com.whatEver.iitnstu.models;

public class Notice {
    private String date;
    private String about;
    private String description;

    public Notice(String date, String about, String description) {
        this.date = date;
        this.about = about;
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
