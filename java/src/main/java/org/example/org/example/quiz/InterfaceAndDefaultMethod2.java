package org.example.org.example.quiz;



interface Language {

    default void sayHello() {
        System.out.println("01101000 01100101 01101100 01101100 01101111 ");
    }
}

interface Marathi extends Language{}

interface Punjabi extends Language {}

class BiLingual implements Punjabi, Marathi {void converse() {sayHello();}}

public class InterfaceAndDefaultMethod2 {
    public static void main(String[] args) {
        BiLingual bilingual = new BiLingual();
        bilingual.converse();
    }
}

