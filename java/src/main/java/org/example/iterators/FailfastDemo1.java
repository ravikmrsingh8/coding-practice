package org.example.iterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FailfastDemo1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator<Integer> itr = list.iterator();


        while(itr.hasNext()) {
            System.out.println(itr.next());
        //    list.add(5); // throws ConcurrentModification Exception
        }

        for(int num: list) {
            System.out.println(num);
            //list.add(5); // throws ConcurrentModification Exception
        }


        // This works as modification been done by only one iterator
        Iterator<Integer> itr2 = list.iterator();
        int i = 1;
        while(itr2.hasNext()) {
            i++;
            System.out.println(itr2.next());
            if(i == 2) {
                itr2.remove();
            }

        }

        System.out.println(list);



        //--------------------
        List<Integer> list2= new ArrayList<>();
        list2.add(1);list2.add(1);list2.add(1);list2.add(1);
        Iterator<Integer> itr3 = list2.iterator();
        Iterator<Integer> itr4 = list2.iterator();

        System.out.println(list2);

        while(itr3.hasNext()) {
            itr3.next();
            itr4.next();
            itr4.remove();
        }

        System.out.println(list2);

    }
}
