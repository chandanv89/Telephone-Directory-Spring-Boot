package com.github.chandanv89.telephonedirectory.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Contact.
 */
public class IContact {
    @JsonProperty("id")
    protected String id;

    @JsonIgnore
    @JsonProperty("category")
    protected ContactCategory category;

    @JsonIgnore
    @JsonProperty("isPrimary")
    protected boolean isPrimary;

    @JsonIgnore
    @JsonProperty("createdOn")
    protected String createdOn;

    @JsonIgnore
    @JsonProperty("updatedOn")
    protected String updatedOn;

    @JsonIgnore
    @JsonProperty("parentContactId")
    protected String parentContactId;

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
     * Gets parent contact id.
     *
     * @return the parent contact id
     */
    public String getParentContactId() {
        return parentContactId;
    }

    /**
     * Sets parent contact id.
     *
     * @param parentContactId the parent contact id
     */
    public void setParentContactId(String parentContactId) {
        this.parentContactId = parentContactId;
    }
}
