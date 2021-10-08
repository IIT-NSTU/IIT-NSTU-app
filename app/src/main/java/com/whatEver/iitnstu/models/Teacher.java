package com.whatEver.iitnstu.models;

/**
 * Model class for Teacher.
 *
 * It represent a teacher with all its data accordingly
 */
public class Teacher {
    private String name;
    private String designation;
    private String phnNo;
    private String email;
    private String imageLink;


    /**
     * Default constructor.
     *
     * @param name: name of the teacher
     * @param designation: designation of the teacher
     * @param phnNo: phone number of the teacher
     * @param email: email of the teacher
     * @param imageLink: image of the teacher
     */
    public Teacher(String name, String designation, String phnNo, String email, String imageLink) {
        this.name = name;
        this.designation = designation;
        this.phnNo = phnNo;
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
     * Setter method for name
     * @param name: name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for designation
     * @return designation
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * Setter method for designation
     * @param designation: designation
     */
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    /**
     * Getter method for phnNo
     * @return phnNo
     */
    public String getPhnNo() {
        return phnNo;
    }

    /**
     * Setter method for phnNo
     * @param phnNo: phnNo
     */
    public void setPhnNo(String phnNo) {
        this.phnNo = phnNo;
    }

    /**
     * Getter method for email
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter method for email
     * @param email: email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter method for imageLink
     * @return imageLink
     */
    public String getImageLink() {
        return imageLink;
    }

    /**
     * Setter method for imageLink
     * @param imageLink: imageLink
     */
    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }
}
