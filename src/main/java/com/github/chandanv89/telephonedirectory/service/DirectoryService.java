package com.github.chandanv89.telephonedirectory.service;

import com.github.chandanv89.telephonedirectory.model.Contact;
import com.github.chandanv89.telephonedirectory.persistance.dao.ContactsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Directory service.
 */
@Component
public class DirectoryService {
    @Autowired
    private ContactsDao contactsDao;

    private List<Contact> contacts;

    /**
     * Instantiates a new Directory service.
     */
    public DirectoryService() {
        contacts = new ArrayList<>();
    }

    /**
     * Gets all contacts.
     *
     * @return the all contacts
     */
    public List<Contact> getAllContacts() {
        contacts = contactsDao.getAllContacts();
        return contacts;
    }

    /**
     * Insert contact.
     *
     * @param contact the contact
     */
    public void insertContact(Contact contact) {
        this.contacts.add(contact);
    }

    /**
     * Gets contact by id.
     *
     * @param id the id
     * @return the contact by id
     */
    public List<Contact> getContactById(String id) {
        contactsDao.getContactById(id);
        if ((contacts == null || contacts.size() == 0))
            return new ArrayList<>();

        return contacts.stream().filter(c -> c.getId().equalsIgnoreCase(id))
                .collect(Collectors.toList());
    }

    /**
     * Delete by id boolean.
     *
     * @param id the id
     * @return the boolean
     */
    public boolean deleteById(String id) {
        return contacts.removeIf(c -> c.getId().equalsIgnoreCase(id));
    }
}
