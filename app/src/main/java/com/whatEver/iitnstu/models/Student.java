package com.whatEver.iitnstu.models;

public class Student {

    private String name;
    private String id;
    private String phone;
    private String email;
    private String imageLink;

    public Student(String name, String id, String phone, String email, String imageLink) {
        this.name = name;
        this.id = id;
        this.phone = phone;
        this.email = email;
        this.imageLink = imageLink;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getImageLink() {
        return imageLink;
    }
}
