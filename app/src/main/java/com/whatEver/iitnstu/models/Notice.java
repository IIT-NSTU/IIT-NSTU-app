package com.whatEver.iitnstu.models;

public class Notice {
    private String date;
    private String about;
    private String description;
    private String pdf;

    public Notice(String date, String about, String description, String pdf) {
        this.date = date;
        this.about = about;
        this.description = description;
        this.pdf=pdf;
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

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "date='" + date + '\'' +
                ", about='" + about + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
