package com.github.chandanv89.telephonedirectory.controller.helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.chandanv89.telephonedirectory.model.ApiResponse;
import com.github.chandanv89.telephonedirectory.model.ApplicationException;
import com.github.chandanv89.telephonedirectory.model.Contact;
import com.github.chandanv89.telephonedirectory.repository.ContactsRepository;
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
                LOGGER.info("No contact found by the given id");
                response.setBody("{}");
                response.setStatus(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return getExceptionApiResponse(e);
        }

        return response;
    }

    /**
     * Insert api response.
     *
     * @param contact the contact
     * @return the api response
     */
    public ApiResponse insert(Contact contact) {
        ApiResponse response = new ApiResponse();

        try {
            Contact newContact = repository.insert(contact);
            if (StringUtils.isBlank(newContact.getId())) {
                String msg = "Unable to create the contact {}" + contact;
                LOGGER.info(msg);
                response.setBody(new ApplicationException(new Exception(msg)));
                response.setStatus(HttpStatus.NOT_ACCEPTABLE);
            } else {
                LOGGER.info("Added new contact {}", newContact.getId());
                response.setBody(newContact);
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
     * @param contact the contact
     * @return the api response
     */
    public ApiResponse update(Contact contact) {
        ApiResponse response = new ApiResponse();

        try {
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
            if (repository.findById(id).isPresent()) {
                repository.deleteById(id);

                LOGGER.info("Deleted the contact {}", id);
                String json = "{\"id\":\"" + id + "\",\"deleted\":true}";
                response.setBody(new ObjectMapper().readValue(json, Object.class));
                response.setStatus(HttpStatus.OK);
            } else {
                LOGGER.info("No contact found by the id {}", id);
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
