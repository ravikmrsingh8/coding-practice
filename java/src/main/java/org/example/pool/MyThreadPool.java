package org.example.pool;

import java.util.LinkedList;
import java.util.Queue;
import java.util.UUID;

public class MyThreadPool {
    final int NUM_WORKERS;
    PoolWorker[] workers;
    final Queue<Runnable> taskQueue = new LinkedList<>();


    public MyThreadPool(int capacity) {
        this.NUM_WORKERS = capacity;
        workers = new PoolWorker[capacity];
        for(int i=0; i<capacity; i++) {
            workers[i] = new PoolWorker();
            workers[i].start();
        }
    }

    public void submit(Runnable task) {
        synchronized (taskQueue) {
            taskQueue.offer(task);
            taskQueue.notifyAll();
        }
    }

    public void stop() {
        for(PoolWorker worker : workers) {
            worker.interrupt();
        }
        System.out.println("Task Queue Size: " + taskQueue.size());
    }
    class PoolWorker extends  Thread {
        public void run() {
            while(true) {
                synchronized(taskQueue) {
                    while (taskQueue.isEmpty()) {
                        try {
                            taskQueue.wait();
                        } catch (InterruptedException e) {
                            //throw new RuntimeException(e);
                            break;
                        }
                    }
                    System.out.println("Thread: " + Thread.currentThread().getName());
                    Runnable task = taskQueue.poll();
                    task.run();
                    if(Thread.currentThread().isInterrupted()) break;

                }
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        MyThreadPool pool = new MyThreadPool(5);
        for(int i=0;i<1_000;i++) {
            pool.submit(()-> {
                System.out.println("Job Running,ID:" + UUID.randomUUID().toString());
            });
        }
        pool.stop();
    }
}
