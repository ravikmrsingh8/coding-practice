package org.example.threads.waitnotify;

import java.util.Queue;

public class Consumer implements Runnable {

    Queue<String> queue;

    public Consumer(Queue<String> q) {
        this.queue = q;
    }

    public void run() throws RuntimeException {
        while(true) {

            synchronized (queue) {
                while (queue.isEmpty()) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                while (!queue.isEmpty()) {
                    System.out.println("Got  " + queue.poll());
                }
                queue.notifyAll();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
