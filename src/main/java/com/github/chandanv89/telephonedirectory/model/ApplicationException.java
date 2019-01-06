package com.github.chandanv89.telephonedirectory.model;

import com.github.chandanv89.telephonedirectory.utility.Utilities;

/**
 * The type Application exception.
 */
public class ApplicationException {
    private String exceptionMessage;
    private String exceptionType;

    /**
     * Instantiates a new Application exception.
     */
    public ApplicationException() {
        // default
    }

    /**
     * Instantiates a new Application exception.
     *
     * @param exceptionObject the exception object
     */
    public ApplicationException(Exception exceptionObject) {
        this.exceptionMessage = exceptionObject.getMessage();
        this.exceptionType = exceptionObject.getClass().getSimpleName();
    }

    /**
     * Gets exception message.
     *
     * @return the exception message
     */
    public String getExceptionMessage() {
        return exceptionMessage;
    }

    /**
     * Sets exception message.
     *
     * @param exceptionMessage the exception message
     */
    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    /**
     * Gets exception type.
     *
     * @return the exception type
     */
    public String getExceptionType() {
        return exceptionType;
    }

    /**
     * Sets exception type.
     *
     * @param exceptionType the exception type
     */
    public void setExceptionType(String exceptionType) {
        this.exceptionType = exceptionType;
    }

    @Override
    public String toString() {
        return Utilities.toString(this);
    }
}
