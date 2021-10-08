package com.whatEver.iitnstu.models;

/**
 * Model class for CourseCo.
 *
 * It represent a courseCo with all its data accordingly
 */
public class CourseCo {

    private String name;
    private String designation;
    private String phnNo;
    private String email;
    private String info;
    private String imageLink;

    /**
     * Default constructor.
     *
     * @param name: name of the teacher
     * @param designation: designation of the teacher
     * @param phnNo: phone number of the teacher
     * @param email: email of the teacher
     * @param info: info about the teacher
     * @param imageLink: image of the teacher
     */

    public CourseCo(String name, String designation, String phnNo, String email, String info, String imageLink) {
        this.name = name;
        this.designation = designation;
        this.phnNo = phnNo;
        this.email = email;
        this.info = info;
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
     * Getter method for info
     * @return info
     */
    public String getInfo() {
        return info;
    }

    /**
     * Setter method for info
     * @param info: info
     */
    public void setInfo(String info) {
        this.info = info;
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
