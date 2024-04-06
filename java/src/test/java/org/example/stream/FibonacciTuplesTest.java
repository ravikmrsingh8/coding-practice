package org.example.stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


class FibonacciTuplesTest {

    @Test
    @DisplayName("Should generate first 10 fibonacci numbers")
    public void generateFibonacciTest1() {
        FibonacciTuples tuples = new FibonacciTuples();
        List<Integer> actual = tuples.generate(5);
        List<Integer> expected = Arrays.asList(0,1,1,2,3,5,8,13,21,34);
        Assertions.assertIterableEquals(expected, actual);
    }

}