package org.example.map;

import java.util.HashMap;
import java.util.IdentityHashMap;

public class IdentityMapDemo {
    public static void main(String[] args) {
        IdentityHashMap<String, Integer> map = new IdentityHashMap<>();
        String key1= new String("Key1");
        String key2= new String("Key2");

        map.put(key1, 1);
        map.put(key2, 2);

        System.out.println(map);

        System.out.println(map.containsKey("Key1"));
        System.out.println(map.containsKey(key1));
    }
}
