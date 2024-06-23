package org.example.collections;

import java.util.ArrayList;
import java.util.List;

public class BackedCollections02 {


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);list.add(2);list.add(3);

        System.out.println(list);

        List<Integer> list2 = new ArrayList<>(list);
        System.out.println(list2);

        list.removeLast();
        System.out.println(list);
        System.out.println(list2);
    }
}
