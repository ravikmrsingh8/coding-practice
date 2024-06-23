package org.example.basics;

import java.util.ArrayList;
import java.util.List;

public class PassByValue {
    public static void main(String[] args) {

        List<Integer> list = null;
        add(list, 8);
        System.out.println(list);
    }

    static void add(List<Integer> aList, int val) {
        aList = new ArrayList<>();
        aList.add(val);
    }
}
