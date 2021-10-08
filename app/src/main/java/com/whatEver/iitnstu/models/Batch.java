package com.whatEver.iitnstu.models;

/**
 * Model class for Batch.
 *
 * It represent a batch with all its data accordingly
 */
public class Batch {

    private String name;
    private String description;
    private String session;
    private String icon;

    /**
     * Default constructor.
     *
     * @param name: name of the batch
     * @param description: description about the batch
     * @param session: session of the batch
     * @param icon: icon image link url of the batch
     */
    public Batch(String name, String description, String session, String icon) {
        this.name = name;
        this.description = description;
        this.session = session;
        this.icon = icon;
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
     * Getter method for session
     * @return session
     */
    public String getSession() {
        return session;
    }

    /**
     * Setter method for name
     * @param session: session
     */
    public void setSession(String session) {
        this.session = session;
    }

    /**
     * Getter method for icon
     * @return icon image link url
     */
    public String getIcon() {
        return icon;
    }

    /**
     * Setter method for icon
     * @param icon: icon image link url
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }
}
