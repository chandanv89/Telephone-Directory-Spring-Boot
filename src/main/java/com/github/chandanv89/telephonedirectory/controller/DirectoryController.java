package com.github.chandanv89.telephonedirectory.controller;

import com.github.chandanv89.telephonedirectory.controller.contract.IDirectory;
import com.github.chandanv89.telephonedirectory.controller.helper.DirectoryControllerHelper;
import com.github.chandanv89.telephonedirectory.model.ApiResponse;
import com.github.chandanv89.telephonedirectory.model.Contact;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type IDirectory controller.
 */
@Api(value = "The directory API",
        produces = "application/json",
        consumes = "application/json",
        tags = {"directory", "telephone-directory"})
@RestController
@RequestMapping(
        path = "/contacts",
        produces = "application/json"
)
public class DirectoryController implements IDirectory {
    @Autowired
    private DirectoryControllerHelper helper;

    @ApiOperation(value = "/contacts",
            response = ApiResponse.class,
            produces = "application/jason",
            httpMethod = "GET",
            notes = "fetch all the contacts from the directory.")
    @GetMapping(path = "/", produces = "application/json", name = "getAllContacts")
    public ApiResponse getAllContacts() {
        return helper.getAllContacts();
    }

    @ApiOperation(value = "/contacts/{CONTACT_ID}",
            response = ApiResponse.class,
            produces = "application/jason",
            httpMethod = "GET",
            notes = "fetch a contact for the given CONTACT_ID.")
    @GetMapping(path = "{id}", produces = "application/json")
    public ApiResponse getContactById(@PathVariable String id) {
        return helper.getContactById(id);
    }

    @ApiOperation(value = "/contacts/add",
            response = ApiResponse.class,
            consumes = "Contact.class; application/jason",
            produces = "application/jason",
            httpMethod = "POST",
            notes = "Create a new contact in the directory.")
    @PostMapping(path = "add", produces = "application/json")
    public ApiResponse addContact(@RequestBody Contact contact) {
        return helper.addContact(contact);
    }

    @ApiOperation(value = "/contacts/add",
            response = ApiResponse.class,
            produces = "List<Contact>; application/jason",
            httpMethod = "POST",
            notes = "Create multiple contacts in the directory.")
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
