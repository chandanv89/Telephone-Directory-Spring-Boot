package com.github.chandanv89.telephonedirectory.model.dto;

import com.github.chandanv89.telephonedirectory.model.ContactNumber;
import com.github.chandanv89.telephonedirectory.model.Email;
import com.github.chandanv89.telephonedirectory.utility.Utilities;

import java.util.List;

/**
 * The type Contact dto.
 */
public class ContactDTO {
    private String id;
    private String fullName;
    private String firstName;
    private String lastName;
    private List<ContactNumber> contactNumbers;
    private List<Email> emails;
    private String createdOn;
    private String updatedOn;
    private String isDeleted;

    /**
     * Instantiates a new Contact dto.
     */
    public ContactDTO() {
        // default
    }

    /**
     * Instantiates a new Contact dto.
     *
     * @param id             the id
     * @param fullName       the full name
     * @param firstName      the first name
     * @param lastName       the last name
     * @param contactNumbers the contact numbers
     * @param emails         the emails
     * @param isDeleted      the is deleted
     * @param createdOn      the created on
     * @param updatedOn      the updated on
     */
    public ContactDTO(String id, String fullName, String firstName, String lastName,
                      List<ContactNumber> contactNumbers, List<Email> emails, String isDeleted,
                      String createdOn, String updatedOn) {
        this.id = id;
        this.fullName = fullName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNumbers = contactNumbers;
        this.emails = emails;
        this.isDeleted = isDeleted;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
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
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets contact numbers.
     *
     * @return the contact numbers
     */
    public List<ContactNumber> getContactNumbers() {
        return contactNumbers;
    }

    /**
     * Sets contact numbers.
     *
     * @param contactNumbers the contact numbers
     */
    public void setContactNumbers(List<ContactNumber> contactNumbers) {
        this.contactNumbers = contactNumbers;
    }

    /**
     * Gets emails.
     *
     * @return the emails
     */
    public List<Email> getEmails() {
        return emails;
    }

    /**
     * Sets emails.
     *
     * @param emails the emails
     */
    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    /**
     * Gets full name.
     *
     * @return the full name
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Sets full name.
     *
     * @param fullName the full name
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
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
     * Gets is deleted.
     *
     * @return the is deleted
     */
    public String getIsDeleted() {
        return isDeleted;
    }

    /**
     * Sets is deleted.
     *
     * @param isDeleted the is deleted
     */
    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return Utilities.toString(this);
    }
}
