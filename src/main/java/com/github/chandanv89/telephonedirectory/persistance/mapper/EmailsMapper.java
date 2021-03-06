package com.github.chandanv89.telephonedirectory.persistance.mapper;

import com.github.chandanv89.telephonedirectory.model.Email;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * The interface Emails mapper.
 */
public interface EmailsMapper {

    /**
     * Gets all emails.
     *
     * @return the all emails
     */
    List<Email> getAllEmails();

    /**
     * Gets emails by contact id.
     *
     * @param contactId the contact id
     * @return the emails by contact id
     */
    List<Email> getEmailsByContactId(@Param("contactId") String contactId);

    /**
     * Add email boolean.
     *
     * @param email the email
     * @return the boolean
     */
    boolean addEmail(@Param("email") Email email);

    /**
     * Add emails int.
     *
     * @param emails the emails
     * @return the int
     */
    int addEmails(@Param("emails") List<Email> emails);

    /**
     * Update email boolean.
     *
     * @param email the email
     * @return the boolean
     */
    boolean updateEmail(@Param("email") Email email);

    /**
     * Delete email boolean.
     *
     * @param id the id
     * @return the boolean
     */
    boolean deleteEmail(@Param("id") String id);

    /**
     * Delete emails by contact id boolean.
     *
     * @param parentContactId the parent contact id
     * @return the boolean
     */
    boolean deleteEmailsByContactId(@Param("parentContactId") String parentContactId);
}
