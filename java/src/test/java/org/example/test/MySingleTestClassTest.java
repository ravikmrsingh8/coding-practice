package org.example.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MySingleTestClassTest {
    private int num1;
    private int num2;

    @BeforeAll
    static void setupBeforeAll() {
        System.out.println("Before All");
    }

    @AfterAll
    static void setupAfterAll() {
        System.out.println("After All");
    }


    @BeforeEach
    void setupBeforeEach() {
        num1 = 10;
        num2 = 20;

        System.out.println("Setup before Each");
    }


    @AfterEach
    void setupAfterEach() {
        num1 = 0;
        num2 = 0;
        System.out.println("After Each");
    }

    @Test
    void testAddTwo() {
        System.out.println("test Add Two");
        Assertions.assertEquals(30, num1 + num2);
    }


    @Test
    void testAnotherMethod() {
        System.out.println("Test Another method");
    }
}
