package org.example.hashing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GroupAnagramTest {

    @Test
    void groupAnagramTest1() {
        String[] strings =  {"eat","tea","tan","ate","nat","bat"};
        GroupAnagram anagrams = new GroupAnagram();
        List<List<String>> groups =  anagrams.groupAnagrams(strings);

        for (List<String> list: groups) {
            if (list.contains("eat")) {
               Assertions.assertIterableEquals(list, List.of("eat", "tea", "ate"));
            } else if (list.contains("tan")) {
                Assertions.assertIterableEquals(list, List.of("tan", "nat"));
            } else if(list.contains("bat")) {
                Assertions.assertIterableEquals(list, List.of("bat"));
            }
        }
    }
}
