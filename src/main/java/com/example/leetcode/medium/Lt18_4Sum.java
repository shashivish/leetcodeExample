package com.example.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lt18_4Sum {

    public static void main(String[] args) {


    }

    //My Logic - 12%
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList();
        List<String> duplicateExclution = new ArrayList();


        if (nums.length < 4)
            return result;
        //Sort Array
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length;


        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                left = j + 1;
                right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        String conact = nums[i] + ":" + nums[j] + ":" + nums[left] + ":" + nums[right];

                        if (!duplicateExclution.contains(conact)) {
                            System.out.println("Found target " + nums[i] + ":" + nums[j] + ":" + nums[left] + ":" + nums[right]);
                            duplicateExclution.add(conact);
                            List<Integer> temp = new ArrayList();
                            temp.add(nums[i]);
                            temp.add(nums[j]);
                            temp.add(nums[left]);
                            temp.add(nums[right]);
                            result.add(temp);

                        } else {
                            // DO nothing
                        }

                        left++;
                        right--;

                    }

                    if (sum < target) {
                        left++;
                    }

                    if (sum > target) {
                        right--;
                    }
                }
            }
        }

        return result;

    }
}
