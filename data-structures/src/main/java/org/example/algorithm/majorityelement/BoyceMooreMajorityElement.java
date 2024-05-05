package org.example.algorithm.majorityelement;

import java.util.Optional;

public class BoyceMooreMajorityElement {
    public Optional<Integer> majorityElement(int[] nums) {
        int candidate = findCandidate(nums);
        if  (hasMajority(candidate, nums)) {
            return Optional.of(candidate);
        }
        return Optional.empty();
    }

    private boolean hasMajority(int candidate, int[] nums) {
        int count = 0;
        for(int num: nums) {
            if(num == candidate) count++;
        }
        return count > nums.length/2;
    }

    public int findCandidate(int[] nums) {
        int majIndex = 0;
        int count = 1;
        for(int i=1; i<nums.length; i++) {
            if(nums[majIndex] == nums[i]) {
                count++;
            } else {
                count--;
                if(count == 0) {
                    count = 1;
                    majIndex = i;
                }
            }
        }
        return nums[majIndex];
    }

}
