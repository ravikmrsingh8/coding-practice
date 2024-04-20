package org.example.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int N = s.length();
        char[] arr = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int left = 0;
        int count = 0;
        for (int right=0; right<N; right++) {
            while(set.contains(arr[right]) && left <= right) {
                set.remove(arr[left]);
                left++;
            }
            set.add(arr[right]);
            count = Math.max(set.size(), count);

        }
        return count;
    }
}
