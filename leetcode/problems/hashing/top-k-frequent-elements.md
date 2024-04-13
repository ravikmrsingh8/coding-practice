# [Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/description/)
https://leetcode.com/problems/top-k-frequent-elements/description/

<hr />

### Problem Statement
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.


#### Example 1
```
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
```

#### Example 2
```
Input: nums = [1], k = 1
Output: [1]
```

Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

<hr />

### Solution
[TopElements.java](../../src/main/java/org/example/hashing/TopElements.java)  
```java
package org.example.hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Long> map = new HashMap<>();
        for(int num: nums) map.put(num, 1 + map.getOrDefault(num, 0L));

        PriorityQueue<Map.Entry<Integer, Long>> queue = new PriorityQueue<>((e1, e2) -> (int)(e1.getValue()-e2.getValue()));
        var entries = map.entrySet().stream().toList();
        for (int i = 0; i < k; i++) {
            queue.offer(entries.get(i));
        }

        for (int i = k; i < entries.size(); i++) {
            var entry = queue.peek();
            if (entry != null && entry.getValue() < entries.get(i).getValue()) {
                queue.poll();
                queue.offer(entries.get(i));
            }
        }

        return queue.stream()
                .map(Map.Entry::getKey)
                .mapToInt(Integer::intValue)
                .toArray();
    }
}

```