package com.github.chandanv89.telephonedirectory.persistance;

import com.github.chandanv89.telephonedirectory.model.Contact;
import com.github.chandanv89.telephonedirectory.persistance.mapper.ContactsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Contacts dao.
 */
@Service
public class ContactsDataService {
    @Autowired
    private ContactsMapper contactsMapper;

    /**
     * Gets contact by id.
     *
     * @param id the id
     * @return the contact by id
     */
    public Contact getContactById(String id) {
        return contactsMapper.getContactById(id);
    }


    /**
     * Gets all contacts.
     *
     * @return the all contacts
     */
    public List<Contact> getAllContacts() {
        return contactsMapper.getAllContacts();
    }


    /**
     * Add contact int.
     *
     * @param contact the contact
     * @return the int
     */
    public int addContact(Contact contact) {
        return contactsMapper.addContact(contact);
    }


    /**
     * Add contacts int.
     *
     * @param contacts the contacts
     * @return the int
     */
    public int addContacts(List<Contact> contacts) {
        return contactsMapper.addContacts(contacts);
    }


    /**
     * Delete contact by id string.
     *
     * @param id the id
     * @return the string
     */
    public String deleteContactById(String id) {
        return contactsMapper.deleteContactById(id);
    }


    /**
     * Mark contact as deleted int.
     *
     * @param id the id
     * @return the int
     */
    public int markContactAsDeleted(String id) {
        return contactsMapper.markContactAsDeleted(id);
    }


    /**
     * Update contact by id string.
     *
     * @param contact the contact
     * @return the string
     */
    public String updateContactById(Contact contact) {
        return contactsMapper.updateContactById(contact);
    }
}
