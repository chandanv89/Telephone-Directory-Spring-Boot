package com.github.chandanv89.telephonedirectory.model;

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

    /**
     * From string contact category.
     *
     * @param category the category
     * @return the contact category
     */
    public ContactCategory fromString(String category) {
        switch (category.toUpperCase()) {
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
                return CUSTOM;
        }
    }
}
