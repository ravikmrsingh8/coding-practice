# [Kth Largest Element in a Stream](https://leetcode.com/problems/kth-largest-element-in-a-stream/description/)
https://leetcode.com/problems/kth-largest-element-in-a-stream/description/
<hr />

### Problem Statement
Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Implement KthLargest class:

KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element in the stream.

#### Example 1:

```
Input
["KthLargest", "add", "add", "add", "add", "add"]
[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
Output
[null, 4, 5, 5, 8, 8]

Explanation
KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
kthLargest.add(3);   // return 4
kthLargest.add(5);   // return 5
kthLargest.add(10);  // return 5
kthLargest.add(9);   // return 8
kthLargest.add(4);   // return 8
```

<hr />

### Solution

[KthLargestInStream.java](../../src/main/java/org/example/heap/KthLargestInStream.java)

```java
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

```