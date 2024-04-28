package org.example.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestInStream {
    PriorityQueue<Integer> q= new PriorityQueue<Integer>();
    int k = 0;
    int[] nums;

    public KthLargestInStream(int k, int[] nums) {
        this.nums = nums;
        this.k = k;
        if(nums.length > 0) init();
    }

    private void init() {
        int N = Math.min(k, nums.length);
        for (int i = 0; i < N; i++) q.offer(nums[i]);
        if (k < nums.length) {
            for (int i=k; i<nums.length; i++) {
                if(nums[i] > q.peek()) {
                    q.poll();
                    q.offer(nums[i]);
                }
            }
        }

    }

    public int add(int val) {
        if(q.size() < k) {
            q.offer(val);
        } else if(q.peek() < val) {
            q.poll();
            q.offer(val);
        }
        return q.peek();
    }

    public static void main(String[] args) {
        KthLargestInStream stream = new KthLargestInStream(3, new int[]{4, 5, 8, 2});
        int[] res = new int[]{stream.add(3), stream.add(5), stream.add(10), stream.add(9), stream.add(4)};
        System.out.println(Arrays.toString(res));
    }
}
