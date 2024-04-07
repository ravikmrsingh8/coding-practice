package org.example.heap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LastStoneWeightTest {
    @Test
    @DisplayName("Last stone weight test1")
    public void test1() {
        LastStoneWeight obj = new LastStoneWeight();
        int[] stones = {2,7,4,1,8,1};
        int stone = obj.lastStoneWeight(stones);
        assertEquals(1, stone);
    }

    @Test
    @DisplayName("Last stone weight test2")
    public void test2() {
        LastStoneWeight obj = new LastStoneWeight();
        int[] stones = {1};
        int stone = obj.lastStoneWeight(stones);
        assertEquals(1, stone);
    }

    @Test
    @DisplayName("Last stone weight test3")
    public void test3() {
        LastStoneWeight obj = new LastStoneWeight();
        int[] stones = {};
        int stone = obj.lastStoneWeight(stones);
        assertEquals(0, stone);
    }
}
