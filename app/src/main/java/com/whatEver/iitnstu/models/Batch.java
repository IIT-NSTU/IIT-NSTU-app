package com.whatEver.iitnstu.models;

public class Batch {
    private String name;
    private String description;
    private String session;
    private String icon;

    public Batch(String name, String description, String session, String icon) {
        this.name = name;
        this.description = description;
        this.session = session;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
