package com.example.leetcode.easy;

public class LT02_AddTwoNumbers {

    /**
     * Definition for singly-linked list.
     */
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode resultNode = new ListNode();
        ListNode l3 = new ListNode(0, null);
        resultNode = l3;


        int carry = 0;

        while(l1 != null || l2 != null)
        {
            int sum = 0;

            int x = 0;
            int y = 0;

            x=(l1 != null) ? l1.val : 0;
            y=(l2 != null ) ? l2.val : 0;

            sum = x + y + carry;
            carry = sum/10;
            int remainder = sum %10;

            l3.next =  new ListNode(remainder);

            System.out.println("Carry and  RM " + carry + " " + remainder);
            l3 = l3.next;

            if ( l2 != null) l2 = l2.next;
            if ( l1 != null) l1 = l1.next;

        }

        // If carry is remaining
        if (carry > 0) {
            l3.next = new ListNode(carry);
        }

        return resultNode.next;
    }
}
