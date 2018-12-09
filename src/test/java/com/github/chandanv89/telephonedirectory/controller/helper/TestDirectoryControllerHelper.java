package com.github.chandanv89.telephonedirectory.controller.helper;

import com.github.chandanv89.telephonedirectory.model.*;
import com.github.chandanv89.telephonedirectory.persistance.ContactNumbersDataService;
import com.github.chandanv89.telephonedirectory.persistance.ContactsDataService;
import com.github.chandanv89.telephonedirectory.persistance.EmailDataService;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

import static com.github.chandanv89.telephonedirectory.model.ResponseMessages.DCH_NO_CONTACTS_FOUND;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class TestDirectoryControllerHelper {
    @InjectMocks
    private DirectoryControllerHelper helper;

    @Mock
    private ContactsDataService contactsDataService;

    @Mock
    private ContactNumbersDataService contactNumbersDataService;

    @Mock
    private EmailDataService emailDataService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllContactsMethodWhenNoContactsFoundInTheDirectory() {
        when(contactsDataService.getAllContacts()).thenReturn(new ArrayList<>());

        ApiResponse response = helper.getAllContacts();

        assertNotNull("Empty response!", response);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatus());
        assertEquals(DCH_NO_CONTACTS_FOUND, response.getBody());
    }

    @Test
    public void testGetAllContactsMethodWhenContactsFetchedSuccessfully() {
        when(contactsDataService.getAllContacts()).thenReturn(getContacts());
        when(contactNumbersDataService.getContactNumbersByContactId(anyString())).thenReturn(getContactNumbers());
        when(emailDataService.getEmailsByContactId(anyString())).thenReturn(getEmails());

        ApiResponse response = helper.getAllContacts();

        assertNotNull("Empty response!", response);
        assertEquals(HttpStatus.OK, response.getStatus());
    }

    @Test
    public void testGetAllContactsMethodWhenAnExceptionOccurred() {
        when(contactsDataService.getAllContacts()).thenThrow(new RuntimeException("Testing"));

        ApiResponse response = helper.getAllContacts();

        assertNotNull("Empty response!", response);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatus());
        assertTrue(StringUtils.containsIgnoreCase((String) response.getBody(), "Testing"));
    }

    private List<ContactNumber> getContactNumbers() {
        ContactNumber cNum1 = new ContactNumber();
        cNum1.setId("C_NUM_ID_1");
        cNum1.setParentContactId("C_ID_1");
        cNum1.setNumber("+1234567890");
        cNum1.setCategory(ContactCategory.PERSONAL);
        cNum1.setCreatedOn("SomeTimeStamp");

        ContactNumber cNum2 = new ContactNumber();
        cNum2.setId("C_NUM_ID_1");
        cNum2.setParentContactId("C_ID_2");
        cNum2.setNumber("+999888999888");
        cNum2.setCategory(ContactCategory.PERSONAL);
        cNum2.setCreatedOn("SomeTimeStamp");

        List<ContactNumber> contactNumbers = new ArrayList<>();
        contactNumbers.add(cNum1);
        contactNumbers.add(cNum2);

        return contactNumbers;
    }

    private List<Email> getEmails() {
        Email pEmail = new Email();
        pEmail.setId("E_ID_1");
        pEmail.setParentContactId("C_ID_1");
        pEmail.setEmailId("abc@xyz.com");
        pEmail.setCategory(ContactCategory.PERSONAL);
        pEmail.setPrimary(true);

        Email wEmail = new Email();
        wEmail.setId("E_ID_1");
        wEmail.setParentContactId("C_ID_2");
        wEmail.setEmailId("xyz@abc.com");
        wEmail.setCategory(ContactCategory.WORK);
        wEmail.setPrimary(true);

        List<Email> emails = new ArrayList<>();
        emails.add(pEmail);
        emails.add(wEmail);

        return emails;
    }

    private List<Contact> getContacts() {
        Contact c1 = new Contact();
        c1.setId("C_ID_1");
        c1.setFirstName("Will");
        c1.setLastName("Good");
        c1.setFullName("Good, Will");
        c1.setCreatedOn("SomeTimeStamp");
        c1.setIsDeleted("N");

        Contact c2 = new Contact();
        c2.setId("C_ID_2");
        c2.setFirstName("Mary");
        c2.setLastName("Liz");
        c2.setFullName("Liz, Mary");
        c2.setCreatedOn("SomeTimeStamp");
        c2.setIsDeleted("N");

        List<Contact> contacts = new ArrayList<>();
        contacts.add(c1);
        contacts.add(c2);

        return contacts;
    }
}
