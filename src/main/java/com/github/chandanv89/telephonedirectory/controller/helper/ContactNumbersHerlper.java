package com.github.chandanv89.telephonedirectory.controller.helper;

import com.github.chandanv89.telephonedirectory.controller.contract.IContactNumbers;
import com.github.chandanv89.telephonedirectory.model.ApiResponse;
import com.github.chandanv89.telephonedirectory.model.ContactNumber;
import com.github.chandanv89.telephonedirectory.persistance.ContactNumbersDataService;
import com.github.chandanv89.telephonedirectory.utility.Guid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Contact numbers controller herlper.
 */
@Component
public class ContactNumbersHerlper implements IContactNumbers {
    private static final Logger LOGGER = LogManager.getLogger("ContactNumbersHerlper");

    @Autowired
    private ContactNumbersDataService service;

    @Override
    public ApiResponse getAllContactNumbers() {
        ApiResponse response = new ApiResponse();

        try {
            List<ContactNumber> contactNumbers = service.getAllContactNumbers();
            response.setBody(contactNumbers);
            response.setStatus(HttpStatus.OK);
            LOGGER.info(">>> Fetched all the ({}) contact numbers", contactNumbers.size());
        } catch (Exception e) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setBody(getExceptionMsg(e));
        }
        return response;
    }

    @Override
    public ApiResponse getContactNumberById(String id) {
        ApiResponse response = new ApiResponse();

        try {
            List<ContactNumber> contactNumbers = service.getContactNumbersByContactId(id);
            if (!CollectionUtils.isEmpty(contactNumbers)) {
                LOGGER.info(">>> Fetched contact number(s) for ID={}", id);
                response.setBody(contactNumbers);
                response.setStatus(HttpStatus.FOUND);
            } else {
                LOGGER.info(">>> No contact number for ID={}", id);
                response.setBody(new ArrayList<>());
                response.setStatus(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.setBody(e.getMessage());
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @Override
    public ApiResponse createContactNumbers(String parentContactId, List<ContactNumber> contactNumbers) {
        ApiResponse response = new ApiResponse();

        if (CollectionUtils.isEmpty(contactNumbers)) {
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setBody("Input list of contact numbers is empty!");

            LOGGER.error(response);

            return response;
        }

        if (StringUtils.isEmpty(parentContactId)) {
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setBody("Please specify the parent contact ID to add the contact numbers to!");

            LOGGER.error(response);

            return response;
        }

        try {
            contactNumbers.forEach(cn -> {
                cn.setId(Guid.generate());
                cn.setParentContactId(parentContactId);
            });
            int count = service.addContactNumbers(contactNumbers);
            response.setBody("Successfully updated [" + parentContactId + "] with " + count + " contact(s)");
            response.setStatus(HttpStatus.OK);
            LOGGER.info(">>> Fetched all the contact numbers");
        } catch (Exception e) {
            response = new ApiResponse();
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setBody(getExceptionMsg(e));
        }

        return response;
    }

    @Override
    public ApiResponse updateContactNumber(String id, ContactNumber contactNumber) {
        ApiResponse response = new ApiResponse();

        try {
            boolean status = service.updateContactNumber(contactNumber);
            String msg = status ? "Updated successfully" : "Update failed! Please check the logs.";
            LOGGER.info(msg);
            response.setBody(msg);
            response.setStatus(HttpStatus.OK);
        } catch (Exception e) {
            response = new ApiResponse();
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setBody(getExceptionMsg(e));
        }

        return response;
    }

    @Override
    public ApiResponse deleteContactNumber(String id) {
        ApiResponse response = new ApiResponse();

        try {
            response.setBody(service.deleteContactNumber(id)
                    ? "Deleted successfully" : "Delete failed! Please check the logs.");
            response.setStatus(HttpStatus.OK);
            LOGGER.info(response);
        } catch (Exception e) {
            response = new ApiResponse();
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setBody(getExceptionMsg(e));
        }
        return response;
    }

    @Override
    public ApiResponse deleteContactNumbersByContactId(String contactId) {
        ApiResponse response = new ApiResponse();

        try {
            response.setBody(service.deleteContactNumbersByContactId(contactId)
                    ? "Deleted successfully" : "Delete failed! Please check the logs.");
            response.setStatus(HttpStatus.OK);
            LOGGER.info(response);
        } catch (Exception e) {
            response = new ApiResponse();
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setBody(getExceptionMsg(e));
        }
        return response;
    }

    private String getExceptionMsg(final Exception e) {
        LOGGER.error(e);
        return "Please check logs for more details on the error: " + e.getCause().getMessage();
    }
}
