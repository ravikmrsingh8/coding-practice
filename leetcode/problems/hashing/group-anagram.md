# [Group Anagrams](https://leetcode.com/problems/group-anagrams/description/)
https://leetcode.com/problems/group-anagrams/description/


## Problem Statement
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.



### Example 1:
```
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
```
### Example 2:
```
Input: strs = [""]
Output: [[""]]
```
### Example 3:
```
Input: strs = ["a"]
Output: [["a"]]
```
## Solution
[GroupAnagram.java](../../src/main/java/org/example/hashing/GroupAnagram.java) 
```java
package org.example.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */
public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            String sorted = sortedString(str);
            List<String> groups = map.getOrDefault(sorted, new ArrayList<>());
            groups.add(str);
            map.put(sorted, groups);
        }
        return map.values().stream().toList();
    }

    private String sortedString(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

}

```
