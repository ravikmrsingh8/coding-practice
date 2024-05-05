package org.example.algorithm.majorityelement;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BoyceMooreMajorityElementTest {

    @Test
    public void testMajorityElement1() {
        int[] nums = new int[]{2,2,1,1,1,2,2};
        BoyceMooreMajorityElement algo = new BoyceMooreMajorityElement();
        Optional<Integer> candidate = algo.majorityElement(nums);
        assertEquals(candidate, Optional.of(2));
    }

    @Test
    public void testMajorityElement2() {
        int[] nums = new int[]{1,1,1,1,2,3,5};
        BoyceMooreMajorityElement algo = new BoyceMooreMajorityElement();
        Optional<Integer> candidate = algo.majorityElement(nums);
        assertEquals(candidate, Optional.of(1));
    }

    @Test
    public void testMajorityElement3() {
        int[] nums = new int[]{1,2,3,4,4,3,2};
        BoyceMooreMajorityElement algo = new BoyceMooreMajorityElement();
        Optional<Integer> candidate = algo.majorityElement(nums);
        assertEquals(candidate, Optional.empty());
    }

}