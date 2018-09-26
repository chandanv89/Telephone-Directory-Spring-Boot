package com.github.chandanv89.telephonedirectory.persistance.mapper;

import com.github.chandanv89.telephonedirectory.model.ContactNumber;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ContactNumbersMapper {
    List<ContactNumber> getAllContactNumbers();

    List<ContactNumber> getContactNumbersByContactId(@Param("contactId") String contactId);

    boolean addContactNumber(@Param("contactNumber") ContactNumber contactNumber);

    int addContactNumbers(@Param("contactNumbers") List<ContactNumber> contactNumbers);

    boolean updateContactNumber(@Param("contactNumber") ContactNumber contactNumber);

    boolean deleteContactNumber(@Param("id") String id);
}
