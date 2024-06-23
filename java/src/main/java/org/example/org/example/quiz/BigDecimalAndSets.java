package org.example.org.example.quiz;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class BigDecimalAndSets {
    public static void main(String[] args) {
        BigDecimal val1 = new BigDecimal("4.0");
        BigDecimal val2 = new BigDecimal("4.00");

        // Equals returns false because of differing precision
        System.out.println("val1.equals(val2) = " + val1.equals(val2));
        // CompareTo returns 0 implying both objects are equal
        System.out.println("val1.compareTo(val2) = " + val1.compareTo(val2));

        // HashSet uses equals() method and ends up storing
        // two objects
        Set<BigDecimal> hashSet = new HashSet<>();
        hashSet.add(val1);
        hashSet.add(val2);
        System.out.println("hashSet.size() = " + hashSet.size());

        // TreeSet uses compareTo() method and ends up storing
        // a single object
        Set<BigDecimal> treeSet = new TreeSet<>();
        treeSet.add(val1);
        treeSet.add(val2);
        System.out.println("treeSet.size() = " + treeSet.size());
    }
}
