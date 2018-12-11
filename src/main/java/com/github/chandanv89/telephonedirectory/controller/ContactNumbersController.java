package com.github.chandanv89.telephonedirectory.controller;

import com.github.chandanv89.telephonedirectory.controller.contract.IContactNumbers;
import com.github.chandanv89.telephonedirectory.controller.helper.ContactNumbersHerlper;
import com.github.chandanv89.telephonedirectory.model.ApiResponse;
import com.github.chandanv89.telephonedirectory.model.ContactNumber;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Contact numbers controller.
 */
@Api(value = "Access and manipulate ContactNumbers",
        produces = "application/json",
        consumes = "application/json",
        tags = {"directory", "telephone-directory"})
@RestController
@RequestMapping(path = "/contactnumbers", produces = {"application/json"})
public class ContactNumbersController implements IContactNumbers {
    @Autowired
    private ContactNumbersHerlper herlper;

    @ApiOperation(value = "/contactnumbers",
            notes = "Fetch all the ContactNumbers in the directory.",
            httpMethod = "GET",
            response = ApiResponse.class,
            consumes = "application/json",
            produces = "application/json"
    )
    @RequestMapping
    public ApiResponse getAllContactNumbers() {
        return herlper.getAllContactNumbers();
    }

    @ApiOperation(value = "/contactnumbers/{CONTACT_NUMBER_ID}",
            notes = "Fetch the ContactNumber for a given ID.",
            httpMethod = "GET",
            response = ApiResponse.class,
            consumes = "application/json",
            produces = "application/json"
    )
    @RequestMapping(path = "{id}")
    public ApiResponse getContactNumberById(@PathVariable String id) {
        return herlper.getContactNumberById(id);
    }

    @ApiOperation(value = "/contactnumbers/{PARENT_CONTACT_ID}",
            notes = "For a given PARENT_CONTACT_ID, insert a list of ContactNumbers. ContactNumber can be mobile, work phone or a home phone number.",
            httpMethod = "POST",
            response = ApiResponse.class,
            consumes = "application/json",
            produces = "application/json"
    )
    @PostMapping(path = "{parentContactId}")
    public ApiResponse createContactNumbers(@PathVariable String parentContactId, @RequestBody List<ContactNumber> contactNumbers) {
        return herlper.createContactNumbers(parentContactId, contactNumbers);
    }

    @ApiOperation(value = "/contactnumbers/{CONTACT_NUMBER_ID}",
            notes = "Update the ContactNumber details for a given CONTACT_NUMBER_ID",
            httpMethod = "PUT",
            response = ApiResponse.class,
            consumes = "application/json",
            produces = "application/json"
    )
    @PutMapping(path = "{id}")
    public ApiResponse updateContactNumber(@PathVariable String id, @RequestBody ContactNumber contactNumber) {
        return herlper.updateContactNumber(id, contactNumber);
    }

    @ApiOperation(value = "/contactnumbers/{CONTACT_NUMBER_ID}",
            notes = "Delete the contact number for the given contact number id.",
            httpMethod = "DELETE",
            response = ApiResponse.class,
            consumes = "application/json",
            produces = "application/json"
    )
    @DeleteMapping(path = "{id}")
    public ApiResponse deleteContactNumber(@PathVariable String id) {
        return herlper.deleteContactNumber(id);
    }

    @ApiOperation(value = "/contactnumbers/{PARENT_CONTACT_ID}",
            notes = "Delete all the contact numbers for a given parent contact id.",
            httpMethod = "DELETE",
            response = ApiResponse.class,
            consumes = "application/json",
            produces = "application/json"
    )
    @DeleteMapping(path = "parent/{parentContactId}")
    public ApiResponse deleteContactNumbersByContactId(@PathVariable String parentContactId) {
        return herlper.deleteContactNumbersByContactId(parentContactId);
    }
}
