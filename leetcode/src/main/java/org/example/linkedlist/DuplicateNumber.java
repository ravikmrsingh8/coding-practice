package org.example.linkedlist;

public class DuplicateNumber {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public static void main(String[] args) {
        DuplicateNumber numbers = new DuplicateNumber();
        System.out.println(numbers.findDuplicate(new int[]{1,3,4,2,2}));
        System.out.println(numbers.findDuplicate(new int[]{3,1,3,4,2}));
        System.out.println(numbers.findDuplicate(new int[]{3,3,3,3,3}));

    }
}
