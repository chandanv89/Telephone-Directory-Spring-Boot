package com.github.chandanv89.telephonedirectory.controller.contract;

import com.github.chandanv89.telephonedirectory.model.ApiResponse;
import com.github.chandanv89.telephonedirectory.model.Email;

import java.util.List;

/**
 * The interface Emails.
 */
public interface IEmails {
    /**
     * Gets all emails.
     *
     * @return the all emails
     */
    ApiResponse getAllEmails();

    /**
     * Gets emails by id.
     *
     * @param id the id
     * @return the emails by id
     */
    ApiResponse getEmailsById(String id);

    /**
     * Create emails api response.
     *
     * @param parentContactId the parent contact id
     * @param emails          the emails
     * @return the api response
     */
    ApiResponse createEmails(String parentContactId, List<Email> emails);

    /**
     * Update email api response.
     *
     * @param id    the id
     * @param email the email
     * @return the api response
     */
    ApiResponse updateEmail(String id, Email email);

    /**
     * Delete email api response.
     *
     * @param id the id
     * @return the api response
     */
    ApiResponse deleteEmail(String id);

    /**
     * Delete emails by contact id api response.
     *
     * @param parentContactId the parent contact id
     * @return the api response
     */
    ApiResponse deleteEmailsByContactId(String parentContactId);
}
