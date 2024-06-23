package org.example.generics.quiz;

import java.util.ArrayList;
import java.util.List;

public class Assignments {

    public static void main(String[] args) {
        List<Integer> list0 = List.of(1,2,3);
        List<Double> list1 = List.of(1.0,2.0,3.0);
        List<Long> list2 = List.of(1L,2L,3L);

        print(list0);
        print(list1);
        print(list2);

        printNumbers(list0);
        printNumbers(list1);
        printNumbers(list2);

        List<? super Integer> nums = new ArrayList<>();
        nums.add(4);
        nums.add(5);
        System.out.println(nums);

        List<? extends Number> nums2 = new ArrayList<>();
        //nums2.add(2.5); Not allowed , we can only read values

    }


    static void print(List<? extends Number> nums) {
        System.out.println(nums);
    }


    static void printWithWildCard(List<?> nums) {
        System.out.println(nums);
    }

    static <T extends Number>  void printNumbers(List<T> numbers) {
        System.out.println(numbers);
    }
}
