package com.example.leetcode.easy;

import java.util.Arrays;

public class Lt88_MergeAndSortArray {

    public static void main(String[] args) {

    }

    //My Logic
    public void merge(int[] nums1, int m, int[] nums2, int n) {


        System.out.println("Found m : " + m + " n :  " + n);


        int[] nums1Copy = new int[m];
        for (int i = 0; i < m; i++) {
            nums1Copy[i] = nums1[i];
        }


        int[] result = new int[m + n];

        int p1 = 0;
        int p2 = 0;
        int r1 = 0;

        while (r1 < m + n) {

            if (p1 < m && p2 < n) {

                if (nums1Copy[p1] == nums2[p2]) {
                    nums1[r1] = nums1Copy[p1];
                    nums1[r1 + 1] = nums2[p2];

                    System.out.println("Adding Twice" + nums1Copy[p1]);
                    //Increment Twice
                    r1++;
                    r1++;

                    // Incremetn Array Pointer
                    p1++;
                    p2++;

                    continue;
                }

                if (nums1Copy[p1] < nums2[p2]) {
                    System.out.println("Adding with position " + r1 + "-->" + nums1Copy[p1]);
                    nums1[r1] = nums1Copy[p1];
                    r1++;
                    p1++;
                    continue;
                }

                if (nums1Copy[p1] > nums2[p2]) {
                    System.out.println("Adding with position " + r1 + "-->" + nums2[p2]);
                    nums1[r1] = nums2[p2];
                    r1++;
                    p2++;
                    continue;
                }
            } else {
                if (p1 < m) {
                    System.out.println("Adding with position " + r1 + "-->" + nums1Copy[p1]);
                    nums1[r1] = nums1Copy[p1];
                    r1++;
                    p1++;
                }

                if (p2 < n) {
                    System.out.println("Adding with position " + r1 + "-->" + nums2[p2]);
                    nums1[r1] = nums2[p2];
                    r1++;
                    p2++;
                }

            }

        }
        // return result;

    }


    // Solution 1

    public void mergeS1(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[i + m] = nums2[i];
        }
        Arrays.sort(nums1);
    }


    //Solution 2 Algorithm

    /**
     * Approach 2 : Three Pointers (Start From the Beginning)
     * Intuition
     * <p>
     * Because each array is already sorted, we can achieve an \mathcal{O}(n + m)O(n+m) time complexity with the help of the two-pointer technique.
     * <p>
     * Algorithm
     * <p>
     * The simplest implementation would be to make a copy of the values in nums1, called nums1Copy, and then use two read pointers and one write pointer to read values from nums1Copy and nums2 and write them into nums1.
     * <p>
     * Initialize nums1Copy to be a new array containing the first m values of nums1.
     * Initialize read pointer p1 to the beginning of nums1Copy.
     * Initialize read pointer p2 to the beginning of nums2.
     * Initialize write pointer p to the beginning of nums1.
     * While p is still within nums1:
     * If nums1Copy[p1] exists and is less than or equal to nums2[p2]:
     * Write nums1Copy[p1] into nums1[p], and increment p1 by 1.
     * Else
     * Write nums2[p2] into nums1[p], and increment p2 by 1.
     * Increment p by 1.
     */

//Same logic as mine
    public void mergeS2(int[] nums1, int m, int[] nums2, int n) {
        // Make a copy of the first m elements of nums1.
        int[] nums1Copy = new int[m];
        for (int i = 0; i < m; i++) {
            nums1Copy[i] = nums1[i];
        }

        // Read pointers for nums1Copy and nums2 respectively.
        int p1 = 0;
        int p2 = 0;

        // Compare elements from nums1Copy and nums2 and write the smallest to nums1.
        for (int p = 0; p < m + n; p++) {
            // We also need to ensure that p1 and p2 aren't over the boundaries
            // of their respective arrays.
            if (p2 >= n || (p1 < m && nums1Copy[p1] < nums2[p2])) {
                nums1[p] = nums1Copy[p1++];
            } else {
                nums1[p] = nums2[p2++];
            }
        }
    }

}