package com.github.chandanv89.telephonedirectory.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.chandanv89.telephonedirectory.utility.Utilities;

/**
 * The type Email.
 */
public class Email extends IContact {
    @JsonProperty("emailId")
    private String emailId;

    /**
     * Instantiates a new Email.
     */
    public Email() {
        super.category = ContactCategory.PERSONAL;
        super.isPrimary = false;
    }

    /**
     * Instantiates a new Email.
     *
     * @param emailId the email id
     */
    public Email(String emailId) {
        this.emailId = emailId;
        super.category = ContactCategory.PERSONAL;
        super.isPrimary = false;
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
        super.category = category;
        super.isPrimary = isPrimary;
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
        super.isPrimary = isPrimary;
        super.category = ContactCategory.fromString(category);
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
        super.id = id;
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
        super.category = category;
    }

    /**
     * Sets category.
     *
     * @param category the category
     */
    public void setCategory(String category) {
        super.category = ContactCategory.fromString(category);
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

    /**
     * Gets created on.
     *
     * @return the created on
     */
    public String getCreatedOn() {
        return createdOn;
    }

    /**
     * Sets created on.
     *
     * @param createdOn the created on
     */
    public void setCreatedOn(String createdOn) {
        super.createdOn = createdOn;
    }

    /**
     * Gets updated on.
     *
     * @return the updated on
     */
    public String getUpdatedOn() {
        return updatedOn;
    }

    /**
     * Sets updated on.
     *
     * @param updatedOn the updated on
     */
    public void setUpdatedOn(String updatedOn) {
        super.updatedOn = updatedOn;
    }

    /**
     * Sets parent contact id.
     *
     * @param parentContactId the parent contact id
     */
    public void setParentContactId(String parentContactId) {
        super.parentContactId = parentContactId;
    }

    /**
     * Gets parent contact id.
     *
     * @return the parent contact id
     */
    public String getParentContactId() {
        return parentContactId;
    }

    @Override
    public String toString() {
        return Utilities.toString(this);
    }
}
