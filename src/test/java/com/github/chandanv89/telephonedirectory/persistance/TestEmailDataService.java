package com.github.chandanv89.telephonedirectory.persistance;

import com.github.chandanv89.telephonedirectory.model.Email;
import com.github.chandanv89.telephonedirectory.persistance.mapper.EmailsMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;

/**
 * The type Test email data service.
 */
public class TestEmailDataService {
    @InjectMocks
    private EmailDataService dataService;

    @Mock
    private EmailsMapper mapper;

    /**
     * Inti.
     */
    @Before
    public void inti() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Test add emails method when a valid list is passed.
     */
    @Test
    public void testAddEmailsMethodWhenAValidListIsPassed() {
        List<Email> emails = getEmails();

        when(mapper.addEmails(anyList())).thenReturn(emails.size());

        int count = dataService.addEmails(emails);

        assertEquals(emails.size(), count);
        verify(mapper, atLeastOnce()).addEmails(emails);
    }

    /**
     * Test add emails method when an empty list is passed.
     */
    @Test
    public void testAddEmailsMethodWhenAnEmptyListIsPassed() {
        List<Email> emails = new ArrayList<>();

        when(mapper.addEmails(anyList())).thenReturn(emails.size());

        int count = dataService.addEmails(emails);

        assertEquals(0, count);
        verify(mapper, atLeastOnce()).addEmails(emails);
    }

    private List<Email> getEmails() {
        List<Email> emails = new ArrayList<>();
        Email email1 = new Email();
        email1.setEmailId("foo@exaple.com");
        emails.add(email1);

        Email email2 = new Email();
        email2.setEmailId("foo@exaple.com");
        emails.add(email2);

        return emails;
    }
}
