package com.github.chandanv89.telephonedirectory.controller;

import com.github.chandanv89.telephonedirectory.controller.helper.DirectoryControllerHelper;
import com.github.chandanv89.telephonedirectory.model.ApiResponse;
import com.github.chandanv89.telephonedirectory.model.Contact;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
    private DirectoryControllerHelper helper;

    @GetMapping
    public ApiResponse getAllContacts() {
        ApiResponse response = new ApiResponse();

        LOGGER.info(">>> Fetching all the contacts...");

        try {
            response = helper.getAllContacts();
            LOGGER.info("Done. ");
        } catch (Exception e) {
            LOGGER.error(e);
            response.setStatus(HttpStatus.NOT_FOUND);
            response.setBody(new ArrayList<>());
            LOGGER.info("FAILED!", response);
        }

        return response;
    }

    @GetMapping(path = "{id}", produces = "application/json")
    public ApiResponse getContactById(@PathVariable String id) {
        ApiResponse response = new ApiResponse();

        LOGGER.info(">>> Fetching contact for id={}", id);

        try {
            response = helper.getContactById(id);
            LOGGER.info("Done. ", response);
        } catch (Exception e) {
            LOGGER.error(e);
            response.setStatus(HttpStatus.NOT_FOUND);
            response.setBody(null);
            LOGGER.info("FAILED!", response);
        }

        return response;
    }

    @PostMapping(path = "add", produces = "application/json")
    public ApiResponse addContact(@RequestBody Contact contact) {
        ApiResponse response = new ApiResponse();

        try {
            LOGGER.info(">>> Adding new contact: ", contact);
            response = helper.addContact(contact);
        } catch (Exception e) {
            LOGGER.error(e);
            response.setStatus(HttpStatus.NOT_FOUND);
            response.setBody(new ArrayList<>());
        }

        return response;
    }

    @PostMapping(produces = "application/json")
    public ApiResponse addContacts(@RequestBody List<Contact> contacts) {
        ApiResponse response = new ApiResponse();

        try {
            LOGGER.info(">>> Adding new contacts: ", contacts);
            response = helper.addContacts(contacts);
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
            response = helper.deleteContactById(id);
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
