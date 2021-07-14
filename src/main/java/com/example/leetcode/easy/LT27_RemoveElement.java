package com.example.leetcode.easy;

public class LT27_RemoveElement {
    public static void main(String[] args) {

        int nums[] = {0,1,2,2,3,0,4,2};

        LT27_RemoveElement l = new LT27_RemoveElement();
        System.out.println(l.removeElement(nums,2));
    }

    public int removeElement(int[] nums, int val) {


        int count  = 0;
        int j  = 1;

        if (nums.length == 0 || nums == null)
            return 0;

        if (nums.length == 1)
        {
            if (nums[0] ==val )
                return 0;
        }




        for(int i= 0 ; i < nums.length ; i++)
        {
            if( j <  nums.length)
            {
                if(nums[i] == val)
                {
                    while( nums[j] == val )
                    {
                        j++;
                        if (j >= nums.length)
                        {
                            break;
                        }
                    }

                    if( j <  nums.length) {
                        int tmp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = tmp;
                        j++;
                    }
                }
                else
                {
                    j++;
                }


            }
        }


        for( int i = 0 ; i< nums.length ; i++)
        {
            if (nums[i] != val)
            {
                count++;
            }
        }


        return count;
    }
}
