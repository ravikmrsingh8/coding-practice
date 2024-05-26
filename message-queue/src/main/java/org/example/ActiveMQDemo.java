package org.example;


public class App {
    public static void main( String[] args ) throws InterruptedException {
        Thread producer = new Thread(new HelloWorldProducer());
        producer.start();

        Thread consumer = new Thread(new HelloWorldConsumer());
        consumer.start();

        producer.join();
        consumer.join();

        Thread.sleep(10_000);

    }
}
