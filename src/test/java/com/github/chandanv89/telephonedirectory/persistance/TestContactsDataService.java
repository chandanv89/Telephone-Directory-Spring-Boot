package com.github.chandanv89.telephonedirectory.persistance;

import com.github.chandanv89.telephonedirectory.model.Contact;
import com.github.chandanv89.telephonedirectory.model.ContactNumber;
import com.github.chandanv89.telephonedirectory.model.Email;
import com.github.chandanv89.telephonedirectory.persistance.mapper.ContactsMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class TestContactsDataService {
    @InjectMocks
    private ContactsDataService contactsDataService;

    @Mock
    private ContactsMapper contactsMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        when(contactsMapper.addContact(Mockito.any(Contact.class))).thenReturn(1);

        when(contactsMapper.getAllContacts()).thenReturn(getContacts());

        when(contactsMapper.getContactById(anyString())).thenReturn(Objects.requireNonNull(getContacts()).get(0));

        when(contactsMapper.deleteContactById(anyString())).thenReturn("");

        when(contactsMapper.updateContactById(any(Contact.class))).thenReturn("");
    }

    private List<Contact> getContacts() {
        List<Contact> contacts = new ArrayList<>();

        List<Email> emails = new ArrayList<>();
        Email e1 = new Email();

        List<ContactNumber> contactNumbers = new ArrayList<>();
        ContactNumber cn1 = new ContactNumber();

        Contact c1 = new Contact();
        c1.setId("CONTACT-ID-1");
        c1.setFullName("First Last");
        c1.setFirstName("First");
        c1.setLastName("Last");
        c1.setEmails(emails);
        c1.setContactNumbers(contactNumbers);
        c1.setCreatedOn("20180915");
        c1.setUpdatedOn(null);

        Contact c2 = new Contact();
        c2.setId("CONTACT-ID-2");
        c2.setFullName("First Last");
        c2.setFirstName("First");
        c2.setLastName("Last");
        c2.setEmails(emails);
        c2.setContactNumbers(contactNumbers);
        c2.setCreatedOn("20180915");
        c2.setUpdatedOn(null);

        contacts.add(c1);
        contacts.add(c2);

        return contacts;
    }

    @Test
    void testGetContactById() {
        Contact contact = contactsDataService.getContactById("123");

        verify(contactsMapper, atLeastOnce()).getContactById("123");
        assertNotNull(contact, "Not supposed to be null!");
    }

    @Test
    void testGetAllContacts() {
    }

    @Test
    void testAddContact() {
    }

    @Test
    void testDeleteContactById() {
    }

    @Test
    void testUpdateContactById() {
    }
}