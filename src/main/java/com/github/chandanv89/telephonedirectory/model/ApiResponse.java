package com.github.chandanv89.telephonedirectory.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.chandanv89.telephonedirectory.utility.Utilities;
import org.springframework.http.HttpStatus;

/**
 * The type Api response.
 */
public class ApiResponse {
    /**
     * The constant NO_CONTACT_FOUND.
     */
    public static final String NO_CONTACT_FOUND = "No contact found by the given id";
    /**
     * The constant N_CNUM_FOUND.
     */
    public static final String N_CNUM_FOUND = "{} contact numbers found for the id {}";
    /**
     * The constant NO_CNUM_FOUND.
     */
    public static final String NO_CNUM_FOUND = "No contact numbers found for the id {}";
    /**
     * The constant NO_EMAIL_FOUND.
     */
    public static final String NO_EMAIL_FOUND = "No emails found for the id {}";

    @JsonProperty("status")
    private HttpStatus status;

    @JsonProperty("body")
    private Object body;

    /**
     * Instantiates a new Api response.
     */
    public ApiResponse() {
        // default
    }

    /**
     * Instantiates a new Api response.
     *
     * @param status the status
     * @param body   the body
     */
    public ApiResponse(HttpStatus status, Object body) {
        this.status = status;
        this.body = body;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public HttpStatus getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    /**
     * Gets body.
     *
     * @return the body
     */
    public Object getBody() {
        return body;
    }

    /**
     * Sets body.
     *
     * @param body the body
     */
    public void setBody(Object body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return Utilities.toString(this);
    }
}
