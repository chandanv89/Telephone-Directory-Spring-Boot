package com.github.chandanv89.telephonedirectory.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

/**
 * The enum Contact category.
 */
public enum ContactCategory {
    /**
     * Work contact category.
     */
    WORK,
    /**
     * Home contact category.
     */
    HOME,
    /**
     * Personal contact category.
     */
    PERSONAL,
    /**
     * Mobile contact category.
     */
    MOBILE,
    /**
     * Others contact category.
     */
    OTHERS,
    /**
     * Custom contact category.
     */
    CUSTOM;

    private static final Logger LOGGER = LogManager.getLogger(ContactCategory.class);

    /**
     * Get ContactCategory for a given string.
     *
     * @param category the category
     * @return the contact category
     */
    public static ContactCategory fromString(String category) {
        switch (category.trim().toUpperCase()) {
            case "PERSONAL":
                return PERSONAL;
            case "WORK":
                return WORK;
            case "HOME":
                return HOME;
            case "MOBILE":
                return MOBILE;
            case "OTHERS":
                return OTHERS;
            default:
                LOGGER.info(">>> ContactCategory -> {}", CUSTOM);
                LOGGER.info(">>> Available Options: " +
                        Arrays.toString(ContactCategory.values()));
                return CUSTOM;
        }
    }
}
