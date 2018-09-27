package com.github.chandanv89.telephonedirectory.utility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Test guid.
 */
class TestGuid {
    /**
     * Test guid generator.
     */
    @Test
    public void testGuidGenerator() {
        String guid = Guid.generate();

        // Guid.generate() should return a non-null ID
        assertNotNull(guid, "GUID is null!");

        // GUID must contain at a 5-component string as ID
        assertEquals(5, guid.split("-").length, "GUID should have at least 5 component strings!");

        // GUID is expected to be in lowercase
        assertFalse(guid.matches("/[A-Z]+/"));
    }
}