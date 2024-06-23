package org.example.threads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchronizedCollectionsDemo1 {
    public static void main(String[] args) throws Exception {

        List<Integer> ints = Collections.synchronizedList(new ArrayList<>());
        Thread t1 = new Thread(() -> {
            for(int i=0; i<10_000; i++) {
                ints.add(i);
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i=0; i<10_000; i++) {
                ints.add(i);
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("List Size:" + ints.size());
    }
}
