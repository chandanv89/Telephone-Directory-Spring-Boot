package com.github.chandanv89.telephonedirectory.persistance.mapper;

import com.github.chandanv89.telephonedirectory.model.ContactNumber;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * The interface Contact numbers mapper.
 */
public interface ContactNumbersMapper {
    /**
     * Gets all contact numbers.
     *
     * @return the all contact numbers
     */
    List<ContactNumber> getAllContactNumbers();

    /**
     * Gets contact numbers by contact id.
     *
     * @param contactId the contact id
     * @return the contact numbers by contact id
     */
    List<ContactNumber> getContactNumbersByContactId(@Param("contactId") String contactId);

    /**
     * Add contact number boolean.
     *
     * @param contactNumber the contact number
     * @return the boolean
     */
    boolean addContactNumber(@Param("contactNumber") ContactNumber contactNumber);

    /**
     * Add contact numbers int.
     *
     * @param contactNumbers the contact numbers
     * @return the int
     */
    int addContactNumbers(@Param("contactNumbers") List<ContactNumber> contactNumbers);

    /**
     * Update contact number boolean.
     *
     * @param contactNumber the contact number
     * @return the boolean
     */
    boolean updateContactNumber(@Param("contactNumber") ContactNumber contactNumber);

    /**
     * Delete contact number boolean.
     *
     * @param id the id
     * @return the boolean
     */
    boolean deleteContactNumber(@Param("id") String id);

    /**
     * Delete contact numbers by contact id boolean.
     *
     * @param parentContactId the parent contact id
     * @return the boolean
     */
    boolean deleteContactNumbersByContactId(@Param("parentContactId") String parentContactId);
}
