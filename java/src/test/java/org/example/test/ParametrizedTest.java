package org.example.test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParametrizedTest {

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    void testSquare(int value) {
        int result = square(value);
        assertEquals(value * value, result);
    }

    private int square(int num) {
        return num *  num;
    }
}
