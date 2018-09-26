package com.github.chandanv89.telephonedirectory.persistance;

import com.github.chandanv89.telephonedirectory.model.ContactNumber;
import com.github.chandanv89.telephonedirectory.persistance.mapper.ContactNumbersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The type Contact numbers data service.
 */
@Component
public class ContactNumbersDataService implements ContactNumbersMapper {
    @Autowired
    private ContactNumbersMapper contactNumbersMapper;

    @Override
    public List<ContactNumber> getContactNumbersByContactId(String contactId) {
        return contactNumbersMapper.getContactNumbersByContactId(contactId);
    }

    @Override
    public List<ContactNumber> getAllContactNumbers() {
        return null;
    }

    @Override
    public boolean addContactNumber(ContactNumber contactNumber) {
        return false;
    }

    @Override
    public int addContactNumbers(List<ContactNumber> contactNumbers) {
        return contactNumbersMapper.addContactNumbers(contactNumbers);
    }

    @Override
    public boolean updateContactNumber(ContactNumber contactNumber) {
        return false;
    }

    @Override
    public boolean deleteContactNumber(String id) {
        return false;
    }
}
