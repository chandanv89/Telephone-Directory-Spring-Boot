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
     * Insert a new contact.
     *
     * @param contact the contact
     * @return the number of inserted records
     */
    int addContact(@Param("contact") Contact contact);

    /**
     * Add contacts int.
     *
     * @param contacts the contacts
     * @return the int
     */
    int addContacts(@Param("contacts") List<Contact> contacts);

    /**
     * Delete contact by id string.
     *
     * @param id the id
     * @return the string
     */
    String deleteContactById(@Param("id") String id);

    /**
     * Mark contact as deleted int.
     *
     * @param id the id
     * @return the int
     */
    int markContactAsDeleted(@Param("id") String id);

    /**
     * Update contact by id string.
     *
     * @param contact the contact
     * @return the string
     */
    String updateContactById(@Param("contact") Contact contact);
}
