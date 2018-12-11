package com.github.chandanv89.telephonedirectory.persistance;

import com.github.chandanv89.telephonedirectory.model.ContactNumber;
import com.github.chandanv89.telephonedirectory.persistance.mapper.ContactNumbersMapper;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

/**
 * The type Test contact numbers data service.
 */
public class TestContactNumbersDataService {
    @InjectMocks
    private ContactNumbersDataService service;

    @Mock
    private ContactNumbersMapper mapper;

    /**
     * Init.
     */
    @Before
    private void init() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Gets contact numbers by contact id.
     */
    @Test
    public void getContactNumbersByContactId() {
        when(mapper.getContactNumbersByContactId(anyString()))
                .thenReturn(getContactNumbers());

        List<ContactNumber> contactNumbers = service.getContactNumbersByContactId("C_ID");

        verify(mapper, atLeastOnce()).getContactNumbersByContactId("C_ID");

        assertNotNull(contactNumbers);
        assertEquals(2, contactNumbers.size(), "Expected 2 contact numbers!");
    }

    /**
     * Gets all contact numbers.
     */
    @Test
    public void getAllContactNumbers() {
        when(mapper.getAllContactNumbers()).thenReturn(getContactNumbers());

        List<ContactNumber> contactNumbers = service.getAllContactNumbers();

        verify(mapper, atLeastOnce()).getAllContactNumbers();

        assertNotNull(contactNumbers);
        assertEquals(2, contactNumbers.size(), "Expected 2 contact numbers!");
    }

    /**
     * Add contact number.
     */
    @Test
    public void addContactNumber() {

        doAnswer(ans -> true).when(mapper.addContactNumber(any(ContactNumber.class)));

        boolean status = service.addContactNumber(getContactNumbers().get(0));

        verify(mapper, atLeastOnce()).addContactNumber(getContactNumbers().get(0));

        assertTrue(status);
    }

    /**
     * Add contact numbers.
     */
    @Test
    public void addContactNumbers() {
        doAnswer(ans -> true).when(mapper.addContactNumbers(anyList()));

        int count = service.addContactNumbers(getContactNumbers());

        verify(mapper, atLeastOnce()).addContactNumbers(getContactNumbers());

        assertEquals(2, count);
    }

    /**
     * Update contact number.
     */
    @Test
    public void updateContactNumber() {
        // yet to be tested
    }

    /**
     * Delete contact number.
     */
    @Test
    public void deleteContactNumber() {
        // yet to be tested
    }

    /**
     * Delete contact numbers by contact id.
     */
    @Test
    public void deleteContactNumbersByContactId() {
        // yet to be tested
    }

    private List<ContactNumber> getContactNumbers() {
        List<ContactNumber> contactNumbers = new ArrayList<>();

        ContactNumber cn1 = new ContactNumber();
        ContactNumber cn2 = new ContactNumber();

        contactNumbers.add(cn1);
        contactNumbers.add(cn2);

        return contactNumbers;
    }
}
