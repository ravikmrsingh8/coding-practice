# [Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/description/)
https://leetcode.com/problems/product-of-array-except-self/description/
<hr />

### Problem Statement
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

#### Example 1:

```
Input: nums = [1,2,3,4]
Output: [24,12,8,6]
```
#### Example 2:

```
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
```
#### Constraints:
- 2 <= nums.length <= 10^5
- -30 <= nums[i] <= 30
- The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

<hr />

### Solution

[ProductOfArray.java](../../src/main/java/org/example/hashing/ProductOfArray.java)

```java
package org.example.hashing;

import java.util.Arrays;

public class ProductOfArray {
    public int[] productExceptSelf(int[] nums) {
        int N = nums.length;
        int[] ans = new int[N];

        // Get product of prefix array
        ans[0] = 1;
        for(int i=1; i<N; i++) {
            ans[i] = ans[i-1] * nums[i-1];
        }
        //System.out.println(Arrays.toString(ans));

        // Keep track of post product and multiply the ans array with post product
        int post = 1;
        for (int i=N-2; i>=0; i--) {
            post = post * nums[i+1];
            ans[i] = ans[i] * post;
        }
        //System.out.println(Arrays.toString(ans));
        return ans;
    }

    public static void main(String[] args) {
        ProductOfArray product = new ProductOfArray();
        int[] arr = product.productExceptSelf(new int[]{1,2,3,4});
        System.out.println(Arrays.toString(arr));

        arr = product.productExceptSelf(new int[]{-1,1,0,-3,3});
        System.out.println(Arrays.toString(arr));

    }
}

```