package com.whatEver.iitnstu.models;

public class Teacher {
    private String name;
    private String designation;
    private String phnNo;
    private String email;
    private String imageLink;

    public Teacher(String name, String designation, String phnNo, String email, String imageLink) {
        this.name = name;
        this.designation = designation;
        this.phnNo = phnNo;
        this.email = email;
        this.imageLink = imageLink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getPhnNo() {
        return phnNo;
    }

    public void setPhnNo(String phnNo) {
        this.phnNo = phnNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }
}
