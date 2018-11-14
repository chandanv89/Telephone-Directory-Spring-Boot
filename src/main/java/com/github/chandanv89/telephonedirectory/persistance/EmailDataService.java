package com.github.chandanv89.telephonedirectory.persistance;

import com.github.chandanv89.telephonedirectory.model.Email;
import com.github.chandanv89.telephonedirectory.persistance.mapper.EmailsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Email data service.
 */
@Service
public class EmailDataService {
    @Autowired
    private EmailsMapper emailsMapper;

    /**
     * Gets all emails.
     *
     * @return the all emails
     */
    public List<Email> getAllEmails() {
        return emailsMapper.getAllEmails();
    }

    /**
     * Gets emails by contact id.
     *
     * @param contactId the contact id
     * @return the emails by contact id
     */
    public List<Email> getEmailsByContactId(String contactId) {
        return emailsMapper.getEmailsByContactId(contactId);
    }

    /**
     * Add email boolean.
     *
     * @param email the email
     * @return the boolean
     */
    public boolean addEmail(Email email) {
        return emailsMapper.addEmail(email);
    }

    /**
     * Add emails int.
     *
     * @param emails the emails
     * @return the int
     */
    public int addEmails(List<Email> emails) {
        return emailsMapper.addEmails(emails);
    }

    /**
     * Update email boolean.
     *
     * @param email the email
     * @return the boolean
     */
    public boolean updateEmail(Email email) {
        return emailsMapper.updateEmail(email);
    }

    /**
     * Delete email boolean.
     *
     * @param id the id
     * @return the boolean
     */
    public boolean deleteEmail(String id) {
        return emailsMapper.deleteEmail(id);
    }

    /**
     * Delete emails by contact id boolean.
     *
     * @param parentContactId the parent contact id
     * @return the boolean
     */
    public boolean deleteEmailsByContactId(String parentContactId) {
        return emailsMapper.deleteEmailsByContactId(parentContactId);
    }
}
