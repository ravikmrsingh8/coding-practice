package org.example.heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KthLargestElementTest {

    @Test
    public void findKthLargestTest1() {
        int[] nums = {3,2,1,5,6,4};
        KthLargestElement obj = new KthLargestElement();
        assertEquals(5,obj.findKthLargest(nums, 2));
    }

    @Test
    public void findKthLargestTest2() {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        KthLargestElement obj = new KthLargestElement();
        assertEquals(4,obj.findKthLargest(nums, 4));
    }
}