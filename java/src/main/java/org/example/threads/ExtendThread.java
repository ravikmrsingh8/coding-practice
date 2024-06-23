package org.example.threads;

public class ExtendThread {
    public static void main(String[] args) throws Exception {
        MyThread thread = new MyThread();
        thread.start();
        thread.join();
        System.out.println("Main Exited");
    }
}

class MyThread extends Thread {
    public void run() {
        System.out.println("My Thread Running!");
        try {
            Thread.sleep(1000);
        } catch(Exception ex){
            ex.printStackTrace();
        }

    }
}
