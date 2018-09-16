package com.github.chandanv89.telephonedirectory.model;

import org.junit.jupiter.api.Test;
import pl.pojo.tester.api.assertion.Method;

import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;

class TestEmail {
    @Test
    public void pojoTester() {
        assertPojoMethodsFor(Email.class)
                .testing(Method.GETTER, Method.SETTER, Method.TO_STRING)
                .testing(Method.EQUALS)
                .testing(Method.CONSTRUCTOR)
                .areWellImplemented();
    }
}