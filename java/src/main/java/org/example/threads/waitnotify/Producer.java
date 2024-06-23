package org.example.threads.waitnotify;

import java.util.Queue;

public class Producer implements Runnable {
    Queue<String> queue;

    public Producer(Queue<String> q) {
        this.queue = q;
    }

    public void run() throws RuntimeException {

        while(true) {
            synchronized (this.queue) {
                if(queue.isEmpty()) {
                    queue.offer("Message :" + Math.round(Math.random()*10));
                    queue.notifyAll();
                }

                while(!queue.isEmpty()) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
