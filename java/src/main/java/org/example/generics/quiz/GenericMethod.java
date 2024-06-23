package org.example.generics.quiz;


public class GenericMethod {
    public static void main(String[] args) {
        Printer printer = new Printer();
        printer.print(5);
        printer.print("Ram");
        printer.<Double>print(8.65);  // Type Argument can be inferred not required explicitly
    }

    static class Printer {
        <T> void print(T item){
            System.out.println(item.toString());
        }
    }
}
