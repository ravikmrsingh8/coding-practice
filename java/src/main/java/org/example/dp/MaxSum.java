package org.example.dp;


public class MaxSum {
    public static int maxSumNoConsecutive(int[] arr) {
        int incl = 0; // Maximum sum including the previous element
        int excl = 0; // Maximum sum excluding the previous element

        for (int num : arr) {
            // Current max excluding num (No two consecutive elements allowed)
            int newExcl = Math.max(incl, excl);

            // Current max including num
            incl = excl + num;
            excl = newExcl;
        }

        // Return the maximum of incl and excl
        return Math.max(incl, excl);
    }

    public static void main(String[] args) {
        int[] stream = {3, 2, 7, 10};
        System.out.println("Maximum sum with no consecutive elements: " + maxSumNoConsecutive(stream));
    }
}