package com.github.chandanv89.telephonedirectory.controller;

import com.github.chandanv89.telephonedirectory.controller.contract.IEmails;
import com.github.chandanv89.telephonedirectory.controller.helper.EmailsHelper;
import com.github.chandanv89.telephonedirectory.model.ApiResponse;
import com.github.chandanv89.telephonedirectory.model.Email;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Emails controller.
 */
@Api(value = "Access and manipulate Emails",
        produces = "application/json",
        consumes = "application/json",
        tags = {"directory", "telephone-directory"})
@RestController
@RequestMapping(path = "/emails", produces = {"application/json"})
public class EmailsController implements IEmails {
    @Autowired
    private EmailsHelper helper;

    @ApiOperation(value = "/getAllEmails",
            produces = "application/json",
            response = ApiResponse.class,
            httpMethod = "GET")
    @Override
    @RequestMapping
    public ApiResponse getAllEmails() {
        return helper.getAllEmails();
    }

    @Override
    @GetMapping(path = "{id}")
    public ApiResponse getEmailsById(@PathVariable String id) {
        return helper.getEmailsById(id);
    }

    @Override
    @PostMapping(path = "{parentContactId}")
    public ApiResponse createEmails(@PathVariable String parentContactId, @RequestBody List<Email> emails) {
        return helper.createEmails(parentContactId, emails);
    }

    @Override
    @PutMapping(path = "{id}")
    public ApiResponse updateEmail(@PathVariable String id, @RequestBody Email email) {
        return helper.updateEmail(id, email);
    }

    @Override
    @DeleteMapping(path = "{id}")
    public ApiResponse deleteEmail(String id) {
        return helper.deleteEmail(id);
    }

    @Override
    public ApiResponse deleteEmailsByContactId(String parentContactId) {
        return helper.deleteEmailsByContactId(parentContactId);
    }
}
