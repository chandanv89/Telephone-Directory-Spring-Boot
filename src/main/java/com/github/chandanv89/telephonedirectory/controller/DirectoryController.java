package com.github.chandanv89.telephonedirectory.controller;

import com.github.chandanv89.telephonedirectory.model.ApiResponse;
import com.github.chandanv89.telephonedirectory.model.Contact;
import com.github.chandanv89.telephonedirectory.persistance.ContactsDataService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * The type Directory controller.
 */
@RestController
@RequestMapping(
        path = "/contacts",
        produces = "application/json"
)
public class DirectoryController implements Directory {
    private static final Logger LOGGER = LogManager.getLogger("DirectoryController");

    @Autowired
    private ContactsDataService contactsDataService;

    @GetMapping
    public ApiResponse getAllContacts() {
        ApiResponse response = new ApiResponse();

        try {
            LOGGER.info(">>> Fetching all the contacts...");
            response.setBody(contactsDataService.getAllContacts());
            response.setStatus(HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error(e);
            response.setStatus(HttpStatus.NOT_FOUND);
            response.setBody(new ArrayList<>());
        }

        return response;
    }

    @PostMapping(path = "add", produces = "application/json")
    public ApiResponse addContact(@RequestBody Contact contact) {
        ApiResponse response = new ApiResponse();

        try {
            LOGGER.info(">>> Adding new contact: ", contact);
            response.setBody("{\"id\":\"" + contactsDataService.addContact(contact) + "\"}");
            response.setStatus(HttpStatus.CREATED);
            LOGGER.info(">>> Added new contact {}", contact.getId());
        } catch (Exception e) {
            LOGGER.error(e);
            response.setStatus(HttpStatus.NOT_FOUND);
            response.setBody(new ArrayList<>());
        }

        return response;
    }

    @GetMapping(path = "{id}", produces = "application/json")
    public ApiResponse getContactById(@PathVariable String id) {
        ApiResponse response = new ApiResponse();

        try {
            LOGGER.info(">>> Fetching contact for id={}", id);
            Contact contact = contactsDataService.getContactById(id);
            response.setBody(contact);
            response.setStatus(!ObjectUtils.isEmpty(contact) ? HttpStatus.FOUND : HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            LOGGER.error(e);
            response.setStatus(HttpStatus.NOT_FOUND);
            response.setBody(new ArrayList<>());
        }

        return response;
    }

    @DeleteMapping(path = "{id}", produces = "application/json")
    public ApiResponse deleteContactById(@PathVariable String id) {
        ApiResponse response = new ApiResponse();

        try {
            String status = contactsDataService.deleteContactById(id);
            response.setBody("{\"id\":\"" + id + "\",\"deleted\":" + status + "}");
            response.setStatus(!StringUtils.isEmpty(status) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            LOGGER.error(e);
            response.setStatus(HttpStatus.NOT_FOUND);
            response.setBody(new ArrayList<>());
        }

        return response;
    }

    @PutMapping(path = "{id}")
    public ApiResponse updateContactById(@PathVariable String id, @RequestBody Contact contact) {
        ApiResponse response = new ApiResponse();
        response.setStatus(HttpStatus.NOT_IMPLEMENTED);
        response.setBody("{}");

        return response;
    }
}
