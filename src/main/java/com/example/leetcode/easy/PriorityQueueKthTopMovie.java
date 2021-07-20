package com.example.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Use of Priority Queue Example
 * Priority Queue - Inserts element in sorted order.
 */

public class PriorityQueueKthTopMovie {
    public static void main(String[] args) {

        // Array List contains movie rating.
        int[] array = {3,4,5,2,4,5,1,1,2};
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int k =3;
        for (int i = 0 ; i < array.length ; i++)
        {

            pq.add(array[i]);

            if (pq.size() > k)
            {
                pq.poll();
            }
            System.out.println(pq.toString());
        }



    }
}
