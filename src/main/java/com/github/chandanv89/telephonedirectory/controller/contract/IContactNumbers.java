package com.github.chandanv89.telephonedirectory.controller.contract;

import com.github.chandanv89.telephonedirectory.model.ApiResponse;
import com.github.chandanv89.telephonedirectory.model.ContactNumber;

import java.util.List;

/**
 * The interface Contact numbers controller.
 */
public interface IContactNumbers {
    /**
     * Gets all contact numbers.
     *
     * @return the all contact numbers
     */
    ApiResponse getAllContactNumbers();

    /**
     * Gets contact number by id.
     *
     * @param id the id
     * @return the contact number by id
     */
    ApiResponse getContactNumberById(String id);

    /**
     * Create contact numbers int.
     *
     * @param parentContactId the parent contact id
     * @param contactNumbers  the contact numbers
     * @return the int
     */
    ApiResponse createContactNumbers(String parentContactId, List<ContactNumber> contactNumbers);

    /**
     * Update contact number boolean.
     *
     * @param id            the id
     * @param contactNumber the contact number
     * @return the boolean
     */
    ApiResponse updateContactNumber(String id, ContactNumber contactNumber);

    /**
     * Delete contact number boolean.
     *
     * @param id the id
     * @return the boolean
     */
    ApiResponse deleteContactNumber(String id);

    /**
     * Delete contact numbers by contact id boolean.
     *
     * @param contactId the contact id
     * @return the boolean
     */
    ApiResponse deleteContactNumbersByContactId(String contactId);
}
