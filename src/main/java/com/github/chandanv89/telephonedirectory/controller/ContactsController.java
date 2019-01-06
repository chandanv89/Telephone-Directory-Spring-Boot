package com.github.chandanv89.telephonedirectory.controller;

import com.github.chandanv89.telephonedirectory.controller.helper.ContactsControllerHelper;
import com.github.chandanv89.telephonedirectory.model.ApiResponse;
import com.github.chandanv89.telephonedirectory.model.dto.ContactDTO;
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
     * Gets numbers for id.
     *
     * @param id the id
     * @return the numbers for id
     */
    @GetMapping("/{id}/numbers")
    public ApiResponse getNumbersForId(@PathVariable("id") String id) {
        return helper.getNumbersForId(id);
    }

    /**
     * Gets emails for id.
     *
     * @param id the id
     * @return the emails for id
     */
    @GetMapping("/{id}/emails")
    public ApiResponse getEmailsForId(@PathVariable("id") String id) {
        return helper.getEmailsForId(id);
    }

    /**
     * Insert.
     *
     * @param contactDto the contact dto
     * @return the api response
     */
    @PostMapping("/")
    public ApiResponse insert(@RequestBody ContactDTO contactDto) {
        return helper.insert(contactDto);
    }

    /**
     * Update.
     *
     * @param contactdto the contactdto
     * @return the api response
     */
    @PutMapping
    public ApiResponse update(@RequestBody ContactDTO contactdto) {
        return helper.update(contactdto);
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
