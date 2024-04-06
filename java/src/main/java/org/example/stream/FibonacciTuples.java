package org.example.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FibonacciTuples {

    List<Integer> generate(int N) {
        return Stream.iterate(new int[]{0, 1}, (a) -> new int[] {a[0] + a[1],  2 * a[1] + a[0]})
                .limit(N)
                .flatMapToInt(Arrays::stream)
                .boxed()
                .toList();

    }
}
