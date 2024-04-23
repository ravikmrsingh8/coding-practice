# [Contains Duplicate](https://leetcode.com/problems/contains-duplicate/description/)
https://leetcode.com/problems/contains-duplicate/description/
<hr />

### Problem Statement
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

#### Example 1:

```
Input: nums = [1,2,3,1]
Output: true
```
#### Example 2:

```
Input: nums = [1,2,3,4]
Output: false
```
#### Example 3:

```
Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true
```

<hr />

### Solution

[ContainsDuplicate.java](../../src/main/java/org/example/hashing/ContainsDuplicate.java)

```java
package org.example.hashing;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums ){
            if(set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate obj = new ContainsDuplicate();
        System.out.println(obj.containsDuplicate(new int[] {1,2,3,1}));

    }
}

```