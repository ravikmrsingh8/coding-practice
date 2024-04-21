package org.example.bit;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int res = 0;
        for(int num: nums) res ^=num;
        for(int i=0; i<=nums.length; i++) res ^= i;
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {9,6,4,2,3,5,7,0,1};
        MissingNumber missing = new MissingNumber();
        System.out.println(missing.missingNumber(nums));
    }
}
