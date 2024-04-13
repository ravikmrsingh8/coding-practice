package org.example.hashing;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 Input: nums = [100,4,200,1,3,2]
 Output: 4
*/
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int result = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int curr = num;
                int count = 1;
                while(set.contains(curr + 1)) {
                    count++;
                    curr++;
                }
                result = Math.max(count, result);
            }
        }
        return result;
    }
}
