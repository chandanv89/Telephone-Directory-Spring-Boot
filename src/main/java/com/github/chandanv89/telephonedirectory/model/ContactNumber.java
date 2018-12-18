package com.github.chandanv89.telephonedirectory.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.chandanv89.telephonedirectory.utility.Utilities;

/**
 * The type Contact number.
 */
public class ContactNumber extends IContact {
    @JsonProperty("number")
    private String number;

    /**
     * Instantiates a new Contact number.
     */
    public ContactNumber() {
        super.category = ContactCategory.PERSONAL;
        super.isPrimary = false;
    }

    /**
     * Instantiates a new Contact number.
     *
     * @param number the number
     */
    public ContactNumber(String number) {
        this.number = number;
        super.category = ContactCategory.PERSONAL;
        super.isPrimary = false;
    }

    /**
     * Instantiates a new Contact number.
     *
     * @param number    the number
     * @param category  the category
     * @param isPrimary the is primary
     */
    public ContactNumber(String number, ContactCategory category, boolean isPrimary) {
        this.number = number;
        super.category = category;
        super.isPrimary = isPrimary;
    }

    /**
     * Instantiates a new Contact number.
     *
     * @param number    the number
     * @param category  the category
     * @param isPrimary the is primary
     */
    public ContactNumber(String number, String category, boolean isPrimary) {
        this.number = number;
        super.isPrimary = isPrimary;
        super.category = ContactCategory.fromString(category.toUpperCase());

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
     * Gets number.
     *
     * @return the number
     */
    public String getNumber() {
        return number;
    }

    /**
     * Sets number.
     *
     * @param number the number
     */
    public void setNumber(String number) {
        this.number = number;
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
     * Sets category.
     *
     * @param category the category
     */
    public void setCategory(String category) {
        super.category = ContactCategory.fromString(category);
    }

    /**
     * Set category.
     *
     * @param category the category
     */
    public void setCategory(ContactCategory category) {
        super.category = category;
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
