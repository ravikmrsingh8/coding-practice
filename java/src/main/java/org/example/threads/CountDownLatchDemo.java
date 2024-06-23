package org.example.threads;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws Exception {
        CountDownLatch latch = new CountDownLatch(2);
        Thread t1= new Thread(new Job(latch));
        Thread t2 = new Thread(new Job(latch));
        t1.start();
        t2.start();

        System.out.println("Waiting for Countdownlatch");
        latch.await();

        System.out.println("Main resumed");

;    }

    static class Job implements Runnable {
        CountDownLatch latch;
        public Job(CountDownLatch latch) {
            this.latch = latch;
        }

        public void run() {
            System.out.println("Job running");
            try{Thread.sleep(1000);}catch (Exception ignored){}
            latch.countDown();
        }
    }
}


