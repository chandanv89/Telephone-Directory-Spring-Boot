package com.github.chandanv89.telephonedirectory.persistance.mapper;

import com.github.chandanv89.telephonedirectory.model.Contact;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * The interface Contacts mapper.
 */
public interface ContactsMapper {
    /**
     * Gets contact by id.
     *
     * @param id the id
     * @return the contact by id
     */
    Contact getContactById(@Param("id") String id);

    /**
     * Gets all contacts.
     *
     * @return the all contacts
     */
    List<Contact> getAllContacts();

    /**
     * Add contact string.
     *
     * @param contact the contact
     * @return the string
     */
    String addContact(@Param("contact") Contact contact);

    /**
     * Delete contact by id string.
     *
     * @param id the id
     * @return the string
     */
    String deleteContactById(@Param("id") String id);

    /**
     * Update contact by id string.
     *
     * @param contact the contact
     * @return the string
     */
    String updateContactById(@Param("contact") Contact contact);
}
