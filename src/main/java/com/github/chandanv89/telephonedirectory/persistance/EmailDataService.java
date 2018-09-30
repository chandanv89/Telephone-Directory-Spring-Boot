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
        return emailsMapper.getAllEmails();
    }

    @Override
    public List<Email> getEmailsByContactId(String contactId) {
        return emailsMapper.getEmailsByContactId(contactId);
    }

    @Override
    public boolean addEmail(Email email) {
        return emailsMapper.addEmail(email);
    }

    @Override
    public int addEmails(List<Email> emails) {
        return emailsMapper.addEmails(emails);
    }

    @Override
    public boolean updateEmail(Email email) {
        return emailsMapper.updateEmail(email);
    }

    @Override
    public boolean deleteEmail(String id) {
        return emailsMapper.deleteEmail(id);
    }
}
