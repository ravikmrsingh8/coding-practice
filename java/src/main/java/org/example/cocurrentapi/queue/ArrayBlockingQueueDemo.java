package org.example.cocurrentapi.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ArrayBlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<Integer> q = new ArrayBlockingQueue<>(10, true);

        //Producer
        Thread t1 = new Thread(()->{
            for(int i=0; i < 10_000; i++) {
                try {
                    q.put(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();

        //Consumer
        Thread t2 = new Thread(()->{
            for(int i=0; i < 10_000; i++) {
                try {
                    int num = q.take();
                    System.out.println(num);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t2.start();

        t1.join();
        t2.join();
        System.out.println(q);
    }
}
