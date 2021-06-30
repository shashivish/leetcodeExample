package com.example.leetcode.easy;

import java.util.ArrayList;

/**
 * Given an array of 0s and 1s, find the position of 0 to be replaced with 1 to get longest continuous sequence of 1s. Expected time complexity is O(n) and auxiliary space is O(1).
 * <p>
 * Example:
 * <p>
 * Input:
 * arr[] =  {1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1}
 * Output:
 * Max 7
 * Assuming array index starts from 0, replacing 0 with 1 at index 9 causes
 * the maximum continuous sequence of 1s.
 * <p>
 * Input:
 * arr[] =  {1, 1, 1, 1, 0}
 * Output:
 * Max  4
 * <p>
 * Question Link : https://www.geeksforgeeks.org/find-index-0-replaced-1-get-longest-continuous-sequence-1s-binary-array/
 */
public class LongestOneSequence {
    public static void main(String[] args) {
        int[] input = {1, 1, 0, 0, 1, 1, 1, 0, 1, 0};

        ArrayList<Integer> intermediateArray = new ArrayList();
        int sequenceCounter = 0;

        for (int itr = 0; itr < input.length; itr++) {
            if (input[itr] == 1) {
                sequenceCounter = sequenceCounter + input[itr];
            } else {
                if (sequenceCounter != 0) {
                    intermediateArray.add(sequenceCounter);
                    sequenceCounter = 0;
                }
                intermediateArray.add(input[itr]);
            }
        }

        System.out.println(intermediateArray);

        int maxSequenceSize = 0;
        for (int i = 0; i < intermediateArray.size(); i = i + 2) {

            int len  = intermediateArray.get(i);

            if (i+1 < intermediateArray.size())
                len+=1;

            if (i+2 < intermediateArray.size())
                len+=intermediateArray.get(i+2);


            if (len > maxSequenceSize)
                maxSequenceSize = len;

        }

        System.out.println("Max Size : " + maxSequenceSize);

    }
}
