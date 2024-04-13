package org.example.twopointers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerWithMostWaterTest {

    @Test
    @DisplayName("Container with most water Test1")
    public void test1() {
        ContainerWithMostWater solution = new ContainerWithMostWater();
        int maxWater = solution.maxArea(new int[] {1,8,6,2,5,4,8,3,7});
        assertEquals(49, maxWater);
    }

    @Test
    @DisplayName("Container with most water Test2")
    public void test2() {
        ContainerWithMostWater solution = new ContainerWithMostWater();
        int maxWater = solution.maxArea(new int[] {1,1});
        assertEquals(1, maxWater);
    }
}