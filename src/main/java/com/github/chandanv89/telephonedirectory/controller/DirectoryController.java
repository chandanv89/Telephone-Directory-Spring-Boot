package com.github.chandanv89.telephonedirectory.controller;

import com.github.chandanv89.telephonedirectory.model.ApiResponse;
import com.github.chandanv89.telephonedirectory.model.Contact;
import com.github.chandanv89.telephonedirectory.service.DirectoryService;
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
    @Autowired
    private DirectoryService directoryService;

    @GetMapping
    public ApiResponse getAllContacts() {
        ApiResponse response = new ApiResponse();

        try {
            response.setBody(directoryService.getAllContacts());
            response.setStatus(HttpStatus.OK);
        } catch (Exception e) {
            response.setStatus(HttpStatus.NOT_FOUND);
            response.setBody(new ArrayList<>());
        }

        return response;
    }

    @PostMapping(path = "add", produces = "application/json")
    public ApiResponse addContact(@RequestBody Contact contact) {
        ApiResponse response = new ApiResponse();

        try {
            directoryService.insertContact(contact);
            response.setBody("{\"id\":\"" + contact.getId() + "\"}");
            response.setStatus(HttpStatus.CREATED);
        } catch (Exception e) {
            response.setStatus(HttpStatus.NOT_FOUND);
            response.setBody(new ArrayList<>());
        }

        return response;
    }

    @GetMapping(path = "{id}", produces = "application/json")
    public ApiResponse getContactById(@PathVariable String id) {
        ApiResponse response = new ApiResponse();

        try {
            List<Contact> contact = directoryService.getContactById(id);
            response.setBody(contact);
            response.setStatus(contact.size() != 0 ? HttpStatus.FOUND : HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            response.setStatus(HttpStatus.NOT_FOUND);
            response.setBody(new ArrayList<>());
        }

        return response;
    }

    @DeleteMapping(path = "{id}", produces = "application/json")
    public ApiResponse deleteContactById(@PathVariable String id) {
        ApiResponse response = new ApiResponse();

        try {
            boolean statuss = directoryService.deleteById(id);
            response.setBody("{\"id\":\"" + id + "\",\"deleted\":" + statuss + "}");
            response.setStatus(statuss ? HttpStatus.OK : HttpStatus.NOT_FOUND);
        } catch (Exception e) {
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
