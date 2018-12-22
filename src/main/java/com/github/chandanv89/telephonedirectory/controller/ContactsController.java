package com.github.chandanv89.telephonedirectory.controller;

import com.github.chandanv89.telephonedirectory.controller.helper.ContactsControllerHelper;
import com.github.chandanv89.telephonedirectory.model.ApiResponse;
import com.github.chandanv89.telephonedirectory.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * The type Contacts controller.
 */
@RestController
@RequestMapping("/rest/contacts/")
public class ContactsController {

    @Autowired
    private ContactsControllerHelper helper;

    /**
     * Gets all.
     *
     * @return the all
     */
    @GetMapping("/")
    public ApiResponse getAll() {
        return helper.getAll();
    }

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    @GetMapping("/{id}")
    public ApiResponse getById(@PathVariable("id") String id) {
        return helper.getById(id);
    }

    /**
     * Insert.
     *
     * @param contact the contact
     * @return the api response
     */
    @PostMapping("/")
    public ApiResponse insert(@RequestBody Contact contact) {
        return helper.insert(contact);
    }

    /**
     * Update.
     *
     * @param contact the contact
     * @return the api response
     */
    @PutMapping
    public ApiResponse update(@RequestBody Contact contact) {
        return helper.update(contact);
    }

    /**
     * Delete.
     *
     * @param id the id
     * @return the api response
     */
    @DeleteMapping("/{id}")
    public ApiResponse delete(@PathVariable("id") String id) {
        return helper.deleteById(id);
    }
}
