package com.github.chandanv89.telephonedirectory.controller;

import com.github.chandanv89.telephonedirectory.controller.contract.IDirectory;
import com.github.chandanv89.telephonedirectory.controller.helper.DirectoryControllerHelper;
import com.github.chandanv89.telephonedirectory.model.ApiResponse;
import com.github.chandanv89.telephonedirectory.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type IDirectory controller.
 */
@RestController
@RequestMapping(
        path = "/contacts",
        produces = "application/json"
)
public class DirectoryController implements IDirectory {
    @Autowired
    private DirectoryControllerHelper helper;

    @GetMapping
    public ApiResponse getAllContacts() {
        return helper.getAllContacts();
    }

    @GetMapping(path = "{id}", produces = "application/json")
    public ApiResponse getContactById(@PathVariable String id) {
        return helper.getContactById(id);
    }

    @PostMapping(path = "add", produces = "application/json")
    public ApiResponse addContact(@RequestBody Contact contact) {
        return helper.addContact(contact);
    }

    @PostMapping(produces = "application/json")
    public ApiResponse addContacts(@RequestBody List<Contact> contacts) {
        return helper.addContacts(contacts);
    }

    @DeleteMapping(path = "{id}", produces = "application/json")
    public ApiResponse deleteContactById(@PathVariable String id) {
        return helper.deleteContactById(id);
    }

    @PutMapping(path = "{id}")
    public ApiResponse updateContactById(@PathVariable String id, @RequestBody Contact contact) {
        ApiResponse response = new ApiResponse();
        response.setStatus(HttpStatus.NOT_IMPLEMENTED);
        response.setBody("{}");

        return response;
    }
}
