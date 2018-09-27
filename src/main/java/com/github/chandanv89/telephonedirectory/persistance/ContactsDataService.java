package com.github.chandanv89.telephonedirectory.persistance;

import com.github.chandanv89.telephonedirectory.model.Contact;
import com.github.chandanv89.telephonedirectory.persistance.mapper.ContactsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The type Contacts dao.
 */
@Component
public class ContactsDataService implements ContactsMapper {
    @Autowired
    private ContactsMapper contactsMapper;

    @Override
    public Contact getContactById(String id) {
        return contactsMapper.getContactById(id);
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactsMapper.getAllContacts();
    }

    @Override
    public int addContact(Contact contact) {
        return contactsMapper.addContact(contact);
    }

    @Override
    public int addContacts(List<Contact> contacts) {
        return contactsMapper.addContacts(contacts);
    }

    @Override
    public String deleteContactById(String id) {
        return contactsMapper.deleteContactById(id);
    }

    @Override
    public int markContactAsDeleted(String id) {
        return contactsMapper.markContactAsDeleted(id);
    }

    @Override
    public String updateContactById(Contact contact) {
        return contactsMapper.updateContactById(contact);
    }
}
