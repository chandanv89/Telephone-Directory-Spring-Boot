package com.github.chandanv89.telephonedirectory.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Email.
 */
public class Email {
    @JsonProperty("id")
    private String id;

    @JsonProperty("emailId")
    private String emailId;

    @JsonIgnore
    @JsonProperty("category")
    private ContactCategory category;

    @JsonIgnore
    @JsonProperty("isPrimary")
    private boolean isPrimary;

    /**
     * Instantiates a new Email.
     */
    public Email() {
        this.category = ContactCategory.PERSONAL;
        this.isPrimary = false;
    }

    /**
     * Instantiates a new Email.
     *
     * @param emailId the email id
     */
    public Email(String emailId) {
        this.emailId = emailId;
        this.category = ContactCategory.PERSONAL;
        this.isPrimary = false;
    }

    /**
     * Instantiates a new Email.
     *
     * @param emailId   the email id
     * @param category  the category
     * @param isPrimary the is primary
     */
    public Email(String emailId, ContactCategory category, boolean isPrimary) {
        this.emailId = emailId;
        this.category = category;
        this.isPrimary = isPrimary;
    }

    /**
     * Instantiates a new Email.
     *
     * @param emailId   the email id
     * @param category  the category
     * @param isPrimary the is primary
     */
    public Email(String emailId, String category, boolean isPrimary) {
        this.emailId = emailId;
        this.isPrimary = isPrimary;
        this.category = ContactCategory.OTHERS.fromString(category);
    }

    /**
     * Gets email id.
     *
     * @return the email id
     */
    public String getEmailId() {
        return emailId;
    }

    /**
     * Sets email id.
     *
     * @param emailId the email id
     */
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets category.
     *
     * @return the category
     */
    public ContactCategory getCategory() {
        return category;
    }

    /**
     * Sets category.
     *
     * @param category the category
     */
    public void setCategory(ContactCategory category) {
        this.category = category;
    }

    /**
     * Is primary boolean.
     *
     * @return the boolean
     */
    public boolean isPrimary() {
        return isPrimary;
    }

    /**
     * Sets primary.
     *
     * @param primary the primary
     */
    public void setPrimary(boolean primary) {
        isPrimary = primary;
    }

    @Override
    public String toString() {
        return "Email{" +
                "id='" + id + '\'' +
                ", emailId='" + emailId + '\'' +
                ", category=" + category +
                ", isPrimary=" + isPrimary +
                '}';
    }
}
