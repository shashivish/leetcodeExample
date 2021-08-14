package com.example.leetcode.medium;

//https://leetcode.com/problems/remove-nth-node-from-end-of-list/solution/
public class L19_RemoveNthNodeFromList {

    public static void main(String[] args) {


    }

    //My Logic
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode node = head;
        ListNode prevNode = head;
        ListNode result = new ListNode(0);
        result.next = prevNode;
        int counter = 1;

        int length = 0;

        //Find Length of LinkedList
        while (head != null) {
            length++;
            head = head.next;
        }

        System.out.println("Length Found " + length);
        System.out.println("Value " + node.val);


        if (length == n) {
            return result.next.next;
        }

        while (node != null) {

            if (counter == (length - n + 1)) {
                //Remove Node Logic
                prevNode.next = node.next;
                node = null;
                break;
            } else {
                counter++;
            }
            prevNode = node;
            node = node.next;
        }

        return result.next;

    }

    //Solution from Leet Code Time complexity : O(L).
    public ListNode removeNthFromEndOptimized(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length = 0;
        ListNode first = head;
        while (first != null) {
            length++;
            first = first.next;
        }
        length -= n;
        first = dummy;
        while (length > 0) {
            length--;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }


    //* Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
