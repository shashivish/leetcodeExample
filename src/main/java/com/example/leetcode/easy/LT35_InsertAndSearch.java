package com.example.leetcode.easy;

class LT35_InsertAndSearch {

    public static void main(String[] args) {

    }
    public int searchInsert(int[] nums, int target) {

        int index = binarySearch(nums,target,true);

        return index;
    }

    public int binarySearch(int[] nums , int target, boolean flag)
    {
        int low = 0;
        int high = nums.length -1;
        while(high >= low)
        {

            int mid = low+(high-low)/2;

            // Search Till Value if Found
            if(nums[mid] == target)
                return mid;

            if(target > nums[mid])
                low = mid+1;
            else
                high = mid -1;

        }

        return low;

    }
}
