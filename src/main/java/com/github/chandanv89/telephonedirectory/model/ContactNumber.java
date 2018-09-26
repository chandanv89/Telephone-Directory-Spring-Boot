package com.github.chandanv89.telephonedirectory.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Contact number.
 */
public class ContactNumber {
    @JsonProperty("id")
    private String id;

    @JsonProperty("number")
    private String number;

    @JsonIgnore
    @JsonProperty("category")
    private ContactCategory category;

    @JsonIgnore
    @JsonProperty("isPrimary")
    private boolean isPrimary;

    @JsonIgnore
    @JsonProperty("createdOn")
    private String createdOn;

    @JsonIgnore
    @JsonProperty("updatedOn")
    private String updatedOn;
    private String parentContactId;

    /**
     * Instantiates a new Contact number.
     */
    public ContactNumber() {
        this.category = ContactCategory.PERSONAL;
        this.isPrimary = false;
    }

    /**
     * Instantiates a new Contact number.
     *
     * @param number the number
     */
    public ContactNumber(String number) {
        this.number = number;
        this.category = ContactCategory.PERSONAL;
        this.isPrimary = false;
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
        this.category = category;
        this.isPrimary = isPrimary;
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
        this.isPrimary = isPrimary;
        this.category = ContactCategory.OTHERS.fromString(category.toUpperCase());

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
        this.createdOn = createdOn;
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
        this.updatedOn = updatedOn;
    }

    /**
     * Sets category.
     *
     * @param category the category
     */
    public void setCategory(String category) {
        this.category = ContactCategory.fromString(category);
    }

    /**
     * Set category.
     *
     * @param category the category
     */
    public void setCategory(ContactCategory category) {
        this.category = category;
    }

    /**
     * Sets parent contact id.
     *
     * @param parentContactId the parent contact id
     */
    public void setParentContactId(String parentContactId) {
        this.parentContactId = parentContactId;
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
        return "ContactNumber{" +
                "id='" + id + '\'' +
                ", number='" + number + '\'' +
                ", category=" + category +
                ", isPrimary=" + isPrimary +
                ", parentContactId='" + parentContactId + '\'' +
                ", createdOn='" + createdOn + '\'' +
                ", updatedOn='" + updatedOn + '\'' +
                '}';
    }
}
