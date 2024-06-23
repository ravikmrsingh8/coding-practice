package org.example.instancecheck.quiz;

import java.util.ArrayList;
import java.util.List;

public class ArrayAndListInstances {
    public static void main(String[] args) {
        Integer[] ints = new Integer[8];
        System.out.println(ints instanceof Number[]);

        //List<Integer> intList = new ArrayList<>();
        //System.out.println(intList instanceof List<Number>);

    }
}
