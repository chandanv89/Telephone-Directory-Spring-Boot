package com.github.chandanv89.telephonedirectory.controller.helper;

import com.github.chandanv89.telephonedirectory.model.ApiResponse;
import com.github.chandanv89.telephonedirectory.model.Contact;
import com.github.chandanv89.telephonedirectory.model.ContactNumber;
import com.github.chandanv89.telephonedirectory.model.Email;
import com.github.chandanv89.telephonedirectory.persistance.ContactNumbersDataService;
import com.github.chandanv89.telephonedirectory.persistance.ContactsDataService;
import com.github.chandanv89.telephonedirectory.persistance.EmailDataService;
import com.github.chandanv89.telephonedirectory.utility.Guid;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.github.chandanv89.telephonedirectory.model.ResponseMessages.DCH_NO_CONTACTS_FOUND;

/**
 * The type IDirectory controller helper.
 */
@Component
public class DirectoryControllerHelper {
    private static final Logger LOGGER = LogManager.getLogger(DirectoryControllerHelper.class);

    @Autowired
    private ContactsDataService contactsDataService;

    @Autowired
    private ContactNumbersDataService contactNumbersDataService;

    @Autowired
    private EmailDataService emailDataService;

    /**
     * Gets all contacts.
     *
     * @return the all contacts
     */
    public ApiResponse getAllContacts() {
        ApiResponse response = new ApiResponse();

        try {
            List<Contact> contacts = contactsDataService.getAllContacts();

            if (CollectionUtils.isNotEmpty(contacts)) {
                contacts.forEach(c -> {
                    c.setContactNumbers(contactNumbersDataService.getContactNumbersByContactId(c.getId()));
                    c.setEmails(emailDataService.getEmailsByContactId(c.getId()));
                });

                response.setBody(contacts);
                response.setStatus(HttpStatus.OK);
            } else {
                response.setStatus(HttpStatus.NOT_FOUND);
                response.setBody(DCH_NO_CONTACTS_FOUND);
            }
        } catch (Exception e) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setBody(getExceptionMsg(e));
        }

        return response;
    }

    /**
     * Gets contact by id.
     *
     * @param id the id
     * @return the contact by id
     */
    public ApiResponse getContactById(String id) {
        ApiResponse response = new ApiResponse();

        try {
            Contact contact = contactsDataService.getContactById(id);

            if (contact != null) {
                contact.setContactNumbers(contactNumbersDataService.getContactNumbersByContactId(contact.getId()));
                contact.setEmails(emailDataService.getEmailsByContactId(contact.getId()));

                response.setBody(contact);
                response.setStatus(HttpStatus.OK);
            } else {
                response.setStatus(HttpStatus.NOT_FOUND);
                response.setBody("No contact found for the given ID!");
            }
        } catch (Exception e) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setBody(getExceptionMsg(e));
        }

        return response;
    }

    /**
     * Add contact api response.
     *
     * @param contact the contact
     * @return the api response
     */
    public ApiResponse addContact(Contact contact) {
        ApiResponse response;

        try {
            // validate the incoming request object.
            // If found, ApiResponse would be populated with the validation errors
            response = validateRequest(contact);

            if (response != null) {
                return response;
            }

            response = new ApiResponse();

            contact.setId(Guid.generate());
            LOGGER.info(">>> Added new contact {}", contact.getId());

            int count = contactsDataService.addContact(contact);

            if (count > 0) {
                LOGGER.info(">>> Added new contact {}", contact.getId());

                populateEmailIds(contact);
                populateContactNumbers(contact);

                response.setBody(contact);
                response.setStatus(HttpStatus.CREATED);
            } else {
                LOGGER.info(">>> Failed to insert the contact!");
                response.setBody(null);
                response.setStatus(HttpStatus.EXPECTATION_FAILED);
            }
        } catch (Exception e) {
            response = new ApiResponse();
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setBody(getExceptionMsg(e));
        }

        return response;
    }

    private void populateContactNumbers(Contact contact) {
        contact.getContactNumbers().forEach(cn -> {
            cn.setId(Guid.generate());
            cn.setParentContactId(contact.getId());
        });

        int count = contact.getContactNumbers().size();

        if (count > 1) {
            contactNumbersDataService.addContactNumbers(contact.getContactNumbers());
            LOGGER.info(">>> Added multiple contact numbers to the contact {}", contact.getId());
        } else if (count == 1) {
            contactNumbersDataService.addContactNumber(contact.getContactNumbers().get(0));
            LOGGER.info(">>> Added a contact number to the contact {}", contact.getId());
        } else {
            LOGGER.info(">>> No contact numbers to add for the contact {}", contact.getId());
        }
    }

    private void populateEmailIds(Contact contact) {
        contact.getEmails().forEach(e -> {
            e.setId(Guid.generate());
            e.setParentContactId(contact.getId());
        });

        int count = contact.getEmails().size();

        if (count > 1) {
            emailDataService.addEmails(contact.getEmails());
            LOGGER.info(">>> Added multiple email entries to the contact {}", contact.getId());
        } else if (count == 1) {
            emailDataService.addEmail(contact.getEmails().get(0));
            LOGGER.info(">>> Added an email entry to the contact {}", contact.getId());
        } else {
            LOGGER.info(">>> No email details to add for the contact {}", contact.getId());
        }
    }

    /**
     * Delete contact by id api response.
     *
     * @param id the id
     * @return the api response
     */
    public ApiResponse deleteContactById(String id) {
        ApiResponse response = new ApiResponse();

        try {
            if (StringUtils.isBlank(id)) {
                LOGGER.info("Empty Contact ID!");
                response.setStatus(HttpStatus.BAD_REQUEST);
                response.setBody("Empty Contact ID!");
                return response;
            }

            int status = contactsDataService.markContactAsDeleted(id);

            if (status > 0) {
                response.setStatus(HttpStatus.OK);
                response.setBody(contactsDataService.getContactById(id));
            } else {
                response.setStatus(HttpStatus.NOT_MODIFIED);
                response.setBody("Nothing to update!");
            }
        } catch (Exception e) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setBody(getExceptionMsg(e));
        }

        return response;
    }

    private ApiResponse validateRequest(Contact contact) {
        if (contact == null) {
            String message = "Null input!";
            LOGGER.info(">>> " + message);
            ApiResponse response = new ApiResponse();
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setBody(message);
            return response;
        }

        List<ContactNumber> contactNumbers = contact.getContactNumbers();
        List<Email> emails = contact.getEmails();

        boolean isContactNumsEmpty = false;
        boolean isEmailsEmpty = false;

        if (CollectionUtils.isEmpty(contactNumbers)) {
            isContactNumsEmpty = true;
        }

        if (CollectionUtils.isEmpty(emails)) {
            isEmailsEmpty = true;
        }

        if (isContactNumsEmpty && isEmailsEmpty) {
            String message = "Missing both contact number and emails information. Nothing to add!";
            ApiResponse response = new ApiResponse();
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setBody(message);
            return response;
        }

        return null;
    }

    public ApiResponse addContacts(List<Contact> contacts) {
        ApiResponse response = new ApiResponse();
        List<ApiResponse> responses = new ArrayList<>();

        try {
            if (CollectionUtils.isEmpty(contacts)) {
                response.setStatus(HttpStatus.BAD_REQUEST);
                response.setBody("Expected a list of contacts to add!");

                return response;
            }

            contacts.forEach(c -> responses.add(this.addContact(c)));
        } catch (Exception e) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setBody(getExceptionMsg(e));
        }

        return responses.get(0);
    }

    private String getExceptionMsg(final Exception e) {
        LOGGER.error(e);
        return "Please check logs for more details on the error: "
                + e.getMessage();
    }
}
