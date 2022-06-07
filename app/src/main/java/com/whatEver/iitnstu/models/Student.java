package com.whatEver.iitnstu.models;

/**
 * Model class for Student.
 *
 * It represent a student with all its data accordingly
 */
public class Student {

    private String name;
    private String id;
    private String phone;
    private String email;
    private String imageLink;

    /**
     * Default constructor.
     *
     * @param name: name of the student
     * @param id: id number of the student
     * @param phone: phone number of the student
     * @param email: email of the student
     * @param imageLink: image of the student
     */
    public Student(String name, String id, String phone, String email, String imageLink) {
        this.name = name;
        this.id = id;
        this.phone = phone;
        this.email = email;
        this.imageLink = imageLink;
    }


    /**
     * Getter method for name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method for id
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * Getter method for phone
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Getter method for email
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Getter method for imageLink
     * @return imageLink
     */
    public String getImageLink() {
        return imageLink;
    }
}
