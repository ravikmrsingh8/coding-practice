package org.example.basics;

public class MethodOverloading {
    public static void main(String[] args) {
        myOverloadedMethod(5);
        myOverloadedMethod(5L);

    }

    static void myOverloadedMethod(long arg) {
        System.out.println("Method with long invoked");
    }

    static void myOverloadedMethod(int arg) {
        System.out.println("Method with int invoked");
    }

    static void mymyOverloadedMethod(int... arg) {
        System.out.println("Method with vararg invoked");
    }
}
