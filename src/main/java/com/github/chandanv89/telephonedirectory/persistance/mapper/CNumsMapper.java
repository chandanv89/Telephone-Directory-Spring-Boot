package com.github.chandanv89.telephonedirectory.persistance.mapper;

import com.github.chandanv89.telephonedirectory.model.ContactNumber;

import java.util.List;

public interface CNumsMapper {
    List<ContactNumber> getContactNumbersByContactId(String contactId);

    List<ContactNumber> getAllContactNumbers();

    boolean addContactNumber(ContactNumber contactNumber);

    boolean updateContactNumber(ContactNumber contactNumber);

    boolean deleteContactNumber(String id);
}
