package com.github.chandanv89.telephonedirectory.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Email.
 */
public class Email {
    @JsonProperty("id")
    private String id;

    @JsonIgnore
    @JsonProperty("category")
    private ContactCategory category;

    @JsonIgnore
    @JsonProperty("isPrimary")
    private boolean isPrimary;

    public Email() {
        this.category = ContactCategory.PERSONAL;
        this.isPrimary = false;
    }

    /**
     * Instantiates a new Email.
     *
     * @param id the id
     */
    public Email(String id) {
        this.id = id;
        this.category = ContactCategory.PERSONAL;
        this.isPrimary = false;
    }

    /**
     * Instantiates a new Email.
     *
     * @param id        the id
     * @param category  the category
     * @param isPrimary the is primary
     */
    public Email(String id, ContactCategory category, boolean isPrimary) {
        this.id = id;
        this.category = category;
        this.isPrimary = isPrimary;
    }

    public Email(String id, String category, boolean isPrimary) {
        this.id = id;
        this.isPrimary = isPrimary;
        this.category = ContactCategory.OTHERS.fromString(category);

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
                ", category=" + category +
                ", isPrimary=" + isPrimary +
                '}';
    }
}
