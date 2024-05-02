package org.example.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumToZero {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();

        for(int i=0; i < nums.length - 2; i++) {
            if (i>0 && nums[i] == nums[i-1]) {
                continue;
            }

            int low = i + 1;
            int high = nums.length - 1;
            while(low < high) {
                int num = nums[i] + nums[low] + nums[high];
                if(num == 0) {
                    triplets.add(List.of(nums[i], nums[low], nums[high]));
                    while(low < high  && nums[low] == nums[low + 1]) low++;
                    while(low < high && nums[high] == nums[high -1]) high--;
                    low++;
                    high--;
                }  else if(num < 0){
                    low++;
                } else {
                    high--;
                }
            }
        }
        return triplets;
    }

    public static void main(String[] args) {

    }
}
