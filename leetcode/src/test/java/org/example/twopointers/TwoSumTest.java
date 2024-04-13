package org.example.twopointers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {

    @Test
    @DisplayName("Two Sum Test1 in Sorted Array")
    public void findTwoSumInSortedArray1() {
        TwoSum sum = new TwoSum();
        int[] indexes = sum.twoSum(new int[]{2,7,11,15}, 9);
        assertArrayEquals(new int[]{1, 2}, indexes);
    }

    @Test
    @DisplayName("Two Sum Test2 in Sorted Array")
    public void findTwoSumInSortedArray2() {
        TwoSum sum = new TwoSum();
        int[] indexes = sum.twoSum(new int[]{2,3,4}, 6);
        assertArrayEquals(new int[]{1, 3}, indexes);
    }

    @Test
    @DisplayName("Two Sum Test3 in Sorted Array")
    public void findTwoSumInSortedArray3() {
        TwoSum sum = new TwoSum();
        int[] indexes = sum.twoSum(new int[]{-1,0}, -1);
        assertArrayEquals(new int[]{1, 2}, indexes);
    }

}