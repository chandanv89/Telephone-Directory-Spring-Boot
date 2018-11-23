package com.github.chandanv89.telephonedirectory.controller.helper;

import com.github.chandanv89.telephonedirectory.controller.contract.IEmails;
import com.github.chandanv89.telephonedirectory.model.ApiResponse;
import com.github.chandanv89.telephonedirectory.model.Email;
import com.github.chandanv89.telephonedirectory.persistance.EmailDataService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmailsHelper implements IEmails {
    private static final Logger LOGGER = LogManager.getLogger(EmailsHelper.class);

    @Autowired
    private EmailDataService service;

    @Override
    public ApiResponse getAllEmails() {
        ApiResponse response = new ApiResponse();

        try {
            List<Email> emails = service.getAllEmails();
            response.setBody(emails);
            response.setStatus(HttpStatus.OK);
            LOGGER.info(">>> Fetched all the ({}) emails", CollectionUtils.size(emails));
        } catch (Exception e) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setBody(getExceptionMsg(e));
        }

        return response;
    }

    @Override
    public ApiResponse getEmailsById(String id) {
        ApiResponse response = new ApiResponse();

        try {
            List<Email> emails = service.getAllEmails();
            if (CollectionUtils.isNotEmpty(emails) &&
                    emails.stream().anyMatch(e -> StringUtils.equalsIgnoreCase(id, e.getId()))) {
                response.setBody(emails.stream().filter(e -> StringUtils.equalsIgnoreCase(id, e.getId()))
                        .collect(Collectors.toList()).get(0));
                response.setStatus(HttpStatus.FOUND);
            } else {
                response.setBody("[]");
                response.setStatus(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.setBody(getExceptionMsg(e));
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return response;
    }

    @Override
    public ApiResponse createEmails(String parentContactId, List<Email> emails) {
        return null;
    }

    @Override
    public ApiResponse updateEmail(String id, Email email) {
        return null;
    }

    @Override
    public ApiResponse deleteEmail(String id) {
        return null;
    }

    @Override
    public ApiResponse deleteEmailsByContactId(String parentContactId) {
        return null;
    }

    private String getExceptionMsg(final Exception e) {
        LOGGER.error(e);
        return "Please check logs for more details on the error: " + e.getCause().getMessage();
    }
}
