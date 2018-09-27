package com.github.chandanv89.telephonedirectory.persistance;

import com.github.chandanv89.telephonedirectory.model.Email;
import com.github.chandanv89.telephonedirectory.persistance.mapper.EmailsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The type Email data service.
 */
@Component
public class EmailDataService implements EmailsMapper {
    @Autowired
    private EmailsMapper emailsMapper;

    @Override
    public List<Email> getAllEmails() {
        return null;
    }

    @Override
    public List<Email> getEmailsByContactId(String contactId) {
        return emailsMapper.getEmailsByContactId(contactId);
    }

    @Override
    public boolean addEmail(Email email) {
        return false;
    }

    @Override
    public int addEmails(List<Email> emails) {
        return emailsMapper.addEmails(emails);
    }

    @Override
    public boolean updateEmail(Email email) {
        return false;
    }

    @Override
    public boolean deleteEmail(String id) {
        return false;
    }
}
