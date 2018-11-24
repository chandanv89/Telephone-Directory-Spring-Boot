package com.github.chandanv89.telephonedirectory.controller;

import com.github.chandanv89.telephonedirectory.controller.contract.IEmails;
import com.github.chandanv89.telephonedirectory.controller.helper.EmailsHelper;
import com.github.chandanv89.telephonedirectory.model.ApiResponse;
import com.github.chandanv89.telephonedirectory.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/emails", produces = {"application/json"})
public class EmailsController implements IEmails {
    @Autowired
    private EmailsHelper helper;

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
        return null;
    }

    @Override
    @DeleteMapping(path = "{id}")
    public ApiResponse deleteEmail(String id) {
        return null;
    }

    @Override
    public ApiResponse deleteEmailsByContactId(String parentContactId) {
        return null;
    }
}
