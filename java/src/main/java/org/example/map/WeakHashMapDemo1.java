package org.example.map;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapDemo1 {
    public static void main(String[] args) throws  Exception{
        Map<Integer, String> map = new WeakHashMap<>();
        Integer i1 = 1001;Integer i2 = 1002;Integer i3 = 1003;Integer i4 = 1004;
        map.put(i1, "1001"); map.put(i2, "1002");map.put(i3, "1003");map.put(i4, "1004");
        System.out.println(map);

        i1= null;
        i2= null;
        i3= null;

        System.gc();
        System.gc();
        Runtime.getRuntime().gc();
        Runtime.getRuntime().gc();

        Thread.sleep(3000);

        System.out.println(map);
    }
}
