package org.example.hashing;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/***
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 */
class TopElementsTest {
    @Test
    void topKElementsTest1() {
        int[] nums = {1,1,1,2,2,3};
        TopElements topElements = new TopElements();
        int[] actual = topElements.topKFrequent(nums, 2);
        int[] expected = {2,1};
        Assertions.assertArrayEquals(expected, actual);
    }

}