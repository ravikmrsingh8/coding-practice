# [Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/description/)
https://leetcode.com/problems/longest-consecutive-sequence/description/

<hr />

### Problem Statement 
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.


#### Example 1
```
Input: nums = [100,4,200,1,3,2]
Output: 4
```
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

#### Example 2
```
Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
```

<hr />

### Solution
[LongestConsecutiveSequence.java](../../src/main/java/org/example/hashing/LongestConsecutiveSequence.java)  
```java
package org.example.hashing;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 Input: nums = [100,4,200,1,3,2]
 Output: 4
*/
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int result = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int curr = num;
                int count = 1;
                while(set.contains(curr + 1)) {
                    count++;
                    curr++;
                }
                result = Math.max(count, result);
            }
        }
        return result;
    }
}

```