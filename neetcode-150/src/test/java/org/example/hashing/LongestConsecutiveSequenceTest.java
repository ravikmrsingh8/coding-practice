package org.example.hashing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestConsecutiveSequenceTest {


    @Test
    @DisplayName("Longest Consecutive Sequence Test 1")
    public void testLongestConsecutiveSequenceLength1() {
        int[] nums = {100,4,200,1,3,2};
        LongestConsecutiveSequence sequence = new LongestConsecutiveSequence();
        int actual = sequence.longestConsecutive(nums);
        int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Longest Consecutive Sequence Test 2")
    public void testLongestConsecutiveSequenceLength2() {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        LongestConsecutiveSequence sequence = new LongestConsecutiveSequence();
        int actual = sequence.longestConsecutive(nums);
        int expected = 9;
        assertEquals(expected, actual);
    }
}