# [Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array/description/)
https://leetcode.com/problems/kth-largest-element-in-an-array/description/

<hr />

### Problem Statement
Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?



#### Example 1
```
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
```

#### Example 2
```
Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
```
<hr />

### Solution
[KthLargestElement.java](../../src/main/java/org/example/heap/KthLargestElement.java)    
```java
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

```