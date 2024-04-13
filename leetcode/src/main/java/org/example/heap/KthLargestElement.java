package org.example.heap;

import java.util.PriorityQueue;

public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0; i<k; i++) queue.offer(nums[i]);

        for(int i=k; i<nums.length; i++) {
            Integer top = queue.peek();
            if(top != null && top < nums[i]) {
                queue.poll();
                queue.offer(nums[i]);
            }
        }
        if(!queue.isEmpty()) {
            return queue.peek();
        }
        throw new RuntimeException("No Solution found!");
    }
}
