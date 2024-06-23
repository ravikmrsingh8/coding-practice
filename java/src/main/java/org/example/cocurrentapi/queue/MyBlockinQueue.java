package org.example.cocurrentapi.queue;

import java.util.LinkedList;

public class MyBlockinQueue {
    private LinkedList<Integer> list = new LinkedList<>();
    private final int capacity;
    private int length;
    public MyBlockinQueue(int capacity) {
        this.capacity = capacity;
        this.length = 0;
    }

    public synchronized void put(int val) throws InterruptedException {
        while(length >= capacity) {
            System.out.println("Put Waiting..");
            wait();
        }
        list.offerLast(val);
        length++;
        notifyAll();
    }

    public synchronized Integer take() throws InterruptedException {
        while(list.isEmpty()) {
            System.out.println("take waiting");
            wait();
        }
        int val = list.pollFirst();
        notifyAll();
        return val;
    }

    public synchronized int size() {
        return list.size();
    }

    public static void main(String[] args) throws InterruptedException {
        MyBlockinQueue queue = new MyBlockinQueue(5);
        Thread thread1 = new Thread(()-> {
            while(true) {
                try{
                    for(int i=0;i<10;i++) {
                        System.out.println("Putting :" + i);
                        queue.put(i);
                    }
                    Thread.sleep(1000);
                }catch(InterruptedException ex) {

                }

            }
        });


        Thread thread2 = new Thread(()-> {
            while(true) {
                try{
                    for(int i=0;i<10;i++) {
                        int val = queue.take();
                        System.out.println("Got " + val);
                        System.out.println("Queue Size" + queue.size());

                    }
                }catch(InterruptedException ex) {

                }

            }
        });
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();


    }
}
