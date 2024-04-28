# [Search a 2D Matrix](https://leetcode.com/problems/search-a-2d-matrix/description/)
https://leetcode.com/problems/search-a-2d-matrix/description/
<hr />

### Problem Statement
You are given an m x n integer matrix with the following two properties:

- Each row is sorted in non-decreasing order.
- The first integer of each row is greater than the last integer of the previous row.

Given an integer target, return true if target is in matrix or false otherwise.
You must write a solution in O(log(m * n)) time complexity.

#### Example 1:
![image](./mat.jpg)
```
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
```
#### Example 2:

```
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
```

<hr />

### Solution

[SearchIn2DMatrix.java](../../src/main/java/org/example/binarysearch/SearchIn2DMatrix.java)

```java
package org.example.binarysearch;

public class SearchIn2DMatrix {
    //O(log(M) + log(N)) Solution
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROW = matrix.length;
        int COL = matrix[0].length;

        int top = 0, bot = ROW - 1, mid = 0;
        while(top <= bot) {
            mid = (top + bot)/2;
            if (target > matrix[mid][COL-1]) {
                top = mid + 1;
            } else if (target < matrix[mid][0]) {
                bot = mid - 1;
            } else {
                break;
            }
        }

        int low = 0;
        int high = COL - 1;
        int[] arr = matrix[mid];
        while(low <= high) {
            int middle = low + (high - low)/2;
            if (arr[middle] == target) {
                return true;
            } else if (arr[middle] > target) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return false;
    }



    //O(M + N) Solution
    boolean searchMatrix0(int[][] matrix, int target) {
        int M = matrix.length, N = matrix[0].length;
        int i = 0, j = N - 1;

        while(i < M && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j = j - 1;
            } else {
                i = i + 1;
            }
        }
        return false;
    }
}

```