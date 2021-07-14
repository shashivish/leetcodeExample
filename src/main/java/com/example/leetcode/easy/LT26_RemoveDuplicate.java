package com.example.leetcode.easy;

public class LT26_RemoveDuplicate {

    public static void main(String[] args) {

        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        LT26_RemoveDuplicate l = new LT26_RemoveDuplicate();
        l.removeDuplicates(nums);

    }

    public int removeDuplicates(int[] nums) {

        if (nums.length == 0)
            return 0;

        if (nums.length == 1)
            return 1;


        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] != 101 && nums[j] != 101) {
                    if (nums[i] == nums[j]) {
                        nums[j] = 101;
                    } else {
                        break;
                    }
                }

            }
        }


        for (int i = 0; i < nums.length; i++)
            System.out.println(nums[i]);


        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 101) {
                int nextNullElementPosition = findNextNonNullElement(i + 1, nums);
                if (nextNullElementPosition != 0) {
                    nums[i] = nums[nextNullElementPosition];
                    nums[nextNullElementPosition] = 101;
                }
            }

        }

        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 101) {
                counter++;
            }
        }


        for (int i = 0; i < nums.length; i++)
            System.out.println(nums[i]);

        return counter;

    }

    public int findNextNonNullElement(int start, int[] nums) {
        for (int i = start; i < nums.length; i++) {
            if (nums[i] != 101)
                return i;
        }

        return 0;
    }
}
