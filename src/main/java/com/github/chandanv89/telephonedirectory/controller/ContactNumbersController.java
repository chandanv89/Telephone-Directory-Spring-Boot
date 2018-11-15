package com.github.chandanv89.telephonedirectory.controller;

import com.github.chandanv89.telephonedirectory.controller.contract.IContactNumbers;
import com.github.chandanv89.telephonedirectory.controller.helper.ContactNumbersHerlper;
import com.github.chandanv89.telephonedirectory.model.ApiResponse;
import com.github.chandanv89.telephonedirectory.model.ContactNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Contact numbers controller.
 */
@RestController
@RequestMapping(path = "/contactnumbers", produces = {"application/json"})
public class ContactNumbersController implements IContactNumbers {
    @Autowired
    private ContactNumbersHerlper herlper;

    @RequestMapping
    public ApiResponse getAllContactNumbers() {
        return herlper.getAllContactNumbers();
    }

    @RequestMapping(path = "{id}")
    public ApiResponse getContactNumberById(@PathVariable String id) {
        return herlper.getContactNumberById(id);
    }

    @RequestMapping(method = RequestMethod.POST, path = "{parentContactId}")
    public ApiResponse createContactNumbers(@PathVariable String parentContactId, @RequestBody List<ContactNumber> contactNumbers) {
        return herlper.createContactNumbers(parentContactId, contactNumbers);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "{id}")
    public ApiResponse updateContactNumber(@PathVariable String id, @RequestBody ContactNumber contactNumber) {
        return herlper.updateContactNumber(id, contactNumber);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
    public ApiResponse deleteContactNumber(@PathVariable String id) {
        return herlper.deleteContactNumber(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "parent/{parentContactId}")
    public ApiResponse deleteContactNumbersByContactId(@PathVariable String parentContactId) {
        return herlper.deleteContactNumbersByContactId(parentContactId);
    }
}
