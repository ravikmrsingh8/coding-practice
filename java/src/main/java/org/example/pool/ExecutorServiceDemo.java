package org.example.pool;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceDemo {
    public static void main(String[] args)  {

        demo1();
        demo2();

        cachedThreadPoolDemo();
        singleThreadExecutorDemo();
        scheduledThreadPool();

    }

    static void scheduledThreadPool() {
        try(ScheduledExecutorService service = Executors.newScheduledThreadPool(5)) {
            service.schedule(()-> System.out.println("Job1 on scheduled Executor"), 5L, TimeUnit.SECONDS);
            service.schedule(()-> System.out.println("Job2 on scheduled Executor"), 6L, TimeUnit.SECONDS);
        }
    }


    static void cachedThreadPoolDemo() {
        try(ExecutorService service = Executors.newCachedThreadPool()) {
            service.submit(()->System.out.println("Job running on cached ThreadPool"));
            service.submit(()->System.out.println("Job running on cached ThreadPool"));
            service.submit(()->System.out.println("Job running on cached ThreadPool"));
        }
    }

    static void singleThreadExecutorDemo() {
        try(ExecutorService service = Executors.newSingleThreadExecutor()) {
            service.submit(()->System.out.println("Job running on Single Thread executor"));
            service.submit(()->System.out.println("Job running on Single Thread executor"));
            service.submit(()->System.out.println("Job running on Single Thread executor"));
        }
    }


    static void demo1() {
        try (ExecutorService service = Executors.newFixedThreadPool(5)) {
            service.submit(()-> System.out.println("Job1"));
            service.submit(()-> System.out.println("Job1"));
            service.submit(()-> System.out.println("Job1"));
            service.submit(()-> System.out.println("Job1"));
            service.submit(()-> System.out.println("Job1"));
            service.submit(()-> System.out.println("Job1"));
        }

        System.out.println("Terminated");
    }

    static void demo2() {
        ExecutorService service = Executors.newFixedThreadPool(5);
        service.submit(()-> System.out.println("Job1"));
        service.submit(()-> System.out.println("Job1"));
        service.submit(()-> System.out.println("Job1"));
        service.submit(()-> System.out.println("Job1"));
        service.submit(()-> System.out.println("Job1"));
        service.submit(()-> System.out.println("Job1"));
        shutDown(service);
    }
    static void shutDown(ExecutorService service) {
        service.shutdown();
        boolean isTerminated = false;
        try {
            isTerminated = service.awaitTermination(60L, TimeUnit.SECONDS);
        }catch (InterruptedException ex) {
            if(!isTerminated) {
                List<Runnable> remainingJobs = service.shutdownNow();
                System.out.println("Remaining Tasks");
            }
        }
    }
}
