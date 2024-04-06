package org.example.stream;

import java.util.List;
import java.util.stream.IntStream;

public class PythagoreanTriples {
    public record Triple(int a, int b, int c){}

    public  List<Triple> generateTriples(int N) {
        return IntStream.rangeClosed(1, 100)
                .boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 100)
                        .mapToObj(b -> new double[]{a, b, Math.sqrt(a*a + b*b)})
                        .filter(triple -> triple[2] % 1.0 == 0))
                .map(triple -> new Triple((int)triple[0], (int)triple[1], (int)triple[2]))
                .limit(N)
                .toList();
    }
}
