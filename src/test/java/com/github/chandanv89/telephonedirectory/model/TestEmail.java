package com.github.chandanv89.telephonedirectory.model;

import org.junit.jupiter.api.Test;
import pl.pojo.tester.api.assertion.Method;

import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;

/**
 * The type Test email.
 */
class TestEmail {
    /**
     * Pojo tester.
     */
    @Test
    public void pojoTester() {
        assertPojoMethodsFor(Email.class)
                .testing(Method.GETTER, Method.SETTER, Method.TO_STRING)
                .testing(Method.EQUALS)
                .testing(Method.CONSTRUCTOR)
                .areWellImplemented();
    }
}