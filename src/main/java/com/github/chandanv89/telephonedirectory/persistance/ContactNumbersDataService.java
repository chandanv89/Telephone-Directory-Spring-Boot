package com.github.chandanv89.telephonedirectory.persistance;

import com.github.chandanv89.telephonedirectory.model.ContactNumber;
import com.github.chandanv89.telephonedirectory.persistance.mapper.ContactNumbersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Contact numbers data service.
 */
@Service
public class ContactNumbersDataService {
    @Autowired
    private ContactNumbersMapper contactNumbersMapper;

    /**
     * Gets contact numbers by contact id.
     *
     * @param contactId the contact id
     * @return the contact numbers by contact id
     */
    public List<ContactNumber> getContactNumbersByContactId(String contactId) {
        return contactNumbersMapper.getContactNumbersByContactId(contactId);
    }

    /**
     * Gets all contact numbers.
     *
     * @return the all contact numbers
     */
    public List<ContactNumber> getAllContactNumbers() {
        return contactNumbersMapper.getAllContactNumbers();
    }

    /**
     * Add contact number boolean.
     *
     * @param contactNumber the contact number
     * @return the boolean
     */
    public boolean addContactNumber(ContactNumber contactNumber) {
        return contactNumbersMapper.addContactNumber(contactNumber);
    }

    /**
     * Add contact numbers int.
     *
     * @param contactNumbers the contact numbers
     * @return the int
     */
    public int addContactNumbers(List<ContactNumber> contactNumbers) {
        return contactNumbersMapper.addContactNumbers(contactNumbers);
    }

    /**
     * Update contact number boolean.
     *
     * @param contactNumber the contact number
     * @return the boolean
     */
    public boolean updateContactNumber(ContactNumber contactNumber) {
        return contactNumbersMapper.updateContactNumber(contactNumber);
    }

    /**
     * Delete contact number boolean.
     *
     * @param id the id
     * @return the boolean
     */
    public boolean deleteContactNumber(String id) {
        return contactNumbersMapper.deleteContactNumber(id);
    }

    /**
     * Delete contact numbers by contact id boolean.
     *
     * @param parentContactId the parent contact id
     * @return the boolean
     */
    public boolean deleteContactNumbersByContactId(String parentContactId) {
        return contactNumbersMapper.deleteContactNumbersByContactId(parentContactId);
    }
}
