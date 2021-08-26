package com.example.leetcode.medium;

public class LT34_FirstAndLastElementinSortedArrays {

    public static void main(String[] args) {

        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        LT34_FirstAndLastElementinSortedArrays t = new LT34_FirstAndLastElementinSortedArrays();
        t.searchRange(nums,target);
    }

    public int[] searchRange(int[] nums, int target) {

        int[] result = {-1,-1};
        int left = 0;
        int right = nums.length-1;

        if(nums.length == 0)
            return result;

        int firstPosition = findByBinarySearch(left,right,target,nums,true);
        //   System.out.println("First Position Found" + firstPosition);

        if (firstPosition == -1) {
            return new int[]{-1, -1};
        }

        int secondPosition = findByBinarySearch(left,right,target,nums,false);
        //  System.out.println("Second Position Found" + secondPosition);

        result[0] = firstPosition;
        result[1] = secondPosition;

        return result;

    }


    public int findByBinarySearch(int left , int right , int target,int[] nums , boolean isFirst)
    {

        // System.out.println("In Binary Search");
        int mid = -1;
        while(left <= right)
        {

            mid = (left+right)/2;

            if(nums[mid] == target)
            {

                if(isFirst)
                {
                    if(mid == 0 || nums[mid-1] != target)
                        return mid;

                    right = mid -1;
                }else
                {
                    if(mid == nums.length -1 || nums[mid+1] != target)
                        return mid;

                    left = mid +1;

                }

            }
            else
            {
                if(target > nums[mid])
                    left = mid+1;
                else
                    right = mid -1;
            }



        }

        return -1;

    }
}
