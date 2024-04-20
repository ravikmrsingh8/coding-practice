# [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/description/)
https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
<hr />

### Problem Statement
Given a string s, find the length of the longest substring without repeating characters.

#### Example 1:

```
Input: s = "abcabcbb"
Output: 3
```
Explanation: The answer is "abc", with the length of 3.
#### Example 2:

```
Input: s = "bbbbb"
Output: 1
```
Explanation: The answer is "b", with the length of 1.
#### Example 3:

```
Input: s = "pwwkew"
Output: 3
```
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

<hr />

### Solution

[LongestSubstring.java](../../src/main/java/org/example/slidingwindow/LongestSubstring.java)

```java
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

```