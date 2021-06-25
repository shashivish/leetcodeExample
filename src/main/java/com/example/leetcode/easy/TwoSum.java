package com.example.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {

        /**
        Input: nums = [2,7,11,15], target = 9
        Output: [0,1]
        Output: Because nums[0] + nums[1] == 9, we return [0, 1].
        **/

        int nums[] = {2,7,11,15};

        TwoSum twoSum = new TwoSum();

        int[] output = twoSum.twoSum(nums,19);
        for (int i =0 ; i < output.length ;i++ )
        {
            System.out.println(output[i]);
        }

    }
    public int[] twoSum(int[] nums, int target) {


        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }



}
