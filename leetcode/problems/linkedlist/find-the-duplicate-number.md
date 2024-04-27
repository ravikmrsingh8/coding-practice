# [Find the Duplicate Number](https://leetcode.com/problems/find-the-duplicate-number/description/)
https://leetcode.com/problems/find-the-duplicate-number/description/
<hr />

### Problem Statement
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.

#### Example 1:

```
Input: nums = [1,3,4,2,2]
Output: 2
```
#### Example 2:

```
Input: nums = [3,1,3,4,2]
Output: 3
```
#### Example 3:

```
Input: nums = [3,3,3,3,3]
Output: 3
```

<hr />

### Solution

[DuplicateNumber.java](../../src/main/java/org/example/linkedlist/DuplicateNumber.java)

```java
package org.example.linkedlist;

public class DuplicateNumber {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public static void main(String[] args) {
        DuplicateNumber numbers = new DuplicateNumber();
        System.out.println(numbers.findDuplicate(new int[]{1,3,4,2,2}));
        System.out.println(numbers.findDuplicate(new int[]{3,1,3,4,2}));
        System.out.println(numbers.findDuplicate(new int[]{3,3,3,3,3}));

    }
}

```