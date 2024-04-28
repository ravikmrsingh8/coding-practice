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
