package org.example.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindPermutations {
    public static void main(String[] args) {
        FindPermutations obj = new FindPermutations();
        var permutations = obj.permute(new int[]{1,2,3});
        System.out.println(permutations);
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutes =  permute(nums, 0);
        return permutes;
    }

    private List<List<Integer>> permute(int[] nums, int i) {
        if(i == nums.length - 1 ) {
            List<List<Integer>> list = new ArrayList<>();
            list.add(new ArrayList<>(Arrays.asList(nums[i])));
            return list;
        }

        List<List<Integer>> permutations = permute(nums, i+1);
        List<List<Integer>> allPer = new ArrayList<>();

        int iNum = nums[i];
        for(List<Integer> permutation : permutations) {
            for(int j=0; j <= permutation.size(); j++) {
                List<Integer> newPerm = new ArrayList<>(permutation);
                newPerm.add(j, iNum);
                allPer.add(newPerm);
            }
        }
        return allPer;
    }
}
