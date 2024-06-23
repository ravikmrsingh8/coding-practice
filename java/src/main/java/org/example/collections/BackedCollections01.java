package org.example.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BackedCollections01 {

    static class Student {
        String name;

        Student(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "[" + name + ","+ hashCode() +"]";
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student("Ram");
        Student s2 = new Student("Ram");
        Student s3 = new Student("Ram");
        Student s4 = new Student("Ram");

        List<Student> list1 = new ArrayList<>();
        list1.add(s1);list1.add(s2);list1.add(s3);list1.add(s4);
        System.out.println(list1);

        List<Student> list2 = new ArrayList<>(list1);
        System.out.println(list2);
        list2.get(0).name = "Mohan";


        System.out.println(list1);
        System.out.println(list2);
    }
}
