package com.github.chandanv89.telephonedirectory.controller;

import com.github.chandanv89.telephonedirectory.model.ApiResponse;
import com.github.chandanv89.telephonedirectory.model.Contact;

/**
 * The interface Directory.
 */
public interface Directory {
    /**
     * Add contact api response.
     *
     * @param contact the contact
     * @return the api response
     */
    ApiResponse addContact(Contact contact);

    /**
     * Gets all contacts.
     *
     * @return the all contacts
     */
    ApiResponse getAllContacts();

    /**
     * Gets contact by id.
     *
     * @param id the id
     * @return the contact by id
     */
    ApiResponse getContactById(String id);

    /**
     * Delete contact by id api response.
     *
     * @param id the id
     * @return the api response
     */
    ApiResponse deleteContactById(String id);

    /**
     * Update contact by id api response.
     *
     * @param id      the id
     * @param contact the contact
     * @return the api response
     */
    ApiResponse updateContactById(String id, Contact contact);
}
