package com.whatEver.iitnstu.models;

/**
 * Model class for Notice.
 *
 * It represent a notice with all its data accordingly
 */
public class Notice {
    private String date;
    private String about;
    private String description;
    private String pdf;

    /**
     * Default constructor.
     *
     * @param date: date of notice
     * @param about: title of the notice
     * @param description: description of the notice
     * @param pdf: pdf of notice
     */

    public Notice(String date, String about, String description, String pdf) {
        this.date = date;
        this.about = about;
        this.description = description;
        this.pdf=pdf;
    }

    /**
     * Getter method for date
     * @return date
     */

    public String getDate() {
        return date;
    }

    /**
     * Setter method for date
     * @param date: date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Getter method for about
     * @return about
     */
    public String getAbout() {
        return about;
    }

    /**
     * Setter method for about
     * @param about: about
     */
    public void setAbout(String about) {
        this.about = about;
    }

    /**
     * Getter method for description
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter method for description
     * @param description: description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter method for pdf
     * @return pdf
     */
    public String getPdf() {
        return pdf;
    }

    /**
     * Setter method for pdf
     * @param pdf: pdf
     */
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
