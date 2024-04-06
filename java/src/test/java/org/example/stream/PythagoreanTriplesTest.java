package org.example.stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


class PythagoreanTriplesTest {
    @Test
    @DisplayName("Should generate Pythagorean triples")
    public void generatePythagoreanTriples(){
        PythagoreanTriples generator = new PythagoreanTriples();
        List<PythagoreanTriples.Triple> triples = generator.generateTriples(5);

        List<PythagoreanTriples.Triple> expected = List.of(
                new PythagoreanTriples.Triple(3, 4, 5),
                new PythagoreanTriples.Triple(5, 12, 13),
                new PythagoreanTriples.Triple(6, 8, 10),
                new PythagoreanTriples.Triple(7, 24, 25),
                new PythagoreanTriples.Triple(8, 15, 17)
        );

        Assertions.assertIterableEquals(expected, triples);

    }

}