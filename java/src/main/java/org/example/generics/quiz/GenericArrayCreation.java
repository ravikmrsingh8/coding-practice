package org.example.generics.quiz;

import java.util.ArrayList;
import java.util.List;

public class GenericArrayCreation {
    public static void main(String[] args) {
        MyGenArry<String> str= new MyGenArry<>(10);
        str.add("Blue");
        str.print();

        //See implementation of Arraylist in jdk
        List<Integer> list = new ArrayList<>();
        System.out.println(list);
    }
}


class MyGenArry<T> {
    T[] arr;
    int index = 0;
    MyGenArry(int size) {
        arr = (T[])(new Object[size]);
    }

    void add(T item) {
        arr[index++] = item;
    }
    void print() {
        for(T item: arr) {
            System.out.println(item);
        }
    }

}