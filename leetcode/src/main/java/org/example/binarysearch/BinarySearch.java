package org.example.binarysearch;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high --;
            } else {
                low ++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch search = new BinarySearch();
        System.out.println(search.search(new int[]{-1,0,3,5,9,12}, 2));
        System.out.println(search.search(new int[]{-1,0,3,5,9,12}, 9));
    }
}
