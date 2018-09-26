package com.github.chandanv89.telephonedirectory.utility;

import java.util.UUID;

/**
 * The type Guid.
 */
public class Guid {
    /**
     * Generate a UUID string.
     *
     * @return the string
     */
    public static String generate() {
        return UUID.randomUUID().toString().toLowerCase();
    }
}
