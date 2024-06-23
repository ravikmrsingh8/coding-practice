package org.example.generics.quiz;

import java.util.List;

public class ErasureGotcha {
    public static void main(String[] args) {
        //play(List.of("Soap"));
        play(List.of(1));
    }

    //Throws Error
    //clash: play(List) and play(List) have the same erasure
    //public static void play(List<String> strings) {
    //    System.out.println(strings);
    //}
    public static void play(List<Integer> ints) {
        System.out.println(ints);
    }
}
