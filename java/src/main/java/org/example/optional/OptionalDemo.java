package org.example.optional;

import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        Optional<Integer> optional = Optional.of(1);
        System.out.println(optional);
        optional.ifPresent((num)-> System.out.println(num));
    }
}
