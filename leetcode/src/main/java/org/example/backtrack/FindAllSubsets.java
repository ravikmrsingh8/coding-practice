package org.example.backtrack;

import java.util.ArrayList;
import java.util.List;

public class FindAllSubsets {

    public static void main(String[] args) {
        FindAllSubsets subsets = new FindAllSubsets();
        System.out.println(subsets.subsets(new int[]{1,2,3}));
        System.out.println(subsets.subsets(new int[]{1,2}));
        System.out.println(subsets.subsets(new int[]{1,2,3,4}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list= new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        subsets(list, subset, 0, nums);
        return list;
    }

    void subsets(List<List<Integer>> list, List<Integer> subset, int index, int[] nums) {
        if(index == nums.length) {
            list.add(new ArrayList<>(subset));
        } else {
            subset.add(nums[index]);
            subsets(list, subset, index + 1, nums);
            subset.removeLast();
            subsets(list, subset, index + 1, nums);
        }

    }
}
