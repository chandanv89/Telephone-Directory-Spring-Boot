package com.github.chandanv89.telephonedirectory.controller.helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.chandanv89.telephonedirectory.model.*;
import com.github.chandanv89.telephonedirectory.model.dto.ContactDTO;
import com.github.chandanv89.telephonedirectory.repository.ContactsRepository;
import com.github.chandanv89.telephonedirectory.utility.Utilities;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * The type Contacts controller helper.
 */
@Component
public class ContactsControllerHelper {
    private static final Logger LOGGER = LogManager.getLogger(ContactsControllerHelper.class);

    @Autowired
    private ContactsRepository repository;

    /**
     * Gets all.
     *
     * @return the all
     */
    public ApiResponse getAll() {
        ApiResponse response = new ApiResponse();
        try {
            List<Contact> contacts = repository.findAll();
            if (CollectionUtils.isEmpty(contacts)) {
                LOGGER.info("No contacts found");
                response.setBody("{}");
                response.setStatus(HttpStatus.NOT_FOUND);
            } else {
                LOGGER.info("Fetched {} contacts", CollectionUtils.size(contacts));
                response.setBody(contacts);
                response.setStatus(HttpStatus.OK);
            }
        } catch (Exception e) {
            return getExceptionApiResponse(e);
        }

        return response;
    }

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    public ApiResponse getById(String id) {
        ApiResponse response = new ApiResponse();

        try {
            Optional<Contact> contact = repository.findById(id);
            if (contact.isPresent()) {
                LOGGER.info("Contact found: ", contact.get());
                response.setBody(contact.get());
                response.setStatus(HttpStatus.OK);
            } else {
                LOGGER.info(ApiResponse.NO_CONTACT_FOUND);
                response.setBody("{}");
                response.setStatus(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return getExceptionApiResponse(e);
        }

        return response;
    }

    /**
     * Gets numbers for id.
     *
     * @param id the id
     * @return the numbers for id
     */
    public ApiResponse getNumbersForId(String id) {
        ApiResponse response = new ApiResponse();
        try {
            Optional<Contact> contact = repository.findById(id);

            if (contact.isPresent()) {
                List<ContactNumber> numbers = contact.get().getContactNumbers();

                if (CollectionUtils.isNotEmpty(numbers)) {
                    LOGGER.info(ApiResponse.N_CNUM_FOUND, numbers.size(), id);
                    response.setStatus(HttpStatus.FOUND);
                    response.setBody(numbers);
                } else {
                    LOGGER.info(ApiResponse.NO_CNUM_FOUND, id);
                    response.setStatus(HttpStatus.NOT_FOUND);
                    response.setBody("{}");
                }
            } else {
                LOGGER.info(ApiResponse.NO_CONTACT_FOUND);
                response.setBody("{}");
                response.setStatus(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response = getExceptionApiResponse(e);
        }

        return response;
    }

    /**
     * Gets emails for id.
     *
     * @param id the id
     * @return the emails for id
     */
    public ApiResponse getEmailsForId(String id) {
        ApiResponse response = new ApiResponse();
        try {
            Optional<Contact> contact = repository.findById(id);

            if (contact.isPresent()) {
                List<Email> emails = contact.get().getEmails();

                if (CollectionUtils.isNotEmpty(emails)) {
                    LOGGER.info("{} emails found for the id {}", emails.size(), id);
                    response.setStatus(HttpStatus.FOUND);
                    response.setBody(emails);
                } else {
                    LOGGER.info(ApiResponse.NO_EMAIL_FOUND, id);
                    response.setStatus(HttpStatus.NOT_FOUND);
                    response.setBody("{}");
                }
            } else {
                LOGGER.info(ApiResponse.NO_CONTACT_FOUND);
                response.setBody("{}");
                response.setStatus(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response = getExceptionApiResponse(e);
        }

        return response;
    }

    /**
     * Insert api response.
     *
     * @param contactDto the contact dto
     * @return the api response
     */
    public ApiResponse insert(ContactDTO contactDto) {
        ApiResponse response = new ApiResponse();

        try {
            Contact contact = new Contact(contactDto);
            contact.setCreatedOn(Utilities.currentDate());
            contact.setIsDeleted("N");

            if (CollectionUtils.isNotEmpty(contact.getContactNumbers())) {
                contact.getContactNumbers().forEach(i -> i.setCreatedOn(Utilities.currentDate()));
            }

            if (CollectionUtils.isNotEmpty(contact.getEmails())) {
                contact.getEmails().forEach(i -> i.setCreatedOn(Utilities.currentDate()));
            }

            repository.insert(contact);
            if (StringUtils.isBlank(contact.getId())) {
                String msg = "Unable to create the contact {}" + contact;
                LOGGER.info(msg);
                response.setBody(new ApplicationException(new Exception(msg)));
                response.setStatus(HttpStatus.NOT_ACCEPTABLE);
            } else {
                LOGGER.info("Added new contact {}", contact.getId());
                response.setBody(contact);
                response.setStatus(HttpStatus.CREATED);
            }
        } catch (Exception e) {
            return getExceptionApiResponse(e);
        }

        return response;
    }

    /**
     * Update api response.
     *
     * @param contactDto the contact dto
     * @return the api response
     */
    public ApiResponse update(ContactDTO contactDto) {
        ApiResponse response = new ApiResponse();

        try {
            Contact contact = new Contact(contactDto);
            contact.setUpdatedOn(Utilities.currentDate());

            Contact updatedContact = repository.save(contact);
            if (StringUtils.isBlank(updatedContact.getId())) {
                String msg = "Unable to update the contact {}" + contact;
                LOGGER.info(msg);
                response.setBody(new ApplicationException(new Exception(msg)));
                response.setStatus(HttpStatus.NOT_ACCEPTABLE);
            } else {
                LOGGER.info("Updated the contact {}", updatedContact.getId());
                response.setBody(updatedContact);
                response.setStatus(HttpStatus.OK);
            }
        } catch (Exception e) {
            return getExceptionApiResponse(e);
        }

        return response;
    }

    /**
     * Delete by id api response.
     *
     * @param id the id
     * @return the api response
     */
    public ApiResponse deleteById(String id) {
        ApiResponse response = new ApiResponse();

        try {
            Optional<Contact> promise = repository.findById(id);
            if (promise.isPresent()) {
                Contact contact = promise.get();
                contact.setIsDeleted("Y");
                contact.setUpdatedOn(Utilities.currentDate());

                repository.save(contact);

                LOGGER.info("Deleted the contact {}", contact);
                response.setBody(contact);
                response.setStatus(HttpStatus.OK);
            } else {
                LOGGER.info(ApiResponse.NO_CONTACT_FOUND);
                String json = "{\"id\":\"" + id + "\",\"deleted\":false}";
                response.setBody(new ObjectMapper().readValue(json, Object.class));
                response.setStatus(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return getExceptionApiResponse(e);
        }

        return response;
    }

    private ApiResponse getExceptionApiResponse(final Exception e) {
        LOGGER.error(e);

        ApiResponse response = new ApiResponse();
        response.setBody(new ApplicationException(e));
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);

        return response;
    }
}
