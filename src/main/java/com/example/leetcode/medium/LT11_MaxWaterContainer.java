package com.example.leetcode.medium;

public class LT11_MaxWaterContainer {

    public static void main(String[] args) {

        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        LT11_MaxWaterContainer t = new LT11_MaxWaterContainer();
        System.out.println(t.maxAreaWith2Pointer(height));

    }


    //Optimize Approach with 2 Pointer
    public int maxAreaWith2Pointer(int[] height) {
        int maxArea = 0;
        int finalMaxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {

            if (height[left] > height[right]) {
                maxArea = height[right] * (right - left);
                right--;
            } else {
                maxArea = height[left] * (right - left);
                left++;
            }

            if (maxArea > finalMaxArea)
                finalMaxArea = maxArea;

            //System.out.println("finalMaxArea :" + finalMaxArea);

        }


        return finalMaxArea;
    }


    //BruteForce Approach
    public int maxArea(int[] height) {

        int maxArea = 0;
        int finalMaxArea = 0;

        if (height.length == 0)
            return finalMaxArea;


        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {

                if (height[i] > height[j]) {
                    maxArea = height[j] * (j - i);
                } else {
                    maxArea = height[i] * (j - i);
                }

                if (maxArea > finalMaxArea)
                    finalMaxArea = maxArea;

            }

            System.out.println("finalMaxArea :" + finalMaxArea);

        }

        return finalMaxArea;

    }
}
