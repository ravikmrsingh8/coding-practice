package org.example.threads.waitnotify;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer1 {
    public static void main(String[] args) {
        Queue<String> q = new LinkedList<>();
        Producer producer = new Producer(q);
        Consumer consumer = new Consumer(q);

        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);

        t2.start();
        t1.start();

    }
}
