package com.whatEver.iitnstu.models;

/**
 * Model class for Official.
 *
 * It represent a official with all its data accordingly
 */
public class Official {
    private String name;
    private String contactInfo;
    private String phnNo;
    private String email;
    private String imageLink;

    public Official(String name, String contactInfo, String phnNo, String email, String imageLink) {
        this.name = name;
        this.contactInfo = contactInfo;
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

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
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
