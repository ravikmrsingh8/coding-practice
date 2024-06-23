package org.example.list;

import java.util.ArrayList;
import java.util.List;

public class RemoveOnList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(20);
        list.add(50);
        list.add(-1);

        //list.remove(-1); throws index out of bound exception
        list.remove(Integer.valueOf(-1));

        System.out.println(list);
    }
}
