package com.example.leetcode.easy;


import java.util.List;

public class LeetCode21_MergeTwoSortedList {

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode();
        l1.val = 1;

        ListNode t1 = new ListNode();
        t1.val = 2;
        l1.next = t1;

        //l1 = l1.next;
        ListNode t2 = new ListNode();
        t2.val = 4;
        t1.next = t2;


        ListNode l2 = new ListNode();
        l2.val = 1;

        ListNode t11 = new ListNode();
        t11.val = 3;
        l2.next = t11;


        ListNode t22 = new ListNode();
        t22.val = 4;
        t11.next = t22;

        LeetCode21_MergeTwoSortedList l = new LeetCode21_MergeTwoSortedList();
        ListNode  l3 =  l.mergeTwoLists(l1,l2);

        while (l3.next != null)
        {
            System.out.println(l3.val);
            l3 = l3.next;
        }
        System.out.println(l3.val);


    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode l3 = new ListNode(0);
        ListNode pointerNode = l3;
        while(l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pointerNode.next = l1;
                l1 = l1.next;
            } else {
                pointerNode.next = l2;
                l2 = l2.next;
            }
            pointerNode = pointerNode.next;
        }

        if (l1 != null) {
            pointerNode.next = l1;
        } else if (l2 != null) {
            pointerNode.next = l2;
        }

        return l3.next;


    }

}


