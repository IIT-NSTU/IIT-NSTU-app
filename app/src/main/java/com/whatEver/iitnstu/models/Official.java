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


    /**
     * Default constructor.
     *
     * @param name: name of the officials
     * @param contactInfo: contact number of the officials
     * @param phnNo: phone number of the officials
     * @param email: email of the officials
     * @param imageLink: image of the officials
     */
    public Official(String name, String contactInfo, String phnNo, String email, String imageLink) {
        this.name = name;
        this.contactInfo = contactInfo;
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
     * Getter method for contactInfo
     * @return contactInfo
     */
    public String getContactInfo() {
        return contactInfo;
    }

    /**
     * Setter method for contactInfo
     * @param contactInfo: contactInfo
     */
    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
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
