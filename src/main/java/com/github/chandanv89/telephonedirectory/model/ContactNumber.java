package com.github.chandanv89.telephonedirectory.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Contact number.
 */
public class ContactNumber {
    @JsonProperty("number")
    private String number;

    @JsonIgnore
    @JsonProperty("category")
    private ContactCategory category;

    @JsonIgnore
    @JsonProperty("isPrimary")
    private boolean isPrimary;

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
        this.category = ContactCategory.OTHERS.fromString(category);

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
     * Sets category.
     *
     * @param category the category
     */
    public void setCategory(ContactCategory category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "ContactNumber{" +
                "number='" + number + '\'' +
                ", category=" + category +
                ", isPrimary=" + isPrimary +
                '}';
    }
}
