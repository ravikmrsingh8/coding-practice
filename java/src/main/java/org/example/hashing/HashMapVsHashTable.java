package org.example.hashing;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapVsHashTable {
    public static void main(String[] args) {
        System.out.println("Hello World");
        Map<String, String> map = new HashMap<>();
        map.put(null, null);
        System.out.println(map.get(null));

        Hashtable<String, String> hash = new Hashtable<>();
        //hash.put("A", null);   //NullPointer
        //hash.put(null, "null"); //NullPointer


        ConcurrentHashMap<String, String> conMap = new ConcurrentHashMap<>();
        //conMap.putIfAbsent("null", null); //Null pointer
        //conMap.putIfAbsent(null, "null"); //Null Pointer
        conMap.put("One", "1");
    }
}
