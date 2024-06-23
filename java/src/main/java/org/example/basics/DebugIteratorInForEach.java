package org.example.basics;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DebugIteratorInForEach {
    public static void main(String[] args) {
        List<String> names = List.of("Bablu", "Dablu", "Gablu");
        for(String name: names) {
            System.out.println(name);
        }
    }
}
