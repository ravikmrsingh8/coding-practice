# [Single Number](https://leetcode.com/problems/single-number/description/)
https://leetcode.com/problems/single-number/description/
<hr />

### Problem Statement
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.

#### Example 1:

```
Input: nums = [2,2,1]
Output: 1
```
#### Example 2:

```
Input: nums = [4,1,2,1,2]
Output: 4
```
#### Example 3:

```
Input: nums = [1]
Output: 1
```

<hr />

### Solution

[SingleNumber.java](../../src/main/java/org/example/bit/SingleNumber.java)

```java
package org.example.bit;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int res = nums[0];
        for(int i=1; i<nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}

```