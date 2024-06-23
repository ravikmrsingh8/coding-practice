package org.example.iterators;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FailsafeDemo2 {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new ConcurrentHashMap<>();
        map.put(1, 1);
        map.put(2, 1);
        map.put(3, 1);

        Iterator<Integer> itr1 = map.keySet().iterator();

        while(itr1.hasNext()) {
            System.out.println(itr1.next());
            map.put(2,3);
        }

        System.out.println(map);

    }
}
